package atm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    DesiredCapabilities cap = new DesiredCapabilities();
    String browser = "chrome";
    public static String hubAddress = "http://192.168.0.106:8899/wd/hub";

    public WebDriver setDriver(WebDriver driver) throws InterruptedException, MalformedParameterizedTypeException, MalformedURLException {
        if (browser == "chrome") {
            cap.setBrowserName("chrome");
        }
        driver = new RemoteWebDriver(new URL(hubAddress), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}

