package activities;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.WebDriverFactory;

public class GeneralMethods extends BaseMethods {
	
	
	public static int autoCompleteListIndex(List<WebElement> list, String input){
		for(WebElement element : list){
			if(element.getText().equals(input)){
				return list.indexOf(element);
				}
			}
		return 0;
		}
	/*
	 * Click on the autocomplete search box and send keys as usual then to select a specific result
	 * call autoCompleteSearchAndClick() method and pass locator for the list and the result name you
	 * want to select 
	 */
	public static void autoCompleteSearchAndClick(By locator, String input){
		WebDriverFactory.implicitWaitOn(5000);
		List<WebElement> list = WebDriverFactory.getDriver().findElements(locator);
		int indexNumber = autoCompleteListIndex(list, input);
		WebDriverFactory.implicitWaitOn(5000);
		list.get(indexNumber).click();
		}
	/*
	 * Autocomplete where the selection is by index 
	 */
	public static void autocompleteSelectByIndex(By locatorForSendkeys,String inputForSearch, By locatorForList,int indexForSelect){
	        WebDriverFactory.getDriver().findElement(locatorForSendkeys).sendKeys(inputForSearch);
	        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	        List<WebElement> destination=(WebDriverFactory.getDriver().findElements(locatorForList));
	        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        List<WebElement> destination1=(WebDriverFactory.getDriver().findElements(locatorForList));
	        destination1.get(indexForSelect).click();
	        }
	/*
	 * In this dropdownFindAndSelect mehtod you need to give the locator of the
	 * dropdown and index number to select
	 */
	public static void dropdownFindAndSelect(By locator,int selectOption){
		Select dropDown = new Select(WebDriverFactory.getDriver().findElement(locator));
		dropDown.selectByIndex(selectOption);
		}
	/*
	 *By childrenAndAgeSelect() method 0-6 childrens can be selected and
	 *different ages will be selected for all childrens automatically 
	 */
	public static void childrenAndAgeSelect(By locator, int childrenNumber ){
		int childAge = 10;
		if(childrenNumber==0){
			dropdownFindAndSelect(locator, childrenNumber);
		}else if((childrenNumber>0) & (childrenNumber<=6)){
			dropdownFindAndSelect(locator, childrenNumber);
			for(int i=1 ; i<=childrenNumber ; i++){
				
				dropdownFindAndSelect(By.cssSelector("#flight-age-select-"+i+""),childAge++ );
				}
			}
		}
	/*
	 * scrollDown() method will scroll down as much as the parameter will be
	 * passed as pixels
	 */
	public static void scrollDown(int pixels) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)WebDriverFactory.getDriver();
		js.executeScript("window.scrollBy(0,"+pixels+")");
	}
	/*
	 * Verifying an image title
	 * Searching by tagname "img" and taking all image in a list
	 * getting all the images title and compares with expected images title
	 */
	public static void verifyImageTitle(String expectedImageTitle){
		List<WebElement> listOfImages = WebDriverFactory.getDriver().findElements(By.tagName("img"));
		for(WebElement element : listOfImages){
			String title = element.getAttribute("title");
			if(title.equals(expectedImageTitle)){
				System.out.println("Title of the image is: "+title);
				String actualImageTitle = title;
				Assert.assertEquals(actualImageTitle, expectedImageTitle);
				}
			}
		}
	/*
	 * checkBoxCheckAndSelect() method checks first if a radio button or checkbox is selected
	 * or not. If selected then it will fail the test and if it's not selected
	 * then ot will select
	 */
	public static void checkBoxCheckAndSelect(By locator){
		try {
			boolean isSelected= WebDriverFactory.getDriver().findElement(locator).isSelected();
			if(isSelected==false){
			WebDriverFactory.getDriver().findElement(locator).click();
			}else{
			throw new NoSuchElementException("It can not be checked by default");
			}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				}
		}
	/*
	 * checkBoxCheck() just checks if it's already selected or not
	 */
	public static void checkBoxCheck(By locator){
		
		boolean isSelected= WebDriverFactory.getDriver().findElement(locator).isSelected();
		if(isSelected==true){
			throw new NoSuchElementException("The checkbox is already selected");
			}else{
			System.out.println("The checkbox is not selected by default");
			}
		}
	/*
	 * verifyHeader() method going to verify the page header as expected
	 */
	public static void verifyMessage(By locator,String expected){
		
		String actualHeader = WebDriverFactory.getDriver().findElement(locator).getText();
		System.out.println("The scenario page message is: "+actualHeader);
		Assert.assertEquals(actualHeader, expected);
		}
	/*
	 * Verify taking partial messages
	 */
	public  static void verifyPartialMessage(By locator, String expectedText ){
		String element = WebDriverFactory.getDriver().findElement(locator).getText();
		String actualHeader = (element.substring(4, 27));
		Assert.assertEquals(actualHeader,expectedText);
		}
	/*
	 * Selects dropdown option by String value 
	 */
	public static void dropdownSelectByValue(By locator,String inputChoice) throws Exception{
		WebElement dropdown= WebDriverFactory.getDriver().findElement(locator);
		Select listOfDropdown = new Select(dropdown);
        List<WebElement> listOfValues = listOfDropdown.getOptions();
        for(WebElement values:listOfValues){
        		if(values.getText().equalsIgnoreCase(inputChoice)) {
        			values.click();
        			} 
        		}
        	}
	/*
	 * method for kids age Archana
	 */
	public static void dropdownByIndex(By locator, int noOfChildren){
	        Random rand= new Random();
	        WebElement dropdown= WebDriverFactory.getDriver().findElement(locator);
	        Select children = new Select(dropdown);
	        children.selectByIndex(noOfChildren);
	        for(int i=1; i<=noOfChildren;i++){
	            Select kidAge = new Select(WebDriverFactory.getDriver().findElement(By.cssSelector("#package-1-age-select-"+i)));
	            int age= rand.nextInt((19 - 1) + 1)+1;
	            kidAge.selectByIndex(age);
	        }
	    }
	/*
	 * Switch window
	 */
	public  static void switchToWindowIndex(int index) {
		try {
            List<String> listOfWindow= new ArrayList<String>(WebDriverFactory.getDriver().getWindowHandles());
               WebDriverFactory.getDriver().switchTo().window(listOfWindow.get(index));
               System.out.println(listOfWindow.size());
               } catch (IndexOutOfBoundsException e) {
            	   throw new IndexOutOfBoundsException("Invalid window index--"+ index);
            	   }
		}
	/*
	 * Action click
	 */
	public static void moveAndClickElement(By locator){
            Actions move= new Actions(WebDriverFactory.getDriver());
            move.moveToElement(WebDriverFactory.getDriver().findElement(locator)).click().build().perform();
            }
	/*
	 * Archana list of elements
	 */
	public static void chooselistOfElement(By locator,int index){
            List<WebElement> list = WebDriverFactory.getDriver().findElements(locator);
            list.get(index).click();
        }

}
