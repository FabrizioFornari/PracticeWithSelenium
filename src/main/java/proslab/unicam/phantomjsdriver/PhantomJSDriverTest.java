package proslab.unicam.phantomjsdriver;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSDriverTest {

	public static void main(String[] args) {
		
		System.setProperty("phantomjs.binary.path", "/Users/user/Desktop/Selenium/phantomjs-2.1.1-macosx/bin/phantomjs");

		PhantomJSDriver driver = new PhantomJSDriver();
		
		driver.get("http://seleniumhq.org/");
		
		System.out.println("Title of the web page is: "+driver.getTitle());
		
		driver.quit();
		
	}

}
