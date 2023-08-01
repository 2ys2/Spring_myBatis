package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Drive");
		//2.Connection & Open
					//driver:@IP:portNumber:SID(or ���������ͺ��̽�);
		String url = "jdbc:mysql://localhost:3306:DB��";
		String uid = "user01";
		String pwd = "mysql";
		Connection conn = DriverManager.getConnection(url,uid, pwd);
		return conn;
	}

}
