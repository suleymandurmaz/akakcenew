package stepdefs;

import actions.ApplicationActions;
import actions.TextfieldActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ApplicationSteps extends ApplicationActions{
    @Given("user opens the homepage")
    public void userOpensTheHomepage() {

        gotoHomeSite();

    }

    @When("user into the field {string} enters the value {string} {int}")
    public void userIntoTheFieldEntersTheValue(String name, String value, int no) {
        TextfieldActions.setText(name,value,no);
    }

    @And("user into the field {string} enters the value {string}")
    public void userIntoTheFieldEntersTheValue(String name, String value) {
        TextfieldActions.setText(name,value);
    }
}
