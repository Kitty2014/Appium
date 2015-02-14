package lesson1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalculator {

	public AppiumDriver driver;
	
	@BeforeClass
	public void initalAppiumSettings() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName","Samsung_Galaxy_Note_3" );
		cap.setCapability("appActivity","com.android.calculator2.Calculator" );
		cap.setCapability("appPackage","com.android.calculator2" );
		cap.setCapability("appWaitActivity","com.android.calculator2.Calculator" );
		cap.setCapability("appWaitPackage","com.android.calculator2" );
		cap.setCapability("ignoreUnimportantViews","true" );
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}
	
	
	@Test
	public void plus() throws InterruptedException{
		
		try{
			driver.findElement(By.id("com.android.calculator2:id/clear")).click();
		}catch(Exception e){
			driver.findElement(By.id("com.android.calculator2:id/del")).click();
		}
		driver.findElement(By.id("com.android.calculator2:id/digit3")).click();
		driver.findElement(By.id("com.android.calculator2:id/plus")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit9")).click();
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
		
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void realse(){
		driver.quit();
	}
	
	
}
