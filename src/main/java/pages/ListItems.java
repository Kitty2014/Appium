package pages;

import io.appium.java_client.AppiumDriver;

public class ListItems extends PageBase{

	public AppiumDriver driver;
	
	public  String firstitem = "//android.widget.FrameLayout[1]/child::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.sankuai.meituan:id/title']";
	
	public ListItems(AppiumDriver driver){
		this.driver = driver;
	}
	
	
	
	
	
}
