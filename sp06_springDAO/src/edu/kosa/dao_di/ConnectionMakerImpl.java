package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

//Oracle DB Connection
public class ConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		//2.Connection & Open
					//driver:@IP:portNumber:SID(or 전역데이터베이스);
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String uid = "user01";
		String pwd = "oracle";
		Connection conn = DriverManager.getConnection(url,uid, pwd);
		
		return conn;
	}

}
