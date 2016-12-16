package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.base.Function;


public class WebDriverFactory {
	
	
	
	private final static String operatingSystem = System.getProperty("os.name");
	private final static String currentDirectory = System.getProperty("user.dir");
	private final static String fileSeparator = System.getProperty("file.separator");
	private int currentOS;
	private static WebDriver driver=null;
	private static String siteUrl = "https://www.hotels.com/";
	
	
	public static final String USERNAME = "technosoft";
	public static final String ACCESS_KEY = "269969d4-632a-4e8f-a1e4-c924430aa4fe";
    public static final String saucelabURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    
    public static WebDriver getDriver() {
		return driver;
	}
	
	public int checkOs(){
		
		if((operatingSystem.toLowerCase().contains("win"))){
			return currentOS = 1;
		}else if((operatingSystem.toLowerCase().contains("mac"))){
			return currentOS= 2;
		}
		return currentOS; 
	}
	
	public void browser(String browserName) throws MalformedURLException{
		checkOs();
		String driverPath = currentDirectory;
		switch(currentOS){
		
		case 1: 
			if (browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver","WinWebDrivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "WinWebDrivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("saucelabs")){
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setCapability("platform", "Windows XP");
				caps.setCapability("version", "43.0");
				driver = new RemoteWebDriver(new URL(saucelabURL), caps);
			}else if(browserName.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver", "WinWebDrivers/MicrosoftWebDriver.exe");
				driver = new InternetExplorerDriver();
			}else {
				System.out.println("No Driver Found!");
				}
			break;
		case 2:
			driverPath = driverPath + "MacWebDrivers" + fileSeparator;
			if (browserName.equalsIgnoreCase("chrome")) {
				driverPath = driverPath + "chromedriver";
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("fireFox")) {
				driverPath = driverPath + "geckodriver";
				System.setProperty("webdriver.gecko.driver", driverPath);
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("saucelabs")) {
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setCapability("platform", "Windows XP");
				caps.setCapability("version", "43.0");
				driver = new RemoteWebDriver(new URL(saucelabURL), caps);
			}
			else {
				System.out.println("No Driver Found!");			
			}
			break;
			}
	}
	
	
		@BeforeTest(alwaysRun=true)
		@Parameters("browserName")
		public void openDriver(String browserName) throws MalformedURLException{
		
			browser(browserName);
			driver.navigate().to(siteUrl);
			System.out.println("The operating system of this machine is: "+operatingSystem);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
	
		@AfterTest(alwaysRun = true)
		public void tearDown(){
				if(driver!=null){
				driver.manage().deleteAllCookies();
				driver.quit();
				}
			}
		@Parameters("browserName")
		@BeforeMethod
		public void goToHomePage(String browserName){
			if(browserName.equalsIgnoreCase("saucelabs")){
				driver.navigate().to(siteUrl);
				getDriver().findElement(By.cssSelector(".trigger")).click();
				}else{
			getDriver().findElement(By.cssSelector("#hdr-deals")).click();
			}
		}
		@AfterMethod
		public void deleteCookies(){			
			driver.manage().deleteAllCookies();
			}
		public static WebElement webDriverFluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotVisibleException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");
                
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }
		public static void waitUntilVsible(By locator){
			WebElement element = (new WebDriverWait(driver, 300))
					   .until(ExpectedConditions.elementToBeClickable(locator));
		}
		public static void implicitWaitOn(int miliseconds){
			WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(miliseconds, TimeUnit.MILLISECONDS);
		}
}
