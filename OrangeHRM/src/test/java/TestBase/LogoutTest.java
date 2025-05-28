package TestBase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.LoginPage;
import Page.LogoutPage;
import Page.Myinfo_PersonalDetailsPage;

public class LogoutTest extends BaseTest {    

	@BeforeClass()
	public void Login() 
	{

		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterusername(prop.getProperty("username"));	
		loginpage.enterpassword(prop.getProperty("password"));
		loginpage.clickloginbutton();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed");

	}
	
	@Test(priority = 1)
     public void click_on_profile_name()
	{  
		LogoutPage  logout = new LogoutPage(driver);
		logout.click_profile_name();     
		
	}
	
	@Test(priority = 2)
    public void click_on_logout()
	{  
		LogoutPage  logout = new LogoutPage(driver);
		logout.click_logout();     
		
	}
}
