package utils;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {


	public AppiumDriver driver;
	public TouchAction au;
	public Actions ac;
	
	public Action(AppiumDriver driver){	
		this.driver = driver;	
		au = new TouchAction(driver);
		ac = new Actions(driver);
	}
	
	public void click(By by){
		driver.findElement(by).click();
	}
	
	/**
	 * 
	 * @param startElement
	 * @param endElement
	 * @param Up 是否向上滑动
	 * 
	 */
	public void swipe(By startElement,By endElement,boolean Up){
		
		Point beginLoc;			
		WebElement start = driver.findElement(startElement);		
		beginLoc = start.getLocation();	
		WebElement end;
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);
		
		while(true){
			try{				
				end = driver.findElement(endElement);
				break;
			}catch(Exception e){
				if(Up){
					driver.swipe(beginLoc.getX(), beginLoc.getY(), beginLoc.getX()+30, beginLoc.getY()+90, 4000);
				}else{
					driver.swipe(beginLoc.getX(), beginLoc.getY(), beginLoc.getX()-30, beginLoc.getY()-90, 4000);
				}
			}
			
		}
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);	
		
	}
	
	
	public void tap(By by){		
		au.tap(driver.findElement(by)).release().perform();		
	}
	
	
	
	public void setValue(By by,String value){
		this.click(by);
		int size = driver.findElement(by).getText().length();
		driver.sendKeyEvent(123);//光标定位在最后
		for(int i =0;i<size;i++){
			driver.sendKeyEvent(AndroidKeyCode.BACKSPACE);
		}
		    
		driver.findElement(by).sendKeys(value);
		
	}
	
	
	public void categorySwipe(By source){
		
		WebElement start = driver.findElement(source);		
		Point beginLoc = start.getLocation();

		driver.swipe(beginLoc.getX(), beginLoc.getY(), beginLoc.getX()-700, beginLoc.getY(),8000);

	}
	
	
	
	public boolean isElementPresented(By by){
		boolean isDisplayed = false;
		
		try{
			isDisplayed = driver.findElement(by).isDisplayed();
		}catch(Exception e){
			isDisplayed = false;
		}
		return isDisplayed;
		
	}
	
	
}
