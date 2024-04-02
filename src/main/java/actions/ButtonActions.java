package actions;

import controls.ButtonControl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webdriver.Driver;


public class ButtonActions {



    public static void click(String label, int n) {
        if (n<1) n=1;

        ButtonControl.fromLabel(label,n).click();
    }

    public static void click(String label) {
        scrollUntilTextIsFound(Driver.getDriver("chrome"), label);
        click(label, "a");
    }

    public static void click(String label, String type) {
        switch (type.toLowerCase().trim()) {
            case "locator":
                ButtonControl.fromLocator(label)
                        .click();
                break;
            default:
                ButtonControl.fromLabel(label)
                        .click();

        }
    }


    public static void scrollUntilTextIsFound(WebDriver driver, String targetText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement targetElement = null;
        int scrollAttempts = 0;
        boolean textFound = false;

        try {
            while (scrollAttempts < 10) { // Belirli bir sayıda deneme yapabilirsiniz.

                targetElement = driver.findElement(By.xpath("//button[normalize-space(.)='"+ targetText+"']"));
                if (targetElement.isDisplayed()) {
                    textFound = true;
                    break;
                }
                Thread.sleep(2000);

                js.executeScript("window.scrollTo(0, document.body.scrollHeight + 1000)");

                Thread.sleep(500);
                scrollAttempts++;
            }

            if (textFound) {

                js.executeScript("window.scrollTo(0, document.body.scrollHeight + 1000)");

                System.out.println("Metin bulundu: " + targetText);
            } else {


                System.out.println("Metin bulunamadı: " + targetText);
            }
        } catch (Exception e) {
            System.out.println("Metin bulunamadı: " + targetText);
        }
    }

}
