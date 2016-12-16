package page_objects;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import activities.GeneralMethods;
import utilities.WebDriverFactory;
public class Help_Page extends GeneralMethods {
        
    //Help_Page help = new Help_Page();
    
    private static By gethelp_pageHashmap(String key){
        HashMap<String,By> Help_PageFields= new HashMap<String,By>();
        Help_PageFields.put("SecretPrice", By.cssSelector("#article-title-14212"));
        Help_PageFields.put("AskUsPrice", By.cssSelector("[href*='12019']"));
        Help_PageFields.put("PriceGuaranteeList",By.cssSelector("[style='TEXT-DECORATION: none']"));
        Help_PageFields.put("AskToMatch",By.xpath("//h2[@id='pmg-form-title']/a"));
        Help_PageFields.put("WhereSeePrice",By.cssSelector("#lower-price-source"));
        Help_PageFields.put("Hotel.com",By.id("booking-type"));
        Help_PageFields.put("SourcePrice",By.cssSelector("#txt_src_of_lower_price"));
        Help_PageFields.put("Name",By.cssSelector("#txt_your_name"));
        Help_PageFields.put("Email", By.cssSelector("#txt_your_email"));
        Help_PageFields.put("ContactPhone",By.cssSelector("#txt_contact_phone"));
        Help_PageFields.put("ConfirmationNumber",By.cssSelector("#txt_itinerary_number"));
        Help_PageFields.put("CheckInDate",By.cssSelector("#txt_checkin_date"));
        Help_PageFields.put("LowerPrice", By.cssSelector("#txt_lower_price"));
        Help_PageFields.put("Go",By.cssSelector(".cta"));
        Help_PageFields.put("Message",By.cssSelector(".page_heading>h1"));
        Help_PageFields.put("YourSettings", By.cssSelector("#result-408"));
        Help_PageFields.put("Subscription",By.cssSelector("a[href$='390']"));
        Help_PageFields.put("Unsubscribe",By.cssSelector("a[href*='unsubscribe']"));
        Help_PageFields.put("UnsubscribeEmail",By.cssSelector("#txt_email_address"));
        Help_PageFields.put("UnsubscribeButton",By.cssSelector("#btn_billing_submit"));
        Help_PageFields.put("UnsubsribeMessage", By.cssSelector(".page_heading>h1"));
        Help_PageFields.put("ReSubscribe", By.cssSelector("a[href*='subscribe']"));
        Help_PageFields.put("Reemail",By.cssSelector("#txt_email_address"));
        Help_PageFields.put("Retypeemail",By.cssSelector("#txt_retype_email_address"));
        Help_PageFields.put("FirstName",By.cssSelector("#txt_first_name"));
        Help_PageFields.put("LastName",By.cssSelector("#txt_last_name"));
        Help_PageFields.put("CheckBox",By.cssSelector("#createchkbx"));
        Help_PageFields.put("Register",By.cssSelector("#btn_billing_submit"));
        
        Help_PageFields.put("HotelRewards", By.xpath("//*[@id='result-407']//span"));
        Help_PageFields.put("GettingStarted", By.xpath("//a[@href='#/articles/407/69']"));
        Help_PageFields.put("ViewActivity",By.xpath("//h3[contains(text(),'Rewards activity')]"));
        Help_PageFields.put("HotelRewardActivity", By.xpath(".//a[contains(text(),'Hotels.com® Rewards activity')]"));
        Help_PageFields.put("EmailActivity",By.cssSelector("#sign-in-email"));
        Help_PageFields.put("PasswordActivity", By.cssSelector("#sign-in-password"));
        Help_PageFields.put("CheckedInBox",By.cssSelector("input[type='checkbox']"));
        Help_PageFields.put("SigninActivity",By.cssSelector("button[type='submit']"));
        Help_PageFields.put("ActivityErrorMessage", By.xpath(".//div[contains(text(),'We don’t recognize')]"));
        
        return Help_PageFields.get(key);    
    }
    /*
     * First 8 methods are for test #117
     */
    public static void clickOnUnlockPrice() throws Exception{
        switchToWindowIndex(1);
        clickOn(gethelp_pageHashmap("SecretPrice"));
    }
    public static void clickOnAskPrice() throws IOException, Exception{
     WebDriverFactory.implicitWaitOn(2000);
    // clickOn(gethelp_pageHashmap("AskUsPrice"));
        moveAndClickElement(gethelp_pageHashmap("AskUsPrice"));
          }
   
    public static void clickOnPriceGuarantee() throws Exception{
       WebDriverFactory.implicitWaitOn(2000);
        chooselistOfElement(gethelp_pageHashmap("PriceGuaranteeList"), 0);
       
       }
    
    public static void askUsMatchPrice() throws Exception{
        scrollDown(1000);
        moveAndClickElement(gethelp_pageHashmap("AskToMatch"));
        
    }
    public static void whereDidYouGetPrice(int sourceOfInfo){
            dropdownFindAndSelect(gethelp_pageHashmap("WhereSeePrice"),sourceOfInfo);
         
    }
    
    public static void pickHotels(int source){
        dropdownByIndex(gethelp_pageHashmap("Hotel.com"),source);
    }
            
      
    public static void pickOther(String source,String name, String email, String contact
            ,String confirmNumber,String lowerPrice) throws IOException{
        enterDataIntoTextField(gethelp_pageHashmap("SourcePrice"), source);
        enterDataIntoTextField(gethelp_pageHashmap("Name"),name);
        enterDataIntoTextField(gethelp_pageHashmap("Email"),email);
        enterDataIntoTextField(gethelp_pageHashmap("ContactPhone"),contact);
        enterDataIntoTextField(gethelp_pageHashmap("ConfirmationNumber"),confirmNumber);
       clickOn(gethelp_pageHashmap("CheckInDate"));
        utilities.CalendarAndTimeForHelp.chooseNextMonthHelpPage();
        enterDataIntoTextField(gethelp_pageHashmap("LowerPrice"),lowerPrice);
        clickOn(gethelp_pageHashmap("Go"));
        
   
    }
     public static void assertMessage(String expected){
         verifyMessage(gethelp_pageHashmap("Message"), expected);
     }    
         
/*
 * Methods applicable to the TA-119
 */
     
     public static void clickOnYourSetting() throws IOException{
         switchToWindowIndex(1);
         clickOn(gethelp_pageHashmap("YourSettings"));
     }
     
     public static void clickOnSubscription() throws Exception{
         WebDriverFactory.implicitWaitOn(2000);
         moveAndClickElement(gethelp_pageHashmap("Subscription"));
         //clickOn(gethelp_pageHashmap("Subscription"));
         }
     public static void clickOnUnsubscribe() throws Exception{
        WebDriverFactory.implicitWaitOn(3000);
         clickOn(gethelp_pageHashmap("Unsubscribe"));
     }
     public static void enterEmail(String email) throws IOException{
         enterDataIntoTextField(gethelp_pageHashmap("UnsubscribeEmail"), email);
     }
     public static void unsubscribeButton() throws Exception{
         clickOn(gethelp_pageHashmap("UnsubscribeButton"));
         
     }
     public static void verifyUnsubscribeMessage(String expected){
         verifyMessage(gethelp_pageHashmap("UnsubsribeMessage"), expected);
     }
     public static void clickOnSubscribe() throws Exception{
         clickOn(gethelp_pageHashmap("ReSubscribe"));
     }
     public static void emailSignUp(String email,String confirmemail,String firstName,String lastName) throws Exception{
         enterDataIntoTextField(gethelp_pageHashmap("Reemail"),email);
         enterDataIntoTextField(gethelp_pageHashmap("Retypeemail"),confirmemail);
         enterDataIntoTextField(gethelp_pageHashmap("FirstName"),firstName);
         enterDataIntoTextField(gethelp_pageHashmap("LastName"),lastName);
         }
     
     public static void checkBox() throws IOException{
        checkBoxCheckAndSelect(gethelp_pageHashmap("CheckBox"));
        }
         
    
     public static void register() throws Exception{
         clickOn(gethelp_pageHashmap("Register"));
         
     }
     //Methods for test scenario #TA_226
     
     public static void clickOnHotelRewards() throws Exception{
        switchToWindowIndex(1);
        WebDriverFactory.implicitWaitOn(1000);
        clickOn(gethelp_pageHashmap("HotelRewards"));
     }
     public static void clickOnGettingStarted() throws Exception{
         clickOn(gethelp_pageHashmap("GettingStarted"));
     }
     public static void clickOnViewActivity() throws Exception{
         clickOn(gethelp_pageHashmap("ViewActivity"));
     }
     
     public static void clickOnRewardActivity() throws IOException{
         clickOn(gethelp_pageHashmap("HotelRewardActivity"));
        
     }
    
     public static void signIn(String email,String password) throws Exception{
    	 enterDataIntoTextField(gethelp_pageHashmap("EmailActivity"),email);
    	 enterDataIntoTextField(gethelp_pageHashmap("PasswordActivity"),password);
     }
     
     public static void staySigned(){
        checkBoxCheckAndSelect(gethelp_pageHashmap("CheckedInBox")); 
         
     }
     public static void clickOnSignInActivity() throws Exception{
         clickOn(gethelp_pageHashmap("SigninActivity"));
     }
     public static void activityErrorMessage(String expected){
    	 verifyPartialMessage(gethelp_pageHashmap("ActivityErrorMessage"),expected , 0, 18);;
     }
     
}