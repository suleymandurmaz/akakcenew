package actions;


import controls.TextfieldControl;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class TextfieldActions {

    /*
        TextfieldActions icinde input tarzi controllerin islemleri yapilir
        input, date, ....
        Kullanilacak kontrol icin controls package icinde ayrica kontrol olusturulmali
     */

    public static void setText(String label, String value) {
        setText(label, value, 1);
    }

    public static void setText(String label, String value, int no) {
        TextfieldControl
                .fromLabel(label, no)
                .setText(value);
    }

    public static void setTextAndPressTab(String label, String value) {
        TextfieldControl
                .fromLabel(label)
                .setText(value + Keys.TAB);
    }

    public static void setTextAndPressEnter(String label, String value) {
        TextfieldControl
                .fromLabel(label)
                .setText(value + Keys.ENTER);
    }

    public static void checkText(String label, String expectedValue) {
        String actualValue = TextfieldControl
                .fromLabel(label)
                .getText();
        Assert.assertEquals(expectedValue, actualValue);
    }

    public static void waitUntilTextfieldHasValue(String label, String value) {
        TextfieldControl
                .fromLabel(label)
                .waitForValue(value);
    }

    public static void waitUntilTextfieldHasValue(int n, String label, String value) {
        TextfieldControl
                .fromLabel(label,n)
                .waitForValue(value);
    }

    public static void waitUntilContains(String label, String value) {
        TextfieldControl
                .fromLabel(label)
                .waitForContainsValue(value);
    }

}
