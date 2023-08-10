package org.zerock.model;

import java.util.Map;

public interface UserDAO {
	
	//회원 가입처리
	public int insertUser(Map<String, String> map);
	//로그인 처리
	public Map <String, Object> selectUser(String username);

}
