package controls;

import org.openqa.selenium.By;

import java.text.MessageFormat;

public class WebElementControl extends WebControl {

    private final static String ELEMENT_XPATH = "(//*[. = \"{0}\"])[{1}]";
    public WebElementControl(By locator) {
        super(locator);
    }

    public static WebElementControl fromLabel(String label) {
        return fromLabel(label, 1);
    }

    public static WebElementControl fromLabel(String label, int no) {
        String xpath = MessageFormat.format(ELEMENT_XPATH, label, no);
        By locator = By.xpath(xpath);
        WebElementControl controller = new WebElementControl(locator);
        controller.label = label;
        return controller;        
    }

    public static WebElementControl fromLocator(By locator)  {
        WebElementControl control = new WebElementControl(locator);
        return control;
    }

    public boolean isVisible() {
        return element.isDisplayed();
    }
    
}
