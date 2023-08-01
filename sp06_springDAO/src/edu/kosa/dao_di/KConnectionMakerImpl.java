package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

public class KConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		
		Class.forName("infomics");
		//2.Connection & Open
					//driver:@IP:portNumber:SID(or 전역데이터베이스);
		String url = "infomics";
		String uid = "user01";
		String pwd = "info";
		Connection conn = 	DriverManager.getConnection(url,uid, pwd);
		return conn;
	}

}
