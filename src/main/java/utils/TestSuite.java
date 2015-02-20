package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import pages.GroupOnDetailPage;
import pages.HomePage;
import pages.ListItemsPage;
import pages.LoginPage;

public class TestSuite {

	public AppiumDriver driver;
	public HomePage homepage;
	public ListItemsPage listitemspage;
	public LoginPage loginpage;
	public GroupOnDetailPage groupondetailpage;
	public Action au;
	
	
	@BeforeSuite
	public void AndroidSettings() throws MalformedURLException{
		
		TestData td = new TestData(System.getProperty("user.dir")+"\\src\\main\\resources\\gobalsettings.csv");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName",td.getTestData("deviceName", "tc1") );
		cap.setCapability("ignoreUnimportantViews",td.getTestData("ignoreUnimportantViews", "tc1") );
		cap.setCapability("newCommandTimeout",td.getTestData("newCommandTimeout", "tc1") );
		
		
		driver = new AndroidDriver(new URL("http://"+td.getTestData("server", "tc1")+"/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(Long.valueOf(td.getTestData("timeout", "tc1")), TimeUnit.MILLISECONDS);
		au = new Action(driver);
		
		
		
		homepage = new HomePage(driver);		
		listitemspage = new ListItemsPage(driver);
		loginpage = new LoginPage(driver);
		groupondetailpage  = new GroupOnDetailPage(driver);
		

	}
	
	

	
}
