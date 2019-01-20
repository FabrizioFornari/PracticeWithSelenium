package proslab.unicam.headlesschrome;

//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class HeadlessChrome
{
	
	static String projectPath = System.getProperty("user.dir"); 
	
	public static void main(String[] args) throws IOException {
		createChromeDriverHeadless();
	}
	
//  @Test
  public static void createChromeDriverHeadless() throws IOException
  {
      ChromeOptions chromeOptions = new ChromeOptions();
      System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
      chromeOptions.addArguments("--headless");

      WebDriver driver = new ChromeDriver(chromeOptions);
      driver.navigate().to("https://www.seleniumhq.org/");

      System.out.println("Title is: "+driver.getTitle());
      driver.quit();
  }
}