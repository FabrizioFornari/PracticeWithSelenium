package proslab.unicam.logandreports;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LoggerTest2 {

	
	static FirstLogger firstLogger;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		firstLogger = new FirstLogger();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	

	
	@Test
	@Disabled
	public void testLogger() {
		firstLogger.testLogger();
		fail("Failing on purpose");
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
