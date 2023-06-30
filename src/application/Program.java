package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;


public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			int rown1 = st.executeUpdate("UPDATE seller SET BaseSalary = 0");
			//int rown2 = st.execute(null);
			System.out.println(rown1);
			conn.commit();
		}
		catch(SQLException e) {
			try {
				conn.rollback();
			}
			catch(SQLException el ) {
				throw new DbException(el.getMessage());
			}
			
			e.printStackTrace();;
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
