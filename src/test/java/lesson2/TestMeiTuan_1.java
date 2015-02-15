package lesson2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMeiTuan_1 {
public AppiumDriver driver;
	
	@BeforeClass
	public void initalAppiumSettings() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName","Samsung_Galaxy_Note_3" );
		cap.setCapability("ignoreUnimportantViews","true" );
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	
	@Test
	public void getGrouponDetails(){
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='√¿ ≥']")).click();
		//List<WebElement> elements = driver.findElements(By.id("com.sankuai.meituan:id/title"));		
		//elements.get(0).click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/child::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.sankuai.meituan:id/title']")).click();
		
	}
	
	@AfterClass
	public void realse(){
		driver.quit();
	}
}
