package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Drive");
		//2.Connection & Open
					//driver:@IP:portNumber:SID(or 전역데이터베이스);
		String url = "jdbc:mysql://localhost:3306:DB명";
		String uid = "user01";
		String pwd = "mysql";
		Connection conn = DriverManager.getConnection(url,uid, pwd);
		return conn;
	}

}
