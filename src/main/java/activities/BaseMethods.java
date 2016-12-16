package activities;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import utilities.WebDriverFactory;

public class BaseMethods {
	
	public static void enterDataIntoTextField(By locator, String input) throws IOException {
		try {
			WebDriverFactory.implicitWaitOn(5000);
			WebDriverFactory.getDriver().findElement(locator).clear();
			WebDriverFactory.getDriver().findElement(locator).sendKeys(input);
			} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new NoSuchElementException("Specified Text field for input is not found");
			}
		}
	public static void clickOn(By locator) throws IOException{
		try {
			WebDriverFactory.implicitWaitOn(5000);
			WebDriverFactory.getDriver().findElement(locator).click();
			} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new NoSuchElementException("Specified button for click is not found");
			}
		}
	public static void verifyPageTitle(String expectedPageTitle){
		String actualPageTitle = WebDriverFactory.getDriver().getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		System.out.println("The title of this page is: "+ actualPageTitle);
		}
	}
