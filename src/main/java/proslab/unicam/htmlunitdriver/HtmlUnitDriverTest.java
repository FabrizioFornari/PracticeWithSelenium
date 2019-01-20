package proslab.unicam.htmlunitdriver;

import java.lang.reflect.Field;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;



//Headlsess Browser
public class HtmlUnitDriverTest {

	public static void main(String[] args) throws Exception {
			
		HtmlUnitDriver driver = new HtmlUnitDriver();
			
		driver.get("http://seleniumhq.org/");
			
		System.out.println("Title is: "+driver.getTitle());
		
		driver.quit();
		
		
		//Emulate other Browsers
		HtmlUnitDriver driverEmulator = new HtmlUnitDriver(BrowserVersion.EDGE);
		
		driverEmulator.get("http://seleniumhq.org/");
		
		System.out.println("Title is: "+driverEmulator.getTitle());
		
		WebClient webClient = (WebClient) get(driverEmulator, "webClient");

		System.out.println("Browser Version is: "+webClient.getBrowserVersion());
		System.out.println("Is Browser Edge? : "+webClient.getBrowserVersion().isEdge());
		System.out.println("Is Browser Chrome? : "+webClient.getBrowserVersion().isChrome());
		System.out.println("Is Browser Firefox? : "+webClient.getBrowserVersion().isFirefox());
		
		driverEmulator.quit();

			
	}
	
	private static Object get(Object object, String field) throws Exception {
		  Field f = object.getClass().getDeclaredField(field);
		  f.setAccessible(true);
		  return f.get(object);
		 }

	
}
