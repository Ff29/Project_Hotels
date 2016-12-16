package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;

public class customListener extends TestListenerAdapter{
	
	@Attachment(type = "image/png")
	private byte[] createAttachment() {
	    return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
	 @Override
	  public void onTestFailure(ITestResult testResult) {
		 createAttachment();
		 System.out.println(testResult.getName());
		 System.out.println(testResult.getThrowable().getMessage());
	  }
	
}
