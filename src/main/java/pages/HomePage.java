package pages;

import io.appium.java_client.AppiumDriver;

public class HomePage extends PageBase{

	public AppiumDriver driver;
	
	public  String category = "//android.widget.TextView[@text='%1$s']";
	
	public String mine = "//android.widget.TextView[@text='�ҵ�']";
	
	public String login = "com.sankuai.meituan:id/login";
	
	//����ϲ��
	public String favoriteFirst = "//android.widget.FrameLayout[1]/child::android.widget.TextView[@resource-id='com.sankuai.meituan:id/brand']";
		
	public HomePage(AppiumDriver driver){
		this.driver = driver;
	}
	
	
	
	
	
}
