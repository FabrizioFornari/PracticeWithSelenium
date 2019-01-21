package proslab.unicam.usefultests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.restassured.RestAssured;
import proslab.unicam.config.PropertiesFile;

import java.util.List;


public class HttpResponseCode {

    WebDriver driver;
    int statusCode;
    
    final static Logger log = Logger.getLogger(HttpResponseCode.class.getName());
	
	static PropertiesFile prop = new PropertiesFile();
	
	

    public void checkBrokenLinks() {
    	
    	prop.readPropertiesFile();
		  
		System.setProperty("webdriver.chrome.driver", prop.getProjectPath()+"/drivers/chromedriver");
		
		
        driver = new ChromeDriver();
        driver.get("http://pros.unicam.it");

//Get all the links on the page
        List<WebElement> links = driver.findElements(By.cssSelector("a"));

        String href;

        for(WebElement link : links) {
            href = link.getAttribute("href");
            statusCode = new HttpResponseCode().httpResponseCodeViaGet(href);

            try {
	            if(200 != statusCode) {
	                System.out.println(href + " gave a response code of " + statusCode);
	            }
            }catch(Exception e) {
            	driver.close();
            }
        }
        
        
    }
    
    public int httpResponseCodeViaGet(String url) {
        return RestAssured.get(url).statusCode();
	}
//	
//	public int httpResponseCodeViaPost(String url) {
//	    return RestAssured.post(url).statusCode();
//	}
//	
//	public static void main(String args[]) {
//	    new HttpResponseCode().httpResponseCodeViaGet("http://www.google.com");
//	}
//
    public static void main(String args[]) {
        new HttpResponseCode().checkBrokenLinks();
    }
}
