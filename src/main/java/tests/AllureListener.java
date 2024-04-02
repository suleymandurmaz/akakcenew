package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestConfig;
import utils.TestConfiguration;
import webdriver.Driver;

import java.io.ByteArrayInputStream;

public class AllureListener implements StepLifecycleListener {

    @Override
    public void beforeStepStop(StepResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            WebDriver driver = Driver.getDriver();
            if (driver != null) {
                Allure.attachment("Error Message:", result.getStatusDetails().getMessage());
            }
            Allure.addAttachment("Screenshot:",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else {
            TestConfig config = TestConfiguration.instance().getTestConfiguration();
            if (config.getTests().getScreenshots().equalsIgnoreCase("all")) {
                WebDriver driver = Driver.getDriver();
                if (driver != null) {
                    Allure.addAttachment("Screenshot:",
                            new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                }
            }
        }
    }
}
