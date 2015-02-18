package lesson2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ListItems;
import pages.LoginPage;
import utils.Action;

public class TestMeiTuan_1 {
   
	public AppiumDriver driver;
	public HomePage homepage;
	public ListItems listitems;
	public LoginPage loginpage;
	public Action au;
	
	@BeforeClass
	public void initalAppiumSettings() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName","Samsung_Galaxy_Note_3" );
		cap.setCapability("ignoreUnimportantViews","true" );
		cap.setCapability("newCommandTimeout","180" );
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		au = new Action(driver);
		homepage = new HomePage(driver);
		listitems = new ListItems(driver);
		loginpage = new LoginPage(driver);
	}
	
	
	@Test(description="使用xpath")
	public void getGrouponDetails(){
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='美食']")).click();
		//List<WebElement> elements = driver.findElements(By.id("com.sankuai.meituan:id/title"));		
		//elements.get(0).click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/child::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.sankuai.meituan:id/title']")).click();
		
	}
	
	
	
	@Test(description="动态元素")
	public void getdynamicElements(){ 
       au.click(By.xpath(homepage.getElement(homepage.category, "美食")));       
       au.click(By.xpath(listitems.firstitem));
       au.click(By.xpath(listitems.discount));
	}
	
	
	
	@Test(description="swipe")
	public void testSwipe(){
	   au.click(By.xpath(homepage.getElement(homepage.category, "美食")));	       
	   au.swipe(By.xpath(listitems.firstitem), By.xpath(listitems.discount),false);
	   au.click(By.xpath(listitems.discount));
	}
	
	
	@Test(description="tap")
	public void testTap(){
	   au.tap(By.xpath(homepage.getElement(homepage.category, "美食")));	       
	   au.swipe(By.xpath(listitems.firstitem), By.xpath(listitems.discount),false);
	   au.tap(By.xpath(listitems.discount));
	}
	
	
	@Test(description="swipe left")
	public void testDragAndDrop() throws InterruptedException {	   
	   au.categorySwipe(By.xpath(homepage.getElement(homepage.category, "KTV")));	
	   Thread.sleep(3000);
	   au.click(By.xpath(homepage.getElement(homepage.category, "生活服务")));
	}
	
	@Test(description="login")
	public void login() throws InterruptedException{
		au.tap(By.xpath(homepage.mine));
		au.tap(By.id(homepage.login));
		au.setValue(By.id(loginpage.username), "Shanghai_Terry");
		au.tap(By.id(loginpage.login));
		au.setValue(By.id(loginpage.password), "admin123");
		au.tap(By.id(loginpage.login));
		
	}
	
	@AfterClass
	public void realse(){
		driver.quit();
	}
}









