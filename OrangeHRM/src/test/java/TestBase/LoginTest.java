package TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.LoginPage;
import Page.Myinfo_PersonalDetailsPage;

public class LoginTest extends BaseTest {

	
			
	@Test(priority = 1)	
	
	public void invalidcredentials ()
	{

		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterusername("kanu");	
        loginpage.enterpassword("password");
	    loginpage.clickloginbutton();
	    Assert.assertFalse(false);
	}

    @Test(priority = 2)	
	
	public void invalidusername()
	{
        LoginPage loginpage =new LoginPage(driver);
		loginpage.enterusername("kanu");	
        loginpage.enterpassword(prop.getProperty("password"));
	    loginpage.clickloginbutton();
	    Assert.assertFalse(false);
	}
	
    @Test(priority = 3)	
	
   	public void invalidpassword()
   	{
        LoginPage loginpage =new LoginPage(driver);
   		loginpage.enterusername(prop.getProperty("username"));	
        loginpage.enterpassword("kanu");
   	    loginpage.clickloginbutton();
   	    Assert.assertFalse(false);
   	}

    @Test(priority = 4)
    public void Validcredentials() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        loginpage.clickloginbutton();
        Assert.assertTrue(loginpage.isLoginSuccessful(),"login should be successful");
	
  
       
    
   }
}