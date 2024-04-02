package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.TestConfig;
import utils.TestConfiguration;

public class DriverFactory {


    private WebDriver newChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        for (String option : config.getBrowser().getOptions()) {
            options.addArguments(option);
        }
        return new ChromeDriver(options);
    }
    private WebDriver newEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        TestConfig config = TestConfiguration.instance().getTestConfiguration();
        for (String option : config.getBrowser().getOptions()) {
            options.addArguments(option);
        }
        return new EdgeDriver(options);
    }

    private WebDriver newFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    private WebDriver newSafaryDriver() {
        SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }

    public WebDriver createDriver(String browser)  {
        switch (browser.toLowerCase().trim()) {
            case "chrome":
                return newChromeDriver();
            case "msedge":
            case "edge":
                return newEdgeDriver();
            case "safary":
                return newSafaryDriver();
            case "firefox":
                return newFirefoxDriver();
            default:
                throw new IllegalArgumentException("browser " + browser + "not supported");
        }
    }


}
