package myPackageOnCars;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumLibrary.GlobalSeleniumLibrary;

public class FirstPage {
	private WebDriver driver;
	private String baseURL = "https://www.facebook.com/";

	@Before
	public void setUP() {
		driver = GlobalSeleniumLibrary.startFirefoxBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(baseURL);

		String pageitle = driver.getTitle();
		System.out.println("The current title is: " + pageitle);

	}

	@Ignore
	@After
	public void tearDown() {
		//driver.close();
		//driver.quit();
		System.out.println("Test complete");
	}

	// @Ignore
	@Test
	public void createAccount() throws Exception {

		//WebElement firstName = driver.findElement(By.id("u_0_1"));
		//firstName.sendKeys("ferkat");

		GlobalSeleniumLibrary.enterTextField("ferkat", By.id("u_0_1"));
		
		//WebElement lastName = driver.findElement(By.id("u_0_3"));
		//lastName.sendKeys("jawdat");
		
		GlobalSeleniumLibrary.enterTextField("jawdat", By.id("u_0_3"));

		//WebElement email1 = driver.findElement(By.id("u_0_5"));
		//email1.sendKeys("202-202-2020");

		GlobalSeleniumLibrary.enterTextField("201-201-2012", By.id("u_0_5"));
		
		//WebElement email2 = driver.findElement(By.id("u_0_8"));
		//email2.sendKeys("202-202-2020");

		GlobalSeleniumLibrary.enterTextField("201-201-2012", By.id("u_0_8"));
		
		//WebElement password = driver.findElement(By.id("u_0_a"));
		//password.sendKeys("123456abcdef");

		GlobalSeleniumLibrary.enterTextField("123456abcdef", By.id("u_0_a"));
		
		WebElement day = driver.findElement(By.cssSelector("#day"));
		List<WebElement> days = day.findElements(By.tagName("option"));
		for (int i = 0; i < days.size(); i++) {

			days.get(10).click();
		}

		WebElement month = driver.findElement(By.cssSelector("#month"));
		List<WebElement> months = month.findElements(By.tagName("option"));
		for (int a = 0; a < months.size(); a++) {

			months.get(9).click();
		}

		WebElement year = driver.findElement(By.cssSelector("#year"));
		List<WebElement> years = year.findElements(By.tagName("option"));
		for (int i = 0; i < years.size(); i++) {

			years.get(27).click();
		}
		
		//WebElement genderRdioBtn=driver.findElement(By.id("u_0_e"));
		//genderRdioBtn.click();
		
		GlobalSeleniumLibrary.clickButton(By.id("u_0_e"));
		
		//WebElement createAccountBtn=driver.findElement(By.id("u_0_i"));
		//createAccountBtn.click();
		
		GlobalSeleniumLibrary.clickButton(By.id("u_0_i"));
		
		GlobalSeleniumLibrary.customWait(3);
		
		GlobalSeleniumLibrary.captureScreenshot("facebook", "/Users/fuerhaiti/Desktop/pics");
		
		System.out.println("Check in to the GIT is complete!");
		
	}

}
