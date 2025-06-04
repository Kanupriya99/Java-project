package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	//WebElement using PageFactory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
    @FindBy(xpath = "//*[@class='oxd-userdropdown-name']")
    WebElement Userprofile;
	
	@FindBy(xpath = "//p[text()='Invalid credentials']")
	WebElement errorMsg;

	public void enterusername(String user)
	{
	 username.clear();
     username.sendKeys(user);
     }

    public void enterpassword(String passwordd)
    {
    	password.clear();
    	password.sendKeys(passwordd);
    }
    
    public void clickloginbutton()
    {
    	 login.click();	
    }
 
    public void login(String Username, String password) {
    	enterusername(Username);
    	enterpassword(password);
    	clickloginbutton();
    }

    public boolean isLoginSuccessful() {
        try {
            waitForVisibility(Userprofile);
            return Userprofile.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
	
   
    }



