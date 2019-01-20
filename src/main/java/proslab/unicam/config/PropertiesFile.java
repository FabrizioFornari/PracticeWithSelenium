package proslab.unicam.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import proslab.unicam.selenium.FirstSeleniumTest;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	
	static String projectPath = System.getProperty("user.dir"); 
	
	public static void main(String[] args) {
		
		readPropertiesFile();
		writePropertiesFile();
		readPropertiesFile();
	}

	public static void readPropertiesFile() {
		
		
		try {
		
			InputStream input = new FileInputStream(projectPath+"/src/main/java/proslab/unicam/config/config.properties");
			prop.load(input);
			prop.getProperty("browser");
			System.out.println(prop.getProperty("browser"));
			
			FirstSeleniumTest.browser = prop.getProperty("browser");
			System.out.println(FirstSeleniumTest.browser);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void writePropertiesFile() {
		
		try {
			
			OutputStream output = new FileOutputStream(projectPath+"src/main/java/proslab/unicam/config/config.properties");
			prop.setProperty("browser", "Chrome");
			prop.setProperty("result", "pass");
			prop.store(output, "updating browser");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
