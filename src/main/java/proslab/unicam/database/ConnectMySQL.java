package proslab.unicam.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class ConnectMySQL {

	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/selenium?serverTimezone=Europe/Rome";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "pwd";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	private Connection con = null;
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER_CLASS);
        System.out.println("Connecting to database...");
        con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        
		System.out.println("Connected to MySQL DB");

		Statement smt=con.createStatement();
				        
		ResultSet rs=smt.executeQuery("select * from seleniumuser;");

		while(rs.next()) {
			
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String email = rs.getString("Email");
			
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(email);

			
		} 
		
		
	}
	
}
