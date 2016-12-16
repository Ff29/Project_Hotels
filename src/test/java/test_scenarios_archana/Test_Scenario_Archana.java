package test_scenarios_archana;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import activities.GeneralMethods;
import activities.PreTestRequirements;
import page_objects.Help_Page;
import utilities.WebDriverFactory;

public class Test_Scenario_Archana extends WebDriverFactory  {  

	/*
	 * Help group  TA_117
	 * User should be able submit the lowest prices
	 */
	
	//@Test(testName="TA_117")
	public void TA_117() throws Exception{
		PreTestRequirements.goToHelp();
		Help_Page.clickOnUnlockPrice();
		Help_Page.clickOnAskPrice();
		Thread.sleep(5000);
		Help_Page.clickOnPriceGuarantee();
		Help_Page.askUsMatchPrice();
		Help_Page.whereDidYouGetPrice(2);
		Help_Page.pickOther("abc.com","xyz","xyz@gmail.com","12345566", "44465645","50");
	    Help_Page.assertMessage("Price Guarantee Confirmation");
	}
	//@Test(testName="TA_119")
	public void TA_119() throws Exception{
		PreTestRequirements.goToHelp();
		Help_Page.clickOnYourSetting();
		Help_Page.clickOnSubscription();
		Thread.sleep(2000);
		Help_Page.clickOnUnsubscribe();
		Thread.sleep(2000);
		Help_Page.enterEmail("sdf@gmail.com");
		Help_Page.unsubscribeButton();
		Help_Page.verifyUnsubscribeMessage("Newsletter unsubscription confirmation");
		Help_Page.clickOnSubscribe();
		Help_Page.emailSignUp("xyz@gamil.com", "xyz@gamil.com", "ruby", "xyz");
		Help_Page.checkBox();
		Help_Page.register();
	}
	//@Test
	public void test() throws Exception{
		PreTestRequirements.goToGiftCards();
		GeneralMethods.switchToWindowIndex(1);
		
		
		Actions move= new Actions(WebDriverFactory.getDriver());
    	move.moveToElement(WebDriverFactory.getDriver().findElement(By.cssSelector("a[href*='gift-card/buy'][class='cta']"))).click().build().perform();
	   	WebDriverFactory.getDriver().findElement(By.cssSelector("a[class*='tab current']"));
	    move.moveToElement(WebDriverFactory.getDriver().findElement(By.cssSelector("#img_DB97YPD9Y"))).click();
	   	move.moveToElement(WebDriverFactory.getDriver().findElement(By.cssSelector("#amount-50"))).click().build().perform();
		
		WebDriverFactory.getDriver().findElement(By.cssSelector("#printathome-delivery")).click();
		WebDriverFactory.getDriver().findElement(By.cssSelector("#home_name")).sendKeys("rubt");
		WebDriverFactory.getDriver().findElement(By.cssSelector("#home_email")).sendKeys("bet@gmail.com");
		WebDriverFactory.getDriver().findElement(By.cssSelector("#order-add-another")).click();
		String a=WebDriverFactory.getDriver().findElement(By.cssSelector("#img_DB97YPD9Y")).getAttribute("src");
		System.out.println(a);
		move.moveToElement(WebDriverFactory.getDriver().findElement(By.cssSelector("[data-cartitemnumber='0']"))).build().perform();
		String b=WebDriverFactory.getDriver().findElement(By.cssSelector("[data-cartitemnumber='0']")).getAttribute("faceplate");
      
		System.out.println(b);
	}    

	  @Test(testName="TA_226")
	  public void TA_226() throws Exception{
		  PreTestRequirements.goToHelp();;
		  Help_Page.clickOnHotelRewards();
		  Help_Page.clickOnGettingStarted();
		  Help_Page.clickOnViewActivity();
		  Help_Page.clickOnRewardsActivity();
		  Thread.sleep(3000);
		  Help_Page.signIn("abc@gmail.com", "12345");
		  Help_Page.staySigned();
		  Help_Page.clickOnSignInActivity();
		  Help_Page.activityErrorMessage("We don’t recognize");
	  }

	  
	  
	}

