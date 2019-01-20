package proslab.unicam.katalan;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import proslab.unicam.config.PropertiesFile;


class KatalanTest {

	private static WebDriver driver;
//	private static String baseUrl;
//	private boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	final static Logger log = Logger.getLogger(KatalanTest.class.getName());
	
	
	static String configFilename = "/Users/user/Documents/Applicazioni_Importanti/Eclipse IDE for Java EE Developers/New/WorkspaceEclipseJavaEE/proslabSelenium/src/main/java/proslab/unicam/logandreports/log4j.properties";
	

    
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		PropertyConfigurator.configure(configFilename);
		PropertiesFile.readPropertiesFile();
	
		
		String projectPath = System.getProperty("user.dir");  
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
		
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //250ms frequence of pulling
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	

	
	@Test
	  public void testProsTest1() throws Exception {
	    System.out.println("testProsTest1_Start");
	    driver.get("http://pros.unicam.it");
	    driver.findElement(By.id("pirate-forms-contact-name")).click();
	    driver.findElement(By.id("pirate-forms-contact-name")).clear();
	    driver.findElement(By.id("pirate-forms-contact-name")).sendKeys("pippo");
	    driver.findElement(By.id("pirate-forms-contact-email")).clear();
	    driver.findElement(By.id("pirate-forms-contact-email")).sendKeys("pippo");
	    driver.findElement(By.id("pirate-forms-contact-subject")).clear();
	    driver.findElement(By.id("pirate-forms-contact-subject")).sendKeys("pippo");
	    driver.findElement(By.id("pirate-forms-contact-message")).clear();
	    driver.findElement(By.id("pirate-forms-contact-message")).sendKeys("pippo");
	    driver.findElement(By.id("pirate-forms-contact-submit")).click();
	    System.out.println("testProsTest1_End");
	  }


	//Not used but useful
//	private boolean isElementPresent(By by) {
//
//	    try {
//	      driver.findElement(by);
//	      return true;
//	    } catch (NoSuchElementException e) {
//	      return false;
//	    }
//	  }
//
//
//	  private boolean isAlertPresent() {
//
//	    try {
//	      driver.switchTo().alert();
//	      return true;
//	    } catch (NoAlertPresentException e) {
//	      return false;
//	    }
//	  }
//
//	  private String closeAlertAndGetItsText() {
//
//	    try {
//	      Alert alert = driver.switchTo().alert();
//	      String alertText = alert.getText();
//	      if (acceptNextAlert) {
//	        alert.accept();
//	      } else {
//	        alert.dismiss();
//	      }
//	      return alertText;
//	    } finally {
//	      acceptNextAlert = true;
//	    }
//	  }
	

}
