package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TypeEvents {
	
	
	public static String typeAction(WebDriver driver,String locatortype, String locatorvalue, String data){
		
		try {
			if(locatortype.equalsIgnoreCase("id")){
				driver.findElement(By.id(locatorvalue)).sendKeys(data);
			}else if(locatortype.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(locatorvalue)).sendKeys(data);
			}else if(locatortype.equalsIgnoreCase("name")){
				driver.findElement(By.name(locatorvalue)).sendKeys(data);
			}else if(locatortype.equalsIgnoreCase("name")){
				driver.findElement(By.tagName(locatorvalue)).sendKeys(data);
			}	
			return "pass";
			
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}

}
