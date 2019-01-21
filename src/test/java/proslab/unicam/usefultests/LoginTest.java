package proslab.unicam.usefultests;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import proslab.unicam.config.PropertiesFile;


class LoginTest {
	
	
	static WebDriver driver;
	
	final static Logger log = Logger.getLogger(HttpResponseCode.class.getName());
		
	static PropertiesFile prop = new PropertiesFile();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		prop.readPropertiesFile();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	public void login() {
	
		loginBrowser();
	
	}
	
	
	public void loginBrowser() {
	
    	
		
		String projectPath = System.getProperty("user.dir");  
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
			
        driver = new ChromeDriver();
        
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.name("email")).sendKeys("your email id");
		
		driver.findElement(By.name("pass")).sendKeys("your password");
		
		driver.findElement(By.id("loginbutton")).click();
		
		
		//driver.findElement(By.className("_4rbf _53ij")).toString();
		
		System.out.println(driver.findElement(By.cssSelector("._4rbf._53ij")).getText());
		assertNotEquals("The email or phone number you’ve entered doesn’t match any account. Sign up for an account.", driver.findElement(By.cssSelector("._4rbf._53ij")).getText());
		
	}

}