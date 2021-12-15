package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;

public class TwoInputBox {
	private WebDriver driver;
	private WebDriverManager webDrbMng;
	WebDriverWait wait;
	SoftAssert sf;

	@BeforeClass
	public void setUp() throws Exception {
		webDrbMng = new WebDriverManager();
		driver = webDrbMng.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
	}

	@BeforeMethod
	public void testPreReq() {
		sf = new SoftAssert();
	}

	@Test
	public void datePickerTest() {
		WebElement element1 = driver.findElement(By.id("sum1"));
		WebElement element2 = driver.findElement(By.id("sum2"));
		WebElement element3 = driver.findElement(By.xpath("//button[text()=\"Get Total\"]"));
		WebElement element4 = driver.findElement(By.id("displayvalue"));
		// for integer values
		element1.sendKeys("20");
		element2.sendKeys("100");
		element3.click();
		String value1=element4.getText();
		sf.assertEquals(value1, "120");
		// for NaN values
		element1.clear();
		element2.clear();
		element3.click();
		String value2=element4.getText();
		sf.assertEquals(value2, "NaN");
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
