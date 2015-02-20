package lesson3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.SwipeElementDirection;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import utils.TestSuite;

public class TestWebView extends TestSuite{
	

	@Test(description="����browser")
	public  void testBrowser() throws MalformedURLException, InterruptedException {
	    
	   driver.get("http://i.meituan.com");
	   au.waitForElementPresent(By.xpath("//a[contains(text(),'�������ʴ�����')]"));
	  
	   au.click(By.xpath("//a[contains(text(),'�������ʴ�����')]"));	   
	   au.click(By.xpath("//span[text()='��ʳ']"));
	   au.swipe(By.xpath("//dl[1]/descendant::a/descendant::div/div[@class='title text-block']"), By.xpath("//span[text()='��ѡ��ȯ']"), false);
	   //au.click(By.xpath("//dl[1]/descendant::a/descendant::div/div[@class='title text-block']"));
       
	   au.click(By.xpath("//span[text()='��ѡ��ȯ']"));
	 
	}
	
	
	@AfterClass
	public void quitDriver(){
		au.driver.quit();
	}
	
}
