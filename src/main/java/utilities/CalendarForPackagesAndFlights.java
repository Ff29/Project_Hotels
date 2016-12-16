package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;


public class CalendarForPackagesAndFlights {
	
	private static Calendar cal= Calendar.getInstance();
    private static SimpleDateFormat dateFormatMonth= new SimpleDateFormat("MM");
    private static SimpleDateFormat dateFormatYear= new SimpleDateFormat("yyyy");
    private static SimpleDateFormat dateFormatDay= new SimpleDateFormat("dd");
    private static SimpleDateFormat dateFormat;
    
    public static void travelDateP(Boolean Tomorrow,By locator,int AdddaysFromCurrentDate){
        if(Tomorrow==true){
        String tomorrow =addDaysToCurrentDate(AdddaysFromCurrentDate);
        String formatMonth = dateFormatMonth.format(cal.getTime());
        String formatYear = dateFormatYear.format(cal.getTime());
        int actualDateFormatMonth = Integer.parseInt(formatMonth)-1;
        
         WebDriverFactory.getDriver().findElement(locator).click();
         WebDriverFactory.getDriver().findElement(By.xpath("//table//button[@data-year='"+formatYear+"'][@data-month='"+actualDateFormatMonth+"'][@data-day='"+tomorrow+"']")).click();//static
        }else{
        String dayAfterTomorrow =addDaysToCurrentDate(AdddaysFromCurrentDate);
        WebDriverFactory.getDriver().findElement(locator).click();
        
        String formatMonthReturn=dateFormatMonth.format(cal.getTime());
        int actualFormatMonthReturn = Integer.parseInt(formatMonthReturn)-1;
		String actualDateFormatYear1=dateFormatYear.format(cal.getTime());;
		WebDriverFactory.getDriver().findElement(By.xpath("//table//button[@data-year='"+actualDateFormatYear1+"'][@data-month='"+actualFormatMonthReturn+"'][@data-day='"+dayAfterTomorrow+"']")).click();
        }
    }
    
    public static String addDaysToCurrentDate(int days){
        cal.add(Calendar.DATE,days);
        String actualDateFormatDay = dateFormatDay.format(cal.getTime());
       
        return actualDateFormatDay;
    }
    // Archana specific date for travel in package in flights
   
//    public static String specificDate(int year,int month, int day){
//    	month= month-1;
//    	cal.set(year, month, day);
//    	String specificDateFormat= dateFormat.format(cal.getTime());
//    	return specificDateFormat;
//    }
//
//    public static void travelSpecific(By locator,int year,int month, int day){
//    String departDate= specificDate( year,month,day);
//    String departmonth=dateFormat.format(cal.g)  	
//    String formatMonth = dateFormatMonth.format(cal.getTime());
//        String formatYear = dateFormatYear.format(cal.getTime());
//        
//        int actualDateFormatMonth = Integer.parseInt(formatMonth)-1;
//        String formatDate= dateFormat.
//        		WebDriverFactory.getDriver().findElement(locator).click();
//         WebDriverFactory.getDriver().findElement(By.xpath("//table//button[@data-year='"+formatYear+"'][@data-month='"+actualDateFormatMonth+"'][@data-day='"+tomorrow+"']")).click();//static
//    }
    
}
