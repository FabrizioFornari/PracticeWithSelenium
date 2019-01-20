package proslab.unicam.logandreports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import proslab.unicam.config.PropertiesFile;


public class FirstLogger {
	
static String projectPath = System.getProperty("user.dir"); 
	
	static String configFilename = projectPath+"/src/main/java/proslab/unicam/logandreports/log4j.properties";
	
	public static final Logger logger = Logger.getLogger(FirstLogger.class.getName());
	
	public static void main(String[] args) {

		testLogger();
	}
	

	public static void testLogger() {
		
		PropertyConfigurator.configure(configFilename);
//		PropertiesFile.readPropertiesFile();
		
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal message");
		
		System.out.println("Test");
		System.out.println("Test");
		
	}
	
	
}
