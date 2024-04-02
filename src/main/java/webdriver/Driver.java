package webdriver;

import org.openqa.selenium.WebDriver;

public class Driver {


    private static final ThreadLocal<WebDriver> drivers= new ThreadLocal<>();
    private static final ThreadLocal<String> browsers= new ThreadLocal<>();

    public static WebDriver getDriver(){
        return getDriver("firefox");
    }

    public static WebDriver getDriver(String browser){

        if (browsers.get() !=null){
            if (drivers.get() ==null){
                drivers.set(new DriverFactory().createDriver(browsers.get()));
            }

        }else {
            browsers.set(browser);
            drivers.set(new DriverFactory().createDriver(browsers.get()));
        }

        return drivers.get();
    }

    public static void quit(){
        if (drivers.get() !=null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

}
