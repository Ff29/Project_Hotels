package page_objects;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;

import activities.GeneralMethods;

public class HotelDeals_Page extends GeneralMethods {

	private static By HotelDeals_PageHashMap(String key){
		
		HashMap<String, By> HotelDealsPageFields = new HashMap<String, By>();
		
		HotelDealsPageFields.put("", By.cssSelector(""));
		return HotelDealsPageFields.get(key);
	
		
	}
	
	protected static By getKeyHotelDeals_Page(String key){
        return HotelDeals_PageHashMap(key);
    }
	
}
