package atm;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report/cucumber.html"}
//        tags = "@test"
)
public class RunCukesTest{
//    static WebDriver driver;
//    @BeforeClass
//    public static void setup(){
//        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        HashMap<String, Object> chromePerfs = new HashMap<>();
//        chromePerfs.put("safebrowsing.enabled", "true");
//        chromePerfs.put("download.prompt_for_download", "true");
//        chromePerfs.put("download.directory_upgrade", "true");
//        options.setExperimentalOption("prefs", chromePerfs);
//        options.addArguments("disable-infobars");
//        options.addArguments("start-maximized");
//        options.addArguments("--no-sandbox");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
//    Base tb = new Base();
//    @BeforeClass
//    public void setup() throws MalformedURLException, InterruptedException {
//        tb.setDriver(driver);
//    }
}