package proslab.unicam.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import proslab.unicam.selenium.FirstSeleniumTest;

public class PropertiesFile {
	
	static Properties prop = new Properties();

	static String projectPath = System.getProperty("user.dir"); 
	
//	public static void main(String[] args) {	
//		readPropertiesFile();
//		writePropertiesFile();
//		readPropertiesFile();
//	}

	public PropertiesFile() {
		writePropertiesFile();
	}
	
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		PropertiesFile.prop = prop;
	}
	
	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		PropertiesFile.projectPath = projectPath;
	}

	public void readPropertiesFile() {
			
		try {
		
			InputStream input = new FileInputStream(projectPath+"/src/main/java/proslab/unicam/config/config.properties");
			prop.load(input);
			prop.getProperty("browser");

			FirstSeleniumTest.browser = prop.getProperty("browser");
			PropertyConfigurator.configure(projectPath+"/src/main/java/proslab/unicam/config/config.properties");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writePropertiesFile() {
		
		try {
			
			OutputStream output = new FileOutputStream(projectPath+"/src/main/java/proslab/unicam/config/config.properties");
			prop.setProperty("browser", "Chrome");
			prop.setProperty("result", "pass");			
			
			prop.setProperty("log4j.rootLogger", "DEBUG, FILE, console");
			prop.setProperty("log4j.appender.FILE", "org.apache.log4j.FileAppender");
			prop.setProperty("log4j.appender.FILE.File", projectPath+"/src/main/java/proslab/unicam/logandreports/log.out");
			prop.setProperty("log4j.appender.FILE.ImmediateFlush", "true");
			prop.setProperty("log4j.appender.FILE.Threshold", "warning");
			prop.setProperty("log4j.appender.FILE.Append", "false");
			prop.setProperty("log4j.appender.FILE.layout", "org.apache.log4j.PatternLayout");
			prop.setProperty("log4j.appender.FILE.layout.ConversionPattern", "%d %d{Z} [%t] %-5p (%F:%L) - %m%n");
			prop.setProperty("log4j.appender.console", "org.apache.log4j.ConsoleAppender");
			prop.setProperty("logrj.appender.console.Target", "System.out");
			prop.setProperty("log4j.appender.console.layout", "org.apache.log4j.PatternLayout");
			prop.setProperty("log4j.appender.console.layout.ConversionPattern", "%-5p %c{1} - %m%n");
			
			prop.setProperty("projectPath",projectPath);
			
			prop.store(output, "updating browser and  log4j settings");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
