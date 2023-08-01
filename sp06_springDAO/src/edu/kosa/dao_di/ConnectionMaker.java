package edu.kosa.dao_di;

import java.sql.Connection;

public interface ConnectionMaker { //interface 확장 가능, 관계 느슨하게 처리
	
	Connection makeConnection() throws Exception;

}
