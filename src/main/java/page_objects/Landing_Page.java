package page_objects;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import activities.GeneralMethods;
public class Landing_Page extends GeneralMethods {
	
	
	private static By landingPageHashMap(String key){
		
		HashMap<String, By> landingPageFields = new HashMap<String, By>();
		
        landingPageFields.put("hotelSearchInput", By.cssSelector("#qf-0q-destination"));
        landingPageFields.put("searchButton", By.cssSelector(".cta.cta-strong"));
        landingPageFields.put("packagesAndFlights",By.cssSelector("#hdr-packages"));
        landingPageFields.put("giftCards", By.cssSelector("#hdr-gift-card"));
        landingPageFields.put("help", By.cssSelector("#hdr-help"));
        landingPageFields.put("signInAndAccount", By.cssSelector("#hdr-account"));
        landingPageFields.put("groups", By.cssSelector("#hdr-groups"));
        
        return landingPageFields.get(key);
	}
	protected static By getKeyLandingPage(String key){
        return landingPageHashMap(key);
    }
	public static void clickOnPackagesAndFlights() throws IOException{
		clickOn(getKeyLandingPage("packagesAndFlights"));
	}
	public static void clickOnGiftCards() throws IOException{
		clickOn(getKeyLandingPage("giftCards"));
	}
	public static void clickOnHelp() throws IOException{
		clickOn(getKeyLandingPage("help"));
	}
	public static void clickOnSignInAndAccount() throws IOException{
		clickOn(getKeyLandingPage("signInAndAccount"));
	}
	public static void clickOnGroups() throws IOException{
		clickOn(getKeyLandingPage("groups"));
	}
	public static void clickOnHotelSearchInput() throws IOException{
		enterDataIntoTextField(getKeyLandingPage("hotelSearchInput"), "newyork");;
	}
}
