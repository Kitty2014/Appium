package pages;

import io.appium.java_client.AppiumDriver;

public class LoginPage extends PageBase{
	public AppiumDriver driver;
	
	//id
	public  String username = "com.sankuai.meituan:id/edit_username";
	public String password = "com.sankuai.meituan:id/edit_password";
	public String login = "com.sankuai.meituan:id/btn_login";
		
	public LoginPage(AppiumDriver driver){
		this.driver = driver;
	}
	
}
