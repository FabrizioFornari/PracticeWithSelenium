package proslab.unicam.selenium;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import proslab.unicam.config.PropertiesFile;
import proslab.unicam.logandreports.FirstLogger;

//import java.util.logging.Level;
////for defining a Logger
//import java.util.logging.Logger;

public class FirstSeleniumTest {

	public static String browser;
	static WebDriver driver;
	
	final static Logger log = Logger.getLogger(FirstSeleniumTest.class.getName());
	
	static String projectPath = System.getProperty("user.dir"); 
	
	static String configFilename = projectPath+"/src/main/java/proslab/unicam/logandreports/log4j.properties";
	
	
	public static void main(String[] args) throws InterruptedException {
			
			setupLogger();
			//setBrowser();
			setBrowserConfig();
			runTest();
			closeDriver();
			
			PropertiesFile.writePropertiesFile();
	}
	
	
	/**
	 * Description
	 * @author fabrizio.fornari@unicam.it
	 * @date 08/01/2019 
	 */
	public static void setBrowser() {
		browser="Firefox";
		//browser="Chrome";
	}

	public static void setBrowserConfig() {
		
		if(browser.contains("Chrome")) {
			
			//Chrome
			//This condition block sets config for Chrome browser
			System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver");
			driver = new ChromeDriver();
		}
		
		if(browser.contains("Firefox")) {
				
			//Firefox	
			//This condition block sets config for Firefox browser
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", true);
			System.setProperty("webdriver.gecko.driver", projectPath+"/driver/geckodriver");	
			driver = new FirefoxDriver(options);

		}		
	}
		
	public static void runTest() throws InterruptedException {
		
//		
//		testGmail();
//		testGoogle();
//		testPros();
		testProsWebElements();


	}
	
	public static void closeDriver() {
		driver.close();
//		driver.quit();
	}
	
	
	public static void testGoogle() throws InterruptedException {
		//Query google chrome
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("PROS Lab");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		String at=driver.findElement(By.className("LC20lb")).getText();
		String et = "Home - PROS PROcesses and Services Lab";
		
		log.info(at);
//		System.out.println(at);
		if(at.equalsIgnoreCase(et)) {
			log.info("Test Successful");
		}else{
			log.info("Test Failure");
		}
	}
	
	public static void testGmail() throws InterruptedException {
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("fabrizio.fornari@studenti.unicam.it");
		
//		Thread.sleep(1000);
		driver.findElement(By.className("CwaK9")).click();
//		Thread.sleep(1000);
		
		String at = driver.getTitle();
		String et = "gmail";
		
		log.info(at);
		

		
//		Thread.sleep(1000);
		
		if(at.equalsIgnoreCase(et)) {
			log.info("Test Successful");
		}else{
			log.info("Test Failure");
		}
	}
	
	public static void testPros() throws InterruptedException {
		driver.get("http://pros.unicam.it/");
		driver.manage().window().maximize();
		
		String at = driver.getTitle();
		String et = "PROS";
		
		log.info(at);
//		Thread.sleep(1000);
		
		if(at.equalsIgnoreCase(et)) {
			log.info("Test Successful");
		}else{
			log.info("Test Failure");
		}
	}
	
	public static void setupLogger() {
		//log = Logger.getLogger(FirstSeleniumTest.class);
		PropertyConfigurator.configure(configFilename);
		PropertiesFile.readPropertiesFile();
	}
	
	public static void testProsWebElements() throws InterruptedException {
		driver.get("http://pros.unicam.it/");
		
		//Estrae gli elementi che possono essere utilizzati come input
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		
		int count = listOfInputElements.size();

		System.out.println("Count of Input elements : "+count);
		
		log.info("This is an information message");
		log.error("This is an error message");
		log.warn("This is a warning message");
		log.fatal("This is a fatal message");
		
	
		
	}
	
	
}
