package proslab.unicam.usefultests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

class screenshotSelenium {

	static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	        String projectPath = System.getProperty("user.dir");  
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
			
			
	        driver = new ChromeDriver();
	        driver.get("http://pros.unicam.it");

	        //goto url

	        //Call take screenshot function

	        this.takeSnapShot(driver, "/Users/user/Documents/Applicazioni_Importanti/Eclipse IDE for Java EE Developers/New/WorkspaceEclipseJavaEE/practiceWithSelenium/files/screenshoot.png") ;  
	    }
	
	
	
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

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
