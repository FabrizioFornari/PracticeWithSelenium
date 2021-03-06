package proslab.unicam.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ASimpleSeleniumTest {

	static String browser;
	
	static WebDriver driver;
	
	static String projectPath = System.getProperty("user.dir"); 
	
	public static void main(String[] args) throws InterruptedException {
			
		browser="Chrome";
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
		
		driver = new ChromeDriver();

		//testGoogle();
		testGmail();
		//testPros();
		//testProsWebElements();
//		setBrowser();
//		setBrowserConfig();
		
		driver.close();
	
	}
	
	

	public static void setBrowser() {
		browser="Firefox";
		//browser="Chrome";
	}

	public static void setBrowserConfig() {
		
		if(browser.contains("Chrome")) {
			
			//Chrome
			//This condition block sets config for Chrome browser
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		
		if(browser.contains("Firefox")) {
				
			//Firefox	
			//This condition block sets config for Firefox browser
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", true);
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/chromedriver");
			driver = new FirefoxDriver(options);

		}		
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
		
		System.out.println(at);
		if(at.equalsIgnoreCase(et)) {
			System.out.println("Test Successful");
		}else{
			System.out.println("Test Failure");
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
		
		System.out.println(at);		
		
//		Thread.sleep(1000);
		
		if(at.equalsIgnoreCase(et)) {
			System.out.println("Test Successful");
		}else{
			System.out.println("Test Failure");
		}
	}
	
	public static void testPros() throws InterruptedException {
		driver.get("http://pros.unicam.it/");
		driver.manage().window().maximize();
		
		String at = driver.getTitle();
		String et = "PROS";
		
		System.out.println(at);
//		Thread.sleep(1000);
		
		if(at.equalsIgnoreCase(et)) {
			System.out.println("Test Successful");
		}else{
			System.out.println("Test Failure");
		}
	}
	

	
	public static void testProsWebElements() throws InterruptedException {
		driver.get("http://pros.unicam.it/");
		
		//Estrae gli elementi che possono essere utilizzati come input
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		
		int count = listOfInputElements.size();

		System.out.println("Count of Input elements : "+count);
		
		
	}
	
	
}
