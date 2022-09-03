package atm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
//import static atm.RunCukesTest.driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class WithdrawSteps extends Base {

	private static Account account;
	private static ATM atm = new ATM();
	private static Integer returnedAmount;

	WebDriver driver;
	Base tb = new Base();
	@Before
	public void bf0() throws MalformedURLException, InterruptedException {
		tb.setDriver(driver);
	}

	@Given("^I have (\\d+) SEK on my account$")
	public void i_have_SEK_on_my_account(int amount) throws Throwable {
	    account = new Account(amount);
	}

	@Given("^open bing$")
	public void open_bing() throws Throwable {
		WebDriver driver = init_browser();
		System.out.println("open bing");
		driver.navigate().to("https://cn.bing.com/");

	}
	@Given("^open baidu$")
	public void open_baidu() throws Throwable {
		WebDriver driver = init_browser();
		System.out.println("open baidu");
		driver.navigate().to("https://www.baidu.com/");

	}
	@Given("^open fanyi$")
	public void open_fanyi() throws Throwable {
		WebDriver driver = init_browser();
		System.out.println("open baidu");
		driver.navigate().to("https://fanyi.baidu.com/");

	}




	public WebDriver init_browser(){
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePerfs = new HashMap<>();
		chromePerfs.put("safebrowsing.enabled", "true");
		chromePerfs.put("download.prompt_for_download", "true");
		chromePerfs.put("download.directory_upgrade", "true");
		options.setExperimentalOption("prefs", chromePerfs);
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver init_safari_browser(){
		WebDriver driver = new SafariDriver();
		driver.get("http://baidu.com");
		return driver;
	}



	@When("^I withdraw (-?\\d+) SEK$")
	public void withdraw_SEK(int amount) throws Throwable {
	    returnedAmount = atm.withdraw(account, amount);
	}

	@Then("^I get (\\d+) SEK from the ATM$")
	public void i_get_SEK_from_the_ATM(int amount) throws Throwable {
	    assertThat(returnedAmount, is(amount));
	}

	@Then("^error message about the lack of money is displayed$")
	public void error_message_about_the_lack_of_money_is_displayed() throws Throwable {
	    assertThat(atm.getScreen(), is("Your account dont have enough money!"));
	}

	@Then("^My account has (\\d+) SEK left$")
	public void my_account_has_SEK_left(int amount) throws Throwable {
	    assertThat(account.getBalance(), is(amount));
	}

	@Then("^error message about incorrect amount is displayed$")
	public void error_message_about_incorrect_amount_is_displayed() throws Throwable {
		assertThat(atm.getScreen(), is("Cannot withdraw negative amount!"));
	}
}
