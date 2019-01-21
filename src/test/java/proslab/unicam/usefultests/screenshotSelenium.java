package proslab.unicam.usefultests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import proslab.unicam.config.PropertiesFile;

class screenshotSelenium {

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
	 public void myTest() throws Exception {

			System.setProperty("webdriver.chrome.driver", prop.getProjectPath()+"/drivers/chromedriver");
			
	        driver = new ChromeDriver();
	        driver.get("http://pros.unicam.it");

	        //goto url

	        //Call take screenshot function

	        this.takeSnapShot(driver, prop.getProjectPath()+"/files/screenshoot.png") ;  
	    }
	
	
	
	 public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	     //Convert web driver object to TakeScreenshot

		 System.out.println("takeSnapShot");
	     
		 TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	     //Call getScreenshotAs method to create image file

	     File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	     //Move image file to new destination

	     File DestFile=new File(fileWithPath);

	     //Copy file at destination

	     FileUtils.copyFile(SrcFile, DestFile);
	                
	     System.out.println("tookSnapShot");

	    }
	
	
}
