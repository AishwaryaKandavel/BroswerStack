package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserStackTest {
	WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() {
		driver = new ChromeDriver();
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
//	@Test
//	public void test3() {
//		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
//		System.out.println(driver.getTitle());
//	}
//	@Test
//	public void test4() {
//		driver.get("https://rahulshettyacademy.com/angularpractice/");
//		System.out.println(driver.getTitle());
//	}
}
