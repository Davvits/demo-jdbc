package db;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DB {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if(conn != null)return conn;
		
		try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url,props);
		} 
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return conn;
		
	}
	
	public static void closeConnection() {
		if(conn == null) {
			 throw new DbException("there is no connection to be close");
			 
		} 
		
		else {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st == null) return;
		
		try {
			st.close();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs == null) return;
		
		try {
			rs.close();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		
	}
}
