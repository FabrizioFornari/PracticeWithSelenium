package proslab.unicam.logandreports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FirstLogger {
	
//	public static void main(String[] args) {
//		testLogger();
//	}

	static String configFilename = "/Users/user/Documents/Applicazioni_Importanti/Eclipse IDE for Java EE Developers/New/WorkspaceEclipseJavaEE/proslabSelenium/src/main/java/proslab/unicam/logandreports/log4j.properties";
	
	public static final Logger logger = Logger.getLogger(FirstLogger.class.getName());
	
	public static void getlogger() {
		PropertyConfigurator.configure(configFilename);
	}
	
	public void testLogger() {
		getlogger();
		
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal message");
		
		System.out.println("Test");
		
	}
	
	
}
