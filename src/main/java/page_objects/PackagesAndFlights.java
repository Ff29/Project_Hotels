package page_objects;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.By;
import activities.GeneralMethods;
import utilities.CalendarForPackagesAndFlights;
import utilities.WebDriverFactory;

public class PackagesAndFlights extends GeneralMethods {

	private static By PfFlightOnlyHashMap(String key){
		
		HashMap<String, By> PfFlightOnlyElement = new HashMap<String, By>();
	
		PfFlightOnlyElement.put("FlightOnlyTab", By.cssSelector("#tab-flight-tab"));
		PfFlightOnlyElement.put("RoundTripLabel", By.cssSelector("#flight-type-roundtrip-label"));
		PfFlightOnlyElement.put("FlyingFromBox", By.cssSelector("#flight-origin"));
		PfFlightOnlyElement.put("FlyingToBox", By.cssSelector("#flight-destination"));
		PfFlightOnlyElement.put("DepartingDateBox", By.cssSelector("#flight-departing"));
		PfFlightOnlyElement.put("ReturningDateBox", By.cssSelector("#flight-returning"));
		PfFlightOnlyElement.put("Adults", By.cssSelector("#flight-adults"));
		PfFlightOnlyElement.put("children", By.cssSelector("#flight-children"));
		PfFlightOnlyElement.put("addAHotelCheckbox", By.cssSelector("#flight-add-hotel-checkbox"));
		PfFlightOnlyElement.put("SearchButton", By.cssSelector("#search-button"));
		PfFlightOnlyElement.put("scenarioHeader", By.cssSelector(".title-city-text"));
		PfFlightOnlyElement.put("autocompleteList", By.cssSelector(".results>div>li>a"));
		
		return PfFlightOnlyElement.get(key);
	}
	public static By getKeyPfFlightOnly(String key){
        return PfFlightOnlyHashMap(key);
    }
	public static void clickOnFlightOnly() throws IOException{
		clickOn(getKeyPfFlightOnly("FlightOnlyTab"));
	}
	public static void clickOnRoundtrip() throws IOException{
		clickOn(getKeyPfFlightOnly("RoundTripLabel"));
	}
	public static void flyingFromNewyorJFK(String input) throws IOException{
		enterDataIntoTextField(getKeyPfFlightOnly("FlyingFromBox"), "New York, NY JFK");
		autoCompleteSearchAndClick(getKeyPfFlightOnly("autocompleteList"), input);
	}
	public static void flyingToLosAngelesLAX() throws IOException{
		enterDataIntoTextField(getKeyPfFlightOnly("FlyingToBox"), "Los Angeles, CA LAX");
		autoCompleteSearchAndClick(getKeyPfFlightOnly("autocompleteList"), "Los Angeles, CA (LAX-Los Angeles Intl.)");
	}
	public static void selectDepartingDateAsTomorrow(){
		CalendarForPackagesAndFlights.travelDateP(true, getKeyPfFlightOnly("DepartingDateBox"),1);
	}
	public static void selectReturningDateAsDayAfterTomorrow(){
		CalendarForPackagesAndFlights.travelDateP(true, getKeyPfFlightOnly("ReturningDateBox"),1);
	}
	public static void selectTwoAdults(){
		dropdownFindAndSelect(getKeyPfFlightOnly("Adults"), 1);
	}
	public static void selectZeroChildren(){
		childrenAndAgeSelect(getKeyPfFlightOnly("children"), 0);
	}
	public static void checkCheckboxIsNotSelected(){
		checkBoxCheck(getKeyPfFlightOnly("addAHotelCheckbox"));
	}
	public static void clickOnSearchButton() throws IOException{
		clickOn(getKeyPfFlightOnly("SearchButton"));
	}
	public static void verifyHeaderWithCityLosAngeles(){
		verifyMessage(getKeyPfFlightOnly("scenarioHeader"), "Select your departure to Los Angeles");
	}
	private static By PfThingsToDoHashMap(String key){
		
		HashMap<String, By> PfThingsToDoElement = new HashMap<String, By>();
	
		PfThingsToDoElement.put("ThingsToDoTab", By.xpath("//a[@id='tab-activity-tab']"));
		PfThingsToDoElement.put("destinationThingsToDo", By.cssSelector("#activity-destination"));
		PfThingsToDoElement.put("activityStartDate", By.cssSelector("#activity-start"));
		PfThingsToDoElement.put("activityEndDate", By.cssSelector("#activity-end"));
		PfThingsToDoElement.put("SearchButton", By.cssSelector("#search-button"));
		PfThingsToDoElement.put("headerOfThingsToDo", By.xpath("//h1[@class='section-header-sub'][contains(text(),'things to do in Orlando')]"));
		PfThingsToDoElement.put("adventuresHeader", By.xpath("//table/tbody/tr/td/div[@class='price-matrix-title']/span[contains(text(),'Adventures & Excursions avg')]"));
		PfThingsToDoElement.put("toursHeader", By.xpath("//table/tbody/tr/td/div[@class='price-matrix-title']/span[contains(text(),'Tours & Sightseeing avg')]"));
		PfThingsToDoElement.put("attractionHeader", By.xpath("//table/tbody/tr/td/div[@class='price-matrix-title']/span[contains(text(),'Attractions & Nightlife avg')]"));PfThingsToDoElement.put("SearchButton", By.cssSelector("#search-button"));
		PfThingsToDoElement.put("autocompleteList", By.cssSelector(".results>div>li>a"));
		return PfThingsToDoElement.get(key);
	}

	public static By getKeyPfThingsToDoHashMap(String key){
        return PfThingsToDoHashMap(key);
    }
	public static void clickOnThingsToDo() throws IOException{
		clickOn(getKeyPfThingsToDoHashMap("ThingsToDoTab"));
	}
	public static void goToOrlandoFlorida() throws IOException{
		enterDataIntoTextField(getKeyPfThingsToDoHashMap("destinationThingsToDo"), "florida");
		autoCompleteSearchAndClick(getKeyPfThingsToDoHashMap("autocompleteList"), "Orlando, Florida");
	}
	public static void activityStartsFromTomorrow() throws IOException{
		CalendarForPackagesAndFlights.travelDateP(true, getKeyPfThingsToDoHashMap("activityStartDate"), 1);
	}
	public static void activityEndsDayAfterTomorrow() throws IOException{
		CalendarForPackagesAndFlights.travelDateP(true, getKeyPfThingsToDoHashMap("activityEndDate"), 1);
	}
	public static void clickOnSearchThingsToDo() throws IOException{
		clickOn(getKeyPfThingsToDoHashMap("SearchButton"));
	}
	public static void verifyHeaderThingsToDo(){
		verifyPartialMessage(getKeyPfThingsToDoHashMap("headerOfThingsToDo"), "things to do in Orlando");
	}
	public static void verifyTable(){
	verifyMessage(getKeyPfThingsToDoHashMap("adventuresHeader"), "Adventures & Excursions avg");	
	verifyMessage(getKeyPfThingsToDoHashMap("toursHeader"), "Tours & Sightseeing avg");
	verifyMessage(getKeyPfThingsToDoHashMap("attractionHeader"), "Attractions & Nightlife avg");
	}
	private static By PfFlightOnlyHashMap2(String key){
		
		HashMap<String, By> PfFlightOnlyElement2 = new HashMap<String, By>();
		PfFlightOnlyElement2.put("FlightOnlyTab", By.cssSelector("#tab-flight-tab"));
		PfFlightOnlyElement2.put("MultipleDestinationsLabel", By.cssSelector("#flight-type-multi-dest-label"));
		PfFlightOnlyElement2.put("FlyingFromBox", By.cssSelector("#flight-origin"));
		PfFlightOnlyElement2.put("FlyingToBox", By.cssSelector("#flight-destination"));
		PfFlightOnlyElement2.put("children", By.cssSelector("#flight-children"));
		PfFlightOnlyElement2.put("DepartingDateBox1", By.cssSelector("#flight-departing"));
		PfFlightOnlyElement2.put("DepartingDateBox2", By.cssSelector("#flight-2-departing"));
		PfFlightOnlyElement2.put("FlyingFromBox2", By.cssSelector("#flight-2-origin"));
		PfFlightOnlyElement2.put("FlyingToBox2", By.cssSelector("#flight-2-destination"));
		PfFlightOnlyElement2.put("autocompleteList", By.cssSelector(".results>div>li>a"));
		PfFlightOnlyElement2.put("scenarioHeader", By.cssSelector(".title-city-text"));
		PfFlightOnlyElement2.put("autocompleteList2", By.cssSelector(".results>div>li>a"));
		
		return PfFlightOnlyElement2.get(key);
	}
	public static By getKeyPfFlightOnly2(String key){
        return PfFlightOnlyHashMap2(key);
    }
	public static void clickOnFlightOnly3() throws IOException{
		clickOn(getKeyPfFlightOnly2("FlightOnlyTab"));
	}
	public static void clickOnmultipleDestinations() throws IOException{
		clickOn(getKeyPfFlightOnly2("MultipleDestinationsLabel"));
	}
	public static void flyingFromNewark(String city, String airport ) throws IOException{
		enterDataIntoTextField(getKeyPfFlightOnly2("FlyingFromBox"), city);
		autoCompleteSearchAndClick(getKeyPfFlightOnly2("autocompleteList"), airport);
	}
	public static void flyingToOrlando(String city, String airport) throws IOException{
		enterDataIntoTextField(getKeyPfFlightOnly2("FlyingToBox"),city );
		autoCompleteSearchAndClick(getKeyPfFlightOnly2("autocompleteList"), "Orlando, FL (ORL-All Airports)");
	}
	public static void selectDepartingDateTomorrow(){
		CalendarForPackagesAndFlights.travelDateP(true, getKeyPfFlightOnly2("DepartingDateBox1"),1);
	}
	public static void selectOneChildren(){
		childrenAndAgeSelect(getKeyPfFlightOnly2("children"), 1);
	}
	public static void flyingFromOrlandoFlight2() throws IOException{
		enterDataIntoTextField(getKeyPfFlightOnly2("FlyingFromBox2"), "Orlando");
		autoCompleteSearchAndClick(getKeyPfFlightOnly2("autocompleteList2"), "Orlando, FL (ORL-All Airports)");
	}
	public static void flyingToLasvegasFlight2() throws IOException{
		enterDataIntoTextField(getKeyPfFlightOnly2("FlyingToBox2"), "Las Vegas");
		autoCompleteSearchAndClick(getKeyPfFlightOnly2("autocompleteList2"), "Las Vegas, NV (LAS-All Airports)");
	}
	public static void selectDepartingDateAfter8Days(){
		CalendarForPackagesAndFlights.travelDateP(false, getKeyPfFlightOnly2("DepartingDateBox2"),7);
	}
	public static void verifyHeaderWithCityNewark(){
		verifyMessage(getKeyPfFlightOnly2("scenarioHeader"), "Multi-city trip from Newark");
		WebDriverFactory.implicitWaitOn(3000);
	}
	private static By PfFlightAndHotelHashMap(String key){
		
		HashMap<String, By> PfFlightAndHotelElement = new HashMap<String, By>();
		
		PfFlightAndHotelElement.put("flight+hotelTab", By.cssSelector("#tab-flightHotel-tab"));
		PfFlightAndHotelElement.put("flyingFromFlightAndHotel", By.cssSelector("#package-origin"));
		PfFlightAndHotelElement.put("autocompleteList", By.cssSelector(".results>div>li>a"));
		PfFlightAndHotelElement.put("flyingToFlightAndHotel", By.cssSelector("#package-destination"));
		PfFlightAndHotelElement.put("autocompleteList1", By.cssSelector(".results>div>li>a"));
		PfFlightAndHotelElement.put("departingFlightAndHotel", By.cssSelector("#package-departing"));
		PfFlightAndHotelElement.put("returningFlightAndHotel", By.cssSelector("#package-returning"));
		PfFlightAndHotelElement.put("roomsFlightAndHotel", By.cssSelector("#package-rooms"));
		PfFlightAndHotelElement.put("checkboxPartOfMyStay", By.cssSelector("#partialHotelBooking"));
		PfFlightAndHotelElement.put("adultsFlightAndHotel", By.cssSelector("#package-1-adults"));
		PfFlightAndHotelElement.put("childrenFlightAndHotel", By.cssSelector("#package-1-children"));
		PfFlightAndHotelElement.put("haderOfFlightAndHotelSearch", By.xpath("//header[@id='hotelResultTitle']/h1[contains(text(),'Start by choosing your hotel')]"));
		PfFlightAndHotelElement.put("SearchButton", By.cssSelector("#search-button"));
		return PfFlightAndHotelElement.get(key);
	}
	public static By getKeyPfFlightAndHotel(String key){
		return PfFlightAndHotelHashMap(key);
    }
	public static void clickOnFlightAndHotel() throws IOException{
		clickOn(getKeyPfFlightAndHotel("flight+hotelTab"));
	}
	public static void flyingFromNewyork() throws IOException{
		enterDataIntoTextField(getKeyPfFlightAndHotel("flyingFromFlightAndHotel"), "New York, NY JFK-John");
		autoCompleteSearchAndClick(getKeyPfFlightAndHotel("autocompleteList"), "New York, NY (JFK-John F. Kennedy Intl.)");
	}
	public static void flyingToLosAngeles() throws IOException{
		enterDataIntoTextField(getKeyPfFlightAndHotel("flyingToFlightAndHotel"), "Los Angeles, CA LAX");
		autoCompleteSearchAndClick(getKeyPfFlightAndHotel("autocompleteList1"), "Los Angeles, CA (LAX-Los Angeles Intl.)");
	}
	public static void departTomorrow(){
		CalendarForPackagesAndFlights.travelDateP(true, getKeyPfFlightAndHotel("departingFlightAndHotel"), 1);
	}
	public static void returnAWeekFromTomorrow(){
		CalendarForPackagesAndFlights.travelDateP(true, getKeyPfFlightAndHotel("returningFlightAndHotel"), 7);
	}
	public static void selectOneRoom(){
		 dropdownFindAndSelect(getKeyPfFlightAndHotel("roomsFlightAndHotel"), 0);
	}
	public static void checkTheCheckbox(){
		checkBoxCheckAndSelect(getKeyPfFlightAndHotel("checkboxPartOfMyStay"));
	}
	public static void selectOneAdult(){
		dropdownFindAndSelect(getKeyPfFlightAndHotel("adultsFlightAndHotel"), 0);
	}
	public static void selectZeroChild(){
		dropdownFindAndSelect(getKeyPfFlightAndHotel("childrenFlightAndHotel"), 0);
	}
	public static void clickOnSearch() throws IOException{
		clickOn(getKeyPfFlightAndHotel("SearchButton"));
	}
	public static void verifyHeaderFlightAndHotel(){
		verifyMessage(getKeyPfFlightAndHotel("haderOfFlightAndHotelSearch"), "Start by choosing your hotel");
	}
	private static By beachPackageHashMap(String key){
		
		HashMap<String, By> beachPackageElement = new HashMap<String, By>();
		
		beachPackageElement.put("beachPackages", By.xpath("//article/a/section/div/h4[@class='tile-name'][contains(text(),'Escape to the beach')]"));
		beachPackageElement.put("leavingFrom", By.cssSelector("#FH-origin"));
		beachPackageElement.put("autocompleteList", By.cssSelector(".results>li"));
		beachPackageElement.put("goingTo", By.cssSelector("#FH-destination"));
		beachPackageElement.put("roomsBeachPackage", By.cssSelector("#FH-NumRoom"));
		beachPackageElement.put("adultsBeachPackage", By.cssSelector("#FH-NumAdult1"));
		beachPackageElement.put("childrenBeachpackage", By.cssSelector("#FH-NumChild1"));
		beachPackageElement.put("advanceOPtions", By.cssSelector("#advanced-options"));
		beachPackageElement.put("advanceOPtionBox", By.cssSelector("#F-Class"));
		beachPackageElement.put("searchButtonBeachPackage", By.cssSelector("#FH-searchButtonExt1"));
		beachPackageElement.put("crossButton", By.cssSelector("#modalCloseButton"));
		beachPackageElement.put("enterDatesMessage", By.cssSelector(".tipbox-inner"));
		
		return beachPackageElement.get(key);
	}
	public static By getKeybeachPackageHashMap(String key){
        return beachPackageHashMap(key);
    }
	public static void clickOnBeachPackage() throws IOException{
		clickOn(getKeybeachPackageHashMap("beachPackages"));
	}
	public static void leaveFromJFK() throws IOException{
		enterDataIntoTextField(getKeybeachPackageHashMap("leavingFrom"), "New York");
		autoCompleteSearchAndClick(getKeybeachPackageHashMap("autocompleteList"), "New York, NY (JFK-John F. Kennedy Intl.)");
	}
	public static void goingToMiami() throws IOException{
		enterDataIntoTextField(getKeybeachPackageHashMap("goingTo"), "Miami");
		autoCompleteSearchAndClick(getKeybeachPackageHashMap("autocompleteList2"), "Miami (and vicinity)");
	}
	public static void selectOneRoomInBeachPackage(){
		dropdownFindAndSelect(getKeybeachPackageHashMap("roomsBeachPackage"), 0);
	}
	public static void selectTwoAdultsInBeachPackage(){
		dropdownFindAndSelect(getKeybeachPackageHashMap("adultsBeachPackage"), 1);
	}
	public static void selectZeroChildrenInBeachPackage(){
		dropdownFindAndSelect(getKeybeachPackageHashMap("childrenBeachpackage"), 0);
	}
	public static void selectFirstClass() throws IOException{
		dropdownFindAndSelect(getKeybeachPackageHashMap("advanceOPtionBox"), 0);
	}
	public static void searchBeachPackages() throws IOException{
		clickOn(getKeybeachPackageHashMap("searchButtonBeachPackage"));
	}
	public static void verifyEnterDatesMessage() throws IOException{
	
//		WebDriverFactory.waitUntilVsible(By.xpath("//div[@id='edsHeading'][@class='heading']"));
//		verifyMessage(By.xpath("//div[@id='edsHeading'][@class='heading']"), "Enter your dates for accurate prices and availability");
	}

}
