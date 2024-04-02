package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.MessageFormat;
import java.time.Duration;



public class ButtonControl extends WebControl {

    static Logger log = LogManager.getLogger(ButtonControl.class);

    /**
     *  site icindeki button locator türleri buraya yazilmali
     */
    public static final String BUTTON = "//button[contains(., \"{0}\")]";
    public static final String LINK = "//a[contains(., \"{0}\")]";
    public static final String INPUT2 = "(//input[@type=\"{0}\"])[\"{0}\"]";

    public ButtonControl(By locator) {
        super(locator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * bu method button ve ya link locatorini belirten label text'inin alir
     * asagidaki fromLabel() methoduna iletir ve ButtonControl class'ini return eder
     * @param label label'in texti
     * @return ButtonControl nesnesi
     */
    public static ButtonControl fromLabel(String label) {
        return fromLabel(label, 1);
    }

    /**
     * bu method button ve ya link locatorini belirten label text'ini
     * ve index alir. Ayni locatordan belirtilen index'dekini return eder
     * ve ButtonControl class'ini return eder
     * @param label label'in texti
     * @param index
     * @return ButtonControl nesnesi
     */
    public static ButtonControl fromLabel(String label, int index)  {
        String buttonXpath = MessageFormat.format(BUTTON, label);
        String linkXpath = MessageFormat.format(LINK, label);
        String inputXpath = MessageFormat.format(INPUT2, label);

        String xpath = "((" +
                MessageFormat.format(buttonXpath, label) +
                ") | (" +
                MessageFormat.format(inputXpath, label) +
                ") | ("+
                MessageFormat.format(linkXpath, label) +
                "))[" + index +"]";

        By locator = By.xpath(xpath);
        ButtonControl control = new ButtonControl(locator);
        control.label = label;
        return control;
    }

    /**
     * Bu method String olarak xpath locator'i alir
     * ve ButtonControl nesnesi return eder
     * @param locator string olarak xpath
     * @return ButtonControl nesnesi
     */
    public static ButtonControl fromLocator(String locator){
        By textFieldLocator = By.xpath(locator);
        ButtonControl control = new ButtonControl(textFieldLocator);
        control.label = "";
        return control;
    }


    /*
        button ve link ile ilgili ihtiyac duyulan methodlar instance olarak bu class icine yazilmali
        click, isVisible, isClickable, isInvisible, .......
     */


    /**
     * button icin isVisible methodu
     * @return
     */
    public boolean isVisible() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(this.locator));
            return true;
        } catch(Exception e) {
            return false;
        }
    }




}
