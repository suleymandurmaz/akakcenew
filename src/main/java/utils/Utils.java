package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import webdriver.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    /**
     * java ile bekleme methodu
     * Otomasyonda tercih edilen bekleme degildir.
     * @param milis bekleme süresi milisaniye olarak
     */
    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void configureCucumber(){
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        String dryRun = config.getTests().getDryrun() ? "true" : "false";
        System.setProperty("cucumber.execution.dry-run", dryRun);
        String features = config.getTests().getFeatures();
        if (features != null && features.trim().length() > 0) {
            System.setProperty("cucumber.features", features);

        }

        String tags = config.getTests().getTag() == null ? "all" :  config.getTests().getTag();
        if (tags.contains("@"))
            System.setProperty("cucumber.filter.tags", config.getTests().getTag());
    }

    public static void takeScreenShot(String fileName){
        takeScreenShot(null, fileName);
    }

    public static void takeScreenShot(WebElement element, String fileName){
        TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
        File sourceFile, targetFile;
        if (element != null)
            sourceFile = element.getScreenshotAs(OutputType.FILE);
        else
            sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String name = fileName + "_" + now + ".png";
        targetFile = new File("screenshots/" + name);
        try {
            FileUtils.copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
