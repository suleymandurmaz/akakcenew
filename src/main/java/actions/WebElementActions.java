package actions;

import controls.WebElementControl;
import org.openqa.selenium.By;

public class WebElementActions {

    public static void click(String label) {
        WebElementControl.fromLabel(label)
                .click();
    }

    public static void click(By locator) {
        WebElementControl.fromLocator(locator)
                .click();
    }

}
