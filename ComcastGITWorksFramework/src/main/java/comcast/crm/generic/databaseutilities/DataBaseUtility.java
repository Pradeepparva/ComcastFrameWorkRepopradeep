package comcast.crm.generic.databaseutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn;
	
	public void getDbConnection(String url, String username, String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		conn=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("Exception handled");
		}
	}
	
	public void closeDbConnection() {
		try {
		conn.close();
		}catch(Exception e) {
			
		}
	}
	
	public ResultSet execcuteConSelectQuery(String query) {
		ResultSet result=null;
		try {
		Statement stat=conn.createStatement();
		result = stat.executeQuery(query);
		}catch(Exception e) {
			System.out.println("Exception handled");
		}
		return result;
	}
	
	public int executeNonselectQuery(String query) {
		int result=0;
		try {
		Statement stat = conn.createStatement();
		result = stat.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Exception handled");
		}
		return result;
	}
		

}
