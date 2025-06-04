package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(className ="oxd-userdropdown-name")
	WebElement profile_name;
	
	@FindBy(xpath ="//a[text() ='Logout']")	
	WebElement logout;
	
	public void click_profile_name()
	{
		waitForClickability(profile_name);
		profile_name.click();
	}
	
	public void click_logout()
	{
		waitForClickability(profile_name);
		profile_name.click();
	}
}
