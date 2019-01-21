package proslab.unicam.logandreports;

import org.apache.log4j.Logger;

import proslab.unicam.config.PropertiesFile;


public class FirstLogger {
	
	public static final Logger logger = Logger.getLogger(FirstLogger.class.getName());
	
	static PropertiesFile prop = new PropertiesFile();
	
	public static void main(String[] args) {

		testLogger();
	}
	

	public static void testLogger() {
	
		prop.readPropertiesFile();
		
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal message");
		
		System.out.println("Test");
		System.out.println("Test");
		
	}
	
	
}
