package stepdefs;

import actions.ButtonActions;
import io.cucumber.java.en.When;

public class ButtonSteps {

    @When("user clicks the {string} button")
    public void clickButton(String label) {
        ButtonActions.click(label);
    }

    @When("user clicks the {int}.th {string} button")
    public void clickButton(int n, String label) {
        ButtonActions.click(label, n);
    }


}
