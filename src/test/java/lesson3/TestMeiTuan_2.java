package lesson3;


import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.TestData;
import utils.TestSuite;

public class TestMeiTuan_2 extends TestSuite{	
	
	@Test(description="使用xpath")
	public void getGrouponDetails(){
		
		String[] args = {"小吃快餐","KTV","美食"};
		
		for(int i=0;i<args.length;i++){
		    driver.findElement(By.xpath("//android.widget.TextView[@text='"+args[i]+"']")).click();		    
		    au.back();
		}
		
		
	}
	
	

	
	@AfterClass
	public void realse(){
		driver.quit();
	}
}









