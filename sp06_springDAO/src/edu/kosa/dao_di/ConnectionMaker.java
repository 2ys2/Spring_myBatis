package edu.kosa.dao_di;

import java.sql.Connection;

public interface ConnectionMaker { //interface Ȯ�� ����, ���� �����ϰ� ó��
	
	Connection makeConnection() throws Exception;

}
