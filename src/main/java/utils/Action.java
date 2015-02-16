package utils;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;

public class Action {


	public AppiumDriver driver;
	
	public Action(AppiumDriver driver){	
		this.driver = driver;		
	}
	
	public void click(By by){
		driver.findElement(by).click();
	}
	
	
	
	
}
