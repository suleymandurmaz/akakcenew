package actions;

import controls.ButtonControl;
import controls.TextfieldControl;
import utils.TestConfig;
import utils.TestConfiguration;
import webdriver.Driver;

public class ApplicationActions {

    public void gotoHomeSite() {
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        String url = config.getApplication().getUrl();
        Driver.getDriver().get(url);
    }

    public void login() {
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        String username = config.getApplication().getUsername();
        String password = config.getApplication().getPassword();
        login(username,password);

    }
    public void login(String username, String password) {

        TextfieldControl.fromLabel("email",2).setText(username);
        TextfieldControl.fromLabel("password",1).setText(password);
        ButtonControl.fromLabel("submit").click();

    }
}
