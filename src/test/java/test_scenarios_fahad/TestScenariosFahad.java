package test_scenarios_fahad;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import activities.PreTestRequirements;
import page_objects.Groups_Page;
import page_objects.PackagesAndFlights;
import utilities.WebDriverFactory;
import utilities.customListener;

@Listeners(customListener.class)
public class TestScenariosFahad extends WebDriverFactory {
	
	/*
	 *  "Packages & Flights"
	 * User should be able to search flights for 2 adults without choosing a hotel
	 */
	//@Test(testName="TA1")
	public void TA1() throws IOException{
		
		PreTestRequirements.goToPackagesAndFlights();
		PackagesAndFlights.clickOnFlightOnly();
		PackagesAndFlights.clickOnRoundtrip();
		PackagesAndFlights.flyingFromNewyorJFK("jfk");
		PackagesAndFlights.flyingToLosAngelesLAX();
		PackagesAndFlights.selectDepartingDateAsTomorrow();
		PackagesAndFlights.selectReturningDateAsDayAfterTomorrow();
		PackagesAndFlights.selectTwoAdults();
		PackagesAndFlights.selectZeroChildren();
		PackagesAndFlights.checkCheckboxIsNotSelected();
		PackagesAndFlights.clickOnSearchButton();
		PackagesAndFlights.verifyHeaderWithCityLosAngeles();
		}
	/*
	 * "Packages & Flights"
	 * User should be able to search for attractions in Desired City
	 */
	//@Test(testName="TA2")
	public void TA2() throws IOException{
		
		PreTestRequirements.goToPackagesAndFlights();
		PackagesAndFlights.clickOnThingsToDo();
		PackagesAndFlights.goToOrlandoFlorida();
		PackagesAndFlights.activityStartsFromTomorrow();
		PackagesAndFlights.activityEndsDayAfterTomorrow();
		PackagesAndFlights.clickOnSearchThingsToDo();
		PackagesAndFlights.verifyHeaderThingsToDo();
		PackagesAndFlights.verifyTable();
		}
	/*
	 * "Packages & Flights"
	 * User should be able to search for multiple destination flights
	 */
	//@Test(testName="TA3")
	public void TA3() throws IOException{
		
		PreTestRequirements.goToPackagesAndFlights();
		PackagesAndFlights.clickOnFlightOnly3();
		PackagesAndFlights.clickOnmultipleDestinations();
		PackagesAndFlights.flyingFromNewark("Newark","Newark, NJ (EWR-Liberty Intl.)");
		PackagesAndFlights.flyingToOrlando("orlando","Orlando, FL (ORL-All Airports)");
		PackagesAndFlights.selectDepartingDateTomorrow();
		PackagesAndFlights.selectTwoAdults();
		PackagesAndFlights.selectOneChildren();
		PackagesAndFlights.flyingFromOrlandoFlight2();
		PackagesAndFlights.flyingToLasvegasFlight2();
		PackagesAndFlights.selectDepartingDateAfter8Days();
		PackagesAndFlights.clickOnSearchButton();
		PackagesAndFlights.verifyHeaderWithCityNewark();
		}
	/*
	 *"Packages & Flights"
	 *User should be able to select a hotel for only part of their stay 
	 */
	//@Test(testName="TA4")
	public void TA4() throws IOException{
		
		PreTestRequirements.goToPackagesAndFlights();
		PackagesAndFlights.clickOnFlightAndHotel();
		PackagesAndFlights.flyingFromNewyork();
		PackagesAndFlights.flyingToLosAngeles();
		PackagesAndFlights.departTomorrow();
		PackagesAndFlights.returnAWeekFromTomorrow();
		PackagesAndFlights.selectOneRoom();
		PackagesAndFlights.checkTheCheckbox();
		PackagesAndFlights.selectOneAdult();
		PackagesAndFlights.selectZeroChild();
		PackagesAndFlights.clickOnSearch();
		PackagesAndFlights.verifyHeaderFlightAndHotel();
		}
	/*
	 * "Packages & Flights"
	 * User should be able to search for Beach Packages without selecting a date initially
	 */
	@Test(testName="TA5")
	public void TA5() throws IOException{
		PreTestRequirements.goToPackagesAndFlights();
		PackagesAndFlights.clickOnBeachPackage();
		PackagesAndFlights.leaveFromJFK();
		PackagesAndFlights.goingToMiami();
		PackagesAndFlights.selectOneRoomInBeachPackage();
		PackagesAndFlights.selectTwoAdultsInBeachPackage();
		PackagesAndFlights.selectZeroChildrenInBeachPackage();
		PackagesAndFlights.selectFirstClass();
		PackagesAndFlights.searchBeachPackages();
		PackagesAndFlights.verifyEnterDatesMessage();
		}
	/*
	 * "Groups"
	 * Room layout image change based on the type of the Meeting
	 */
	//@Test(testName="TA255")
	public void TA255() throws IOException, InterruptedException{
		
		PreTestRequirements.goToGroups();
		Groups_Page.scrollDownToOnlyMeetingSpaceSearch();
		Groups_Page.clickOnStartASearch();
		Groups_Page.selectRoomLayOutToBanquet();
		Groups_Page.verifySelectedBanquetImage();
		}
	}