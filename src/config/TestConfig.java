package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ExcelDataProvider;
import lib.BrowserAction;
import lib.ClickEvents;
import lib.TypeEvents;

public class TestConfig {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	@Test
	public void startTest(){
		
		ExcelDataProvider excel = new ExcelDataProvider();
		report = new ExtentReports("C:/Users/bhaskar/workspace/KDF/KeDrFr/HTMLReport/login.html");
		logger = report.startTest("logindemoqa");
		
		int rowcount = excel.rowCount("LoginForm");
		
		for(int i=1;i<=rowcount;i++){
			
			String description=excel.getData("LoginForm", i, 0);
			String object_type=excel.getData("LoginForm", i, 1);
			String actions=excel.getData("LoginForm", i, 2);
			String locator_type=excel.getData("LoginForm", i, 3);
			String locator_value=excel.getData("LoginForm", i, 4);
			String testdata=excel.getData("LoginForm", i, 5);
			
			if(object_type.equalsIgnoreCase("browser"))
			{
				if(testdata.equalsIgnoreCase("firefox"))
				{
					if(actions.equalsIgnoreCase("startbrowser"))
					{
						driver = new FirefoxDriver();
					}
					
					if(actions.equalsIgnoreCase("closebrowser"))
					{
						driver.close();
					}
				}
				
				
				if(testdata.equalsIgnoreCase("chrome"))
				{
					if(actions.equalsIgnoreCase("startbrowser"))
					{
						driver = new ChromeDriver();
					}
					
					if(actions.equalsIgnoreCase("closebrowser"))
					{
						driver.close();
					}
				}
				
				logger.log(LogStatus.INFO, description);
				
			}
			
			if(object_type.equalsIgnoreCase("openApp"))
			{
				if(actions.equalsIgnoreCase("navigate"))
				{
					BrowserAction.openApplication(driver, testdata);	
					logger.log(LogStatus.INFO, description);
				}	
			}
				
			
			if(object_type.equalsIgnoreCase("typetext")){
				
				String status=TypeEvents.typeAction(driver, locator_type, locator_value, testdata); // validation
				if(status.equalsIgnoreCase("pass"))
				{
				logger.log(LogStatus.INFO, description);
				}else
				{
				logger.log(LogStatus.FAIL, description);
				}
			}
			
			
			if(object_type.equalsIgnoreCase("click"))
			{
				ClickEvents.clickAction(driver, locator_type, locator_value);	
				logger.log(LogStatus.INFO, description);
			}		
			
		}
		
		report.endTest(logger);
		report.flush();
		
	}
}
