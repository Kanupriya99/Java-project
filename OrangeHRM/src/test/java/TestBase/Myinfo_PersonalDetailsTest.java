package TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import Page.LoginPage;
import Page.Myinfo_PersonalDetailsPage;

public class Myinfo_PersonalDetailsTest  extends BaseTest {

	

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
     public void openMyInfo()
	{  
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.myInfo();     
		
	}

	@Test(priority = 2)
	public void withoutdetials()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.Enter_Firstname(" ");
		PersonalDetailsTest.Enter_Middlename(" ");
		PersonalDetailsTest.Enter_Lastname(" ");
		PersonalDetailsTest.clickSaveButton1();
		Assert.assertFalse(false, "Validation error should appear");  
	}

	@Test(priority = 3)
	public void Add_Attachment() throws InterruptedException, AWTException
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.Clickaddbutton();
		
	}
	
	
	@Test(priority = 4 )
	public void  FullDetails()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.Enter_Firstname(prop.getProperty("firstname"));
		PersonalDetailsTest.Enter_Middlename(prop.getProperty("middlename"));
		PersonalDetailsTest.Enter_Lastname(prop.getProperty("lastname"));
		PersonalDetailsTest.selectGender();
		PersonalDetailsTest.selectMaritalStatus();
		PersonalDetailsTest.selectNationality();
		PersonalDetailsTest.clickSaveButton1();
        
	}
	@Test(priority = 5)
	public void ClickDownlaodButton()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.ClickDownlaodButton();
	}
	
	@Test(priority = 6)
	public void ClickDeletebutton()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.ClickDeletebutton();
	}

}