package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBaseConnection {
	Connection connection;
	Statement statement;

	public DataBaseConnection() {
		try {
			connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagement", "root","Saurabh@123");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection!=null) {
				
			}
		}
	}
	
}
/* @Saurabh_Wankhade. */
