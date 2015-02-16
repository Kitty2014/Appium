package pages;

import io.appium.java_client.AppiumDriver;

public class HomePage extends PageBase{

	public AppiumDriver driver;
	
	public  String category = "//android.widget.TextView[@text='%1$s']";
		
	public HomePage(AppiumDriver driver){
		this.driver = driver;
	}
	
	
	
	
	
}
