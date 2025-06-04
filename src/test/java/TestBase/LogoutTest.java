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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
   	 Assert.assertTrue(loginpage.isLoginSuccessful(),"login should be successful");

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
