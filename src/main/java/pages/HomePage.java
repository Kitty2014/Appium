package pages;

import io.appium.java_client.AppiumDriver;

public class HomePage extends PageBase{

	public AppiumDriver driver;
	
	public  String category = "//android.widget.TextView[@text='%1$s']|//span[text()='%1$s']";
	
	public String mine = "//android.widget.TextView[@text='我的']";
	
	public String login = "com.sankuai.meituan:id/login";
	public String balance = "com.sankuai.meituan:id/balance";
	
	
	
	public MyAccountPage myaccountpage = new MyAccountPage();
	//猜你喜欢
	public String favoriteFirst = "//android.widget.FrameLayout[1]/child::android.widget.TextView[@resource-id='com.sankuai.meituan:id/brand']";
		
	public HomePage(AppiumDriver driver){
		this.driver = driver;
	}
	
	
	public class MyAccountPage{
		
		public String exit = "com.sankuai.meituan:id/logout";
		public String logout = "//android.widget.Button[@text='退出']";
		
		
	}
	
	
}
