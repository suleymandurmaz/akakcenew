package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.TestConfig;
import utils.TestConfiguration;
import webdriver.Driver;

@CucumberOptions(
        features = {"src/test/resources/RegSuit"},
        glue = {"stepdefs"},
        //tags = "",
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class Runner_temp extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("") String browser) {

        Driver.getDriver("chrome");

        if (browser.length() > 0) {
            Driver.getDriver(browser);
        } else {
            TestConfig config = TestConfiguration.instance().getTestConfiguration();
            Driver.getDriver(config.getBrowser().getName());
        }
    }

    @AfterSuite
    public void afterSuite(){
        Driver.quit();
    }

}

