package page_objects;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.By;
import activities.GeneralMethods;

public class Groups_Page extends GeneralMethods {

	private static By Groups_PageHashMap(String key){
		
		HashMap<String, By> groups_PageFields = new HashMap<String, By>();
		
		groups_PageFields.put("startASearchButton", By.cssSelector(".container_smart>a"));
		groups_PageFields.put("roomLayOut", By.cssSelector("#RoomType"));
		groups_PageFields.put("imageBanquet6'", By.cssSelector("#MainImage"));
		
		return(groups_PageFields.get(key));
	}
	public static By getKeyGroups_PageFields(String key){
        return Groups_PageHashMap(key);
        }
	public static void scrollDownToOnlyMeetingSpaceSearch() throws InterruptedException{
		scrollDown(9000);
		}
	public static void clickOnStartASearch() throws IOException{
		clickOn(getKeyGroups_PageFields("startASearchButton"));
		}
	public static void selectRoomLayOutToBanquet(){
		dropdownFindAndSelect(getKeyGroups_PageFields("roomLayOut"), 1);
		}
	public static void verifySelectedBanquetImage(){
		
		verifyImageTitle("Small size banquet - 6' tables (10 per table), Up to 100 seats");
		}
	}
