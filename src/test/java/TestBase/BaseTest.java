package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Properties prop;
	
	
	@BeforeClass
	public void initialzation() throws IOException {
	
		prop =new Properties();
//		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"\\configration\\config.properties");
		File filepath = new File(System.getProperty("user.dir")+"\\src\\main\\java\\configration\\config.properties");
		FileInputStream file1 = new FileInputStream(filepath);

		prop.load(file1);
		ChromeOptions opt= new ChromeOptions();
		//opt.addArguments("--disable-save-password-bubble");
		//opt.setExperimentalOption("prefs", Map.of("credentials_enable_service", false,"profile.password_manager_enabled", false));
		
		
		//Disable google password manager popup
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		
	}
	
	
	@AfterClass
	public void terminate() {
		driver.quit();
	}
}
