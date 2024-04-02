package stepdefs;


import actions.ButtonActions;
import actions.WebElementActions;
import controls.ButtonControl;
import controls.WebElementControl;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class WebElementSteps {



    @When("user clicks with locator type {string} and locator value {string}")
    public void clickButtonLocator(String type, String value) {


        By locator;
        switch (type.toLowerCase()) {
            case "xpath":
                locator = By.xpath(value);
                break;
            case "css":
            case "cssselector":
                locator = By.cssSelector(value);
                break;
            case "id":
                locator = By.id(value);
                break;
            case "tagname":
                locator = By.tagName(value);
                break;
            case "class":
            case "classname":
                locator = By.className(value);
                break;
            case "linktext":
                locator = By.linkText(value);
                break;
            case "partial":
            case "partiallinktext":
                locator = By.partialLinkText(value);
                break;
            default:
                throw new RuntimeException("unrecogrized locator definition");

        }
        WebElementActions.click(locator);
    }

    @Then("^the (WebElement|Button) with label \"([\\w\\W]+)\" should be visible$")
    public void theWebElementWithLabelShouldBeVisible(String type, String label) {
        switch (type){
            case "WebElement":
                Assert.assertTrue(WebElementControl.fromLabel(label).isVisible());
                break;
            case "Button":
                Assert.assertTrue(ButtonControl.fromLabel(label).isVisible());
                break;
        }

    }

    @Then("^I wait for and click \"([^\"]*)\"$")
    public void userIWaitForAndClick(String element) throws InterruptedException {

        element.wait(2000);
        ButtonActions.click(element);



    }
}
