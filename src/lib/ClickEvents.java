package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickEvents {
	
public static String clickAction(WebDriver driver,String locatortype, String locatorvalue){
		
		try {
			if(locatortype.equalsIgnoreCase("id")){
				driver.findElement(By.id(locatorvalue)).click();
			}else if(locatortype.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(locatorvalue)).click();
			}else if(locatortype.equalsIgnoreCase("name")){
				driver.findElement(By.name(locatorvalue)).click();
			}else if(locatortype.equalsIgnoreCase("name")){
				driver.findElement(By.tagName(locatorvalue)).click();
			}		
			return "pass";
			
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}

}
