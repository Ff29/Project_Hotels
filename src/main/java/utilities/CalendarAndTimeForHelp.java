package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import page_objects.Landing_Page;

public class CalendarAndTimeForHelp {
    
    private static Calendar cal= Calendar.getInstance();
    private static SimpleDateFormat dateFormat;

    /*
     * Calendar where the xpath for the calendar date is in {01/02/17}format for selecting 
     * tomorrow as departing and day after tomorrow for return
     * and you have select from the next month
     */
    
    public static void chooseNextMonthHelpPage(){
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);;
        String year = new SimpleDateFormat("yyyy").format(cal.getTime());
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(cal.getTime()))-1;
        String day1 = new SimpleDateFormat("dd").format(cal.getTime());
        int day= Integer.parseInt(day1);
        WebDriverFactory.getDriver().findElement(By.cssSelector("[data-day='"+day+"'][onmouseover*='"+month+","+year+"']")).click();;
        //[data-day='2'][onmouseover*='11,2016']
                
    }
    public static void travelDateByTomorrow(Boolean Tomorrow,By locator) throws IOException{
        if(Tomorrow==true){
        String tomorrow =addDaysToCurrentDate(1);
         activities.GeneralMethods.clickOn(locator);
       // WebDriverFactory.getDriver().findElement(locator).click();
         WebDriverFactory.getDriver().findElement(By.cssSelector("a[aria-label='"+ tomorrow+ "']")).click();//static
        }else{
        String dayAfterTomorrow =addDaysToCurrentDate(2);
        activities.GeneralMethods.clickOn(locator);
        // WebDriverFactory.getDriver().findElement(locator).click();
        WebDriverFactory.getDriver().findElement(By.cssSelector("a[aria-label='"+ dayAfterTomorrow+ "']")).click();
        }
    }
    
    public static String addDaysToCurrentDate(int days){
           cal.add(Calendar.DATE,days); //take the calendar date and add days
        String actualDateFormat = new SimpleDateFormat("MM/dd/yy").format(cal.getTime());//format the date according to date formate
        return actualDateFormat;
    }     
    
      
    public static String chooseSpecificDate(int year,int month,int date){
        month = month-1;        
        cal.set(year, month, date);
        String specificDateFormat= dateFormat.format(cal.getTime());
        return specificDateFormat;
    }
  
    /*
     * Calendar  where the xpath for the calendar date is in (year 2016,month 12,date 01) format
     */
    
    public static void travelDateSpecific(By locator1,By locator2) throws Exception{
        Calendar depart=Calendar.getInstance();
        Calendar arrive=Calendar.getInstance();
        depart.add(Calendar.DATE, 1);
        arrive.add(Calendar.DATE,2);
        String year= new SimpleDateFormat("yyyy").format(depart.getTime());
        String month = new SimpleDateFormat("MM").format(depart.getTime());
        int monthvalue=Integer.parseInt(month)-1;
        String departDate= new SimpleDateFormat("dd").format(depart.getTime());
        String arriveDate= new SimpleDateFormat("dd").format(arrive.getTime());
        activities.GeneralMethods.clickOn(locator1);
       // WebDriverFactory.getDriver().findElement(By.xpath(".//*[@id='flight-departing']")).click();
        WebDriverFactory.getDriver().findElement(By.xpath(".//button[@data-year='"+year+"'][@data-month='"+monthvalue+"'][@data-day='"+departDate+"']")).click();;
        Thread.sleep(2000);
        activities.GeneralMethods.clickOn(locator2);
        //WebDriverFactory.getDriver().findElement(By.xpath(".//*[@id='flight-returning']")).click();
        WebDriverFactory.getDriver().findElement(By.xpath(".//button[@data-year='"+year+"'][@data-month='"+monthvalue+"'][@data-day='"+arriveDate+"']")).click();
            
    }
       
}