package seleniumLibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalSeleniumLibrary {

	private static WebDriver driver;

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Open ie browser
	public static WebDriver startIEBrowser() {
		return driver = new InternetExplorerDriver();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Open firefox browser
	public static WebDriver startFirefoxBrowser() {
		return driver = new FirefoxDriver();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Enter Text-box
	public static void enterTextField(String inputString, By by) {
		WebElement textFieldElement = driver.findElement(by);
		textFieldElement.clear();
		textFieldElement.sendKeys(inputString);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Select Drop-Down Element
	public static void selectDropDown(String beSelectedValue, By by) {
		Select dropDownElement = new Select(driver.findElement(by));
		dropDownElement.selectByVisibleText(beSelectedValue);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void selectDropDown(String beSelectedValue, WebElement Elm) {
		Select dropDownElement = new Select(Elm);
		dropDownElement.selectByVisibleText(beSelectedValue);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Click button
	public static void clickButton(By by) {
		WebElement buttonElement = driver.findElement(by);
		buttonElement.click();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Select Checkbox
	public static void selectCheckBox(By by) {
		// locate check box and click it if it is not checked
		WebElement firstCheckBox = driver.findElement(by);

		boolean checkBoxStatus = false;
		checkBoxStatus = firstCheckBox.isSelected();

		if (checkBoxStatus == false) {
			firstCheckBox.click();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Unselect checkbox
	public static void unselectCheckBox(By by) {
		// locate check box and click it to remove check if it is already
		// checked
		WebElement firstCheckBox = driver.findElement(by);

		boolean checkBoxStatus = false;
		checkBoxStatus = firstCheckBox.isSelected();

		if (checkBoxStatus == true) {
			firstCheckBox.click();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Delect radio button by index
	public static void selectRadioButton(By by, int index) {
		// Locate radio button group
		WebElement radio = driver.findElement(by);
		List<WebElement> radioButtonGroup = radio.findElements(By
				.tagName("input"));
		radioButtonGroup.get(index).click();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Select radio button by label name
	public static void selectRadioButton(By by, String labelName) {
		// Locate radio button group
		WebElement radio = driver.findElement(by);

		// selecting by label
		List<WebElement> radioButtonGroupLabels = radio.findElements(By
				.tagName("label"));
		for (WebElement labelElement : radioButtonGroupLabels) {
			if (labelElement.getText().contains(labelName)) {
				labelElement.click();
				break;
			}
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Capture screenshot
	public static String captureScreenshot(String imageName,
			String saveLocationPath) throws Exception {
		String timeStamp = getCurrentTime();
		File screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(saveLocationPath + imageName
				+ "_" + timeStamp + ".png"));
		return saveLocationPath + imageName + "_" + timeStamp + ".png";
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// generate current time
	public static String getCurrentTime() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void customWait(int inSeconds) throws Exception {
		Thread.sleep(inSeconds * 1000);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void clickHiddenElement(WebElement hiddenElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver; // hidden element
																// click
		js.executeScript("arguments[0].click();", hiddenElement);
		System.out.println("Clicking on hidden element for: "
				+ hiddenElement.getText() + "'");
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void setDriver(WebDriver driver2) {
		driver = driver2;

	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void hoverOverElement(WebElement Menu, By SubMenu)
			throws Exception {
		// Hover the first Menu Element
		Actions action = new Actions(driver);
		action.moveToElement(Menu);
		action.perform();
		customWait(1);

		// Selects the second sub-menu element
		driver.findElement(SubMenu).click();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static WebElement explicitWait(By by, int inSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, inSeconds);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(by));
		return element;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void printDropDownMenus() throws Exception {
		WebElement menue = driver.findElement(By.cssSelector(""));
		List<WebElement> elements = menue.findElements(By.tagName("option"));
		for (int i = 0; i < elements.size(); i++) {
			String values = elements.get(i).getText();
			System.out.println(values);
		}

	}
}
