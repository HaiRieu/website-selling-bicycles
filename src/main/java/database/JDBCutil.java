package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutil {
	public static Connection getConnection() {
	Connection c = null ;
	
	try {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		String url = "jdbc:mySQL://localhost:3306/nhasach";
		String username = "root";
		String password = "";
		
		// Tạo kết nối
		
		c = DriverManager.getConnection(url, username, password);
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return c;
}

}
