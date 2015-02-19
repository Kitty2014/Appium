package lesson2;


import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.TestData;
import utils.TestSuite;

public class TestMeiTuan_1 extends TestSuite{
   

	public TestData td;
	
	@BeforeClass
	public void initalTestCaseSettings() throws MalformedURLException{
		td = new TestData(System.getProperty("user.dir")+"\\src\\test\\resources\\lesson2\\userinfo.csv");

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
       au.click(By.xpath(listitemspage.firstitem));
       au.click(By.xpath(listitemspage.discount));
	}
	
	
	
	@Test(description="swipe")
	public void testSwipe(){
	   au.click(By.xpath(homepage.getElement(homepage.category, "美食")));	       
	   au.swipe(By.xpath(listitemspage.firstitem), By.xpath(listitemspage.discount),false);
	   au.click(By.xpath(listitemspage.discount));
	}
	
	
	@Test(description="tap")
	public void testTap(){
	   au.tap(By.xpath(homepage.getElement(homepage.category, "美食")));	       
	   au.swipe(By.xpath(listitemspage.firstitem), By.xpath(listitemspage.discount),false);
	   au.tap(By.xpath(listitemspage.discount));
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
	
	
	@Test(description="loginwithdatadriver")
	public void testDataDriver(){
		au.tap(By.xpath(homepage.mine));
		
		if(au.isElementPresented(By.id(homepage.balance))){
			au.tap(By.id(homepage.balance));
			au.tap(By.id(homepage.myaccountpage.exit));
			au.tap(By.xpath(homepage.myaccountpage.logout));
		}
		au.tap(By.id(homepage.login));
		au.setValue(By.id(loginpage.username), td.getTestData("username", "tc1"));
		au.tap(By.id(loginpage.login));
		au.setValue(By.id(loginpage.password), td.getTestData("password", "tc1"));
		au.tap(By.id(loginpage.login));
	
		Assert.assertEquals(au.isElementPresented(By.id(homepage.balance)), true);
		
	}
	
	
	@AfterClass
	public void realse(){
		driver.quit();
	}
}









