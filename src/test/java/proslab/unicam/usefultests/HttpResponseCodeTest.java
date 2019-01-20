package proslab.unicam.usefultests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.restassured.RestAssured;
import proslab.unicam.config.PropertiesFile;

import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;


	public class HttpResponseCodeTest {

	    static WebDriver driver;
	    int statusCode;
	    
	    final static Logger log = Logger.getLogger(HttpResponseCodeTest.class.getName());
				
		static String projectPath = System.getProperty("user.dir"); 
		
		static String configFilename = projectPath+"/src/main/java/proslab/unicam/logandreports/log4j.properties";
		
    
	    @AfterAll
	    public static void tearDown2(){
	    	driver.close();
	    }
	    
	    
	    
	    @Test
//	    @Disabled
	    public void testBrokenLinks() {
	    	checkBrokenLinks();
	    }
	    
	    public void checkBrokenLinks() {
	    	
	    	PropertyConfigurator.configure(configFilename);
			PropertiesFile.readPropertiesFile();
	    	try
	    	{
	    		
	    	//code to test
	
	    	String projectPath = System.getProperty("user.dir");  
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
			
			
	        driver = new ChromeDriver();
	        driver.get("http://pros.unicam.it");

	//Get all the links on the page
	        List<WebElement> links = driver.findElements(By.cssSelector("a"));

	        String href;

	        for(WebElement link : links) {
	            href = link.getAttribute("href");
	            try
		    	{
	            	statusCode = RestAssured.get(href).statusCode();
	            	System.out.println("statusCode: "+statusCode);

		    	}
		    	catch (Exception e)
		    	{
//		    		tearDown();
		    		throw new AssertionError(href +"A clear description of the failure", e);
		    	}
	            
	            if(200 != statusCode) {
	                System.out.println(href + " gave a response code of " + statusCode);
	            }
	        }
	        
	    	}
	    	catch (Exception e)
	    	{
//	    		tearDown();
	    		throw new AssertionError("A clear description of the failure", e);
	    	}
	    }
	    
//	    public void tearDown(){
//	    	driver.close();
//	    }
	    
	}


