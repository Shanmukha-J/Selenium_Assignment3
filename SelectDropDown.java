package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;

public class SelectDropDown {
	private WebDriver driver;
	private WebDriverManager webDrbMng;
	WebDriverWait wait;
	SoftAssert sf;

	@BeforeClass
	public void setUp() throws Exception {
		webDrbMng = new WebDriverManager();
		driver = webDrbMng.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("https://demoqa.com/select-menu");
	}

	@BeforeMethod
	public void testPreReq() {
		sf = new SoftAssert();
	}

	@Test
	public void framesTest() {
		WebElement oEle = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(oEle);
		select.selectByIndex(4);
		select.selectByValue("red");
		select.selectByValue("7");
		select.selectByVisibleText("Purple");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
