package pages;

import io.appium.java_client.AppiumDriver;

public class ListItemsPage extends PageBase{

	public AppiumDriver driver;
	
	public  String firstitem = "//android.widget.FrameLayout[1]/child::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.sankuai.meituan:id/title']";
	public String discount = "//android.widget.LinearLayout/android.widget.TextView[@text='多优惠+']";
	
	public ListItemsPage(AppiumDriver driver){
		this.driver = driver;
	}
	
	
	
	
	
}
