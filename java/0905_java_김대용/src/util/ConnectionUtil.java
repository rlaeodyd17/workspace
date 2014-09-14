package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	
	public static Connection getConnection() throws Exception {
		
		//커넥션 객체 초기화
		
		Connection con = null;
		
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "1111";
		
	    con = DriverManager.getConnection(url, user, password);
	    
		return con;
		
	}

}//ConnectionUtil end
