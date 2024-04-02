package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.TestConfig;
import utils.TestConfiguration;
import utils.Utils;
import webdriver.Driver;

@CucumberOptions(
        features = {"resources/RegSuit/Akakce/akakce.feature"},
        glue = {"stepdefs"},
        //tags = "",
        monochrome = true,
        dryRun = true,
        plugin = {"progress",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("") String browser) {

        System.setProperty("cucumber.publish.quiet", "true");
        Utils.configureCucumber();

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

