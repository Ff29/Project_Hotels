package activities;

import java.io.IOException;

import page_objects.Landing_Page;

public class PreTestRequirements extends GeneralMethods {
	
	public static void goToPackagesAndFlights() throws IOException{
		Landing_Page.clickOnPackagesAndFlights();
		//verifyPageTtitle("Vacation Packages: Find Cheap Trips, Deals & Vacations | Hotels.com");
		}
	public static void goToGiftCards() throws IOException{
		Landing_Page.clickOnGiftCards();
		verifyPageTitle("Hotels.com - Earn Free Nights on Cheap Hotels Near You");
		}
	public static void goToHelp() throws IOException{
		Landing_Page.clickOnHelp();
		verifyPageTitle("Hotels.com - Earn Free Nights on Cheap Hotels Near You");
		}
	public static void goTosignInAndAccount() throws IOException{
		Landing_Page.clickOnSignInAndAccount();
		}
	public static void goToGroups() throws IOException{
		Landing_Page.clickOnGroups();
		verifyPageTitle("Group Hotel Quote Request");
		}
	public void abc(){
		
	}
	}
