package Page;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myinfo_PersonalDetailsPage extends BasePage {

	public Myinfo_PersonalDetailsPage(WebDriver driver) {
		super(driver);
		
	}

	//WebElement using PageFactory
	@FindBy(xpath="//a[.//span[text()='My Info']]")
	WebElement myInfo;
	
	@FindBy(name ="firstName")
	WebElement FirstName;
	
	@FindBy(name ="middleName")
	WebElement MiddleName;
	
	@FindBy(name ="lastName")
	WebElement LastName;
	
	@FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
	WebElement genderselection;
	
	@FindBy(xpath ="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    WebElement Marital_status;
	
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]")
	WebElement Nationality;
	
	@FindBy(xpath ="(//button[@type='submit'])[1]")
	WebElement savebutton1;
	
	@FindBy(css =".oxd-button.oxd-button--medium.oxd-button--text")
	WebElement addbutton;
	
	@FindBy(className ="oxd-file-button")
	WebElement Browse;
	
	@FindBy(xpath ="(//button[@type='submit'])[2]")
	WebElement savebutton2;
	
	@FindBy(xpath = "//i[contains(@class, 'bi-download')]")
    WebElement DownloadButton ;
	
	@FindBy(xpath ="(//button[@type='submit'])[3]")
	WebElement Downloadsavebutton;
	
	@FindBy(css =".oxd-icon.bi-trash")
	WebElement Deletebutton;
	
	@FindBy(css=".oxd-icon.bi-trash.oxd-button-icon")
	WebElement DeleteClick;
	
	//action
	
	public void myInfo()
	{
		waitForVisibility(myInfo);
			myInfo.click();
			waitForVisibility(FirstName);
	}
	public void Enter_Firstname(String firstname)
	{
		waitForVisibility(FirstName);
		FirstName.clear();
		FirstName.sendKeys(firstname);
     }
	
	public void Enter_Middlename(String middlename)
	{
		waitForVisibility(MiddleName);
		MiddleName.clear();
		MiddleName.sendKeys(middlename);
     }

	public void Enter_Lastname(String lastname)
	{
		waitForVisibility(LastName);
		LastName.clear();
		LastName.sendKeys(lastname);
     }

	public void selectGender()
	{
		waitForVisibility(genderselection);
		genderselection.click();
    }
	
	public void selectMaritalStatus()
	{
		waitForVisibility(Marital_status);
		Marital_status.click();
    }

	public void selectNationality()
	{
		waitForVisibility(Nationality);
		Nationality.click();
    }
	
	public void clickSaveButton1()
	{
		waitForVisibility(savebutton1);
		savebutton1.click();
    }
	
	public void Clickaddbutton() throws InterruptedException, AWTException
	{
		waitForVisibility(addbutton);
		addbutton.click();
		Thread.sleep(1000);
		uploadfile();
		Downloadsavebutton.click();
		
	}

	public void ClickDownlaodButton()
	{
		
		waitForClickability(DownloadButton );
		DownloadButton.click();
	}
	
	public void ClickDeletebutton() 
	{
		waitForVisibility(Deletebutton);
	    waitForClickability(Deletebutton);
		Deletebutton.click();
		 waitForClickability(DeleteClick);
		DeleteClick.click();
		
	}
	public void fillPersonalDetails(String FirstName, String MiddleName, String LastName ) {
		
		Enter_Firstname(FirstName);
		Enter_Middlename(MiddleName);
		Enter_Lastname(LastName);
		selectGender();
		selectMaritalStatus();
		selectNationality();
		clickSaveButton1();
    }
	



}
