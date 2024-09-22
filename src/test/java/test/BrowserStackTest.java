package test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserStackTest {
	WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() throws MalformedURLException {
		String username = System.getenv("BROWSERSTACK_USERNAME");
		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
		String local = System.getenv("BROWSERSTACK_LOCAL");
		String localidentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserstack.idleTimeout", "300"); // Setting idle timeout to 5 minutes
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("local", local);
		browserstackOptions.put("localIdentifier", localidentifier);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);

		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test
	public void test1() {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		System.out.println(driver.getTitle());
	}
	@Test
	public void test2() {
		driver.get("https://rahulshettyacademy.com/client/");
		System.out.println(driver.getTitle());
	}
	@Test
	public void test3() {
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		System.out.println(driver.getTitle());
	}
	@Test
	public void test4() {
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		System.out.println(driver.getTitle());
	}
}
