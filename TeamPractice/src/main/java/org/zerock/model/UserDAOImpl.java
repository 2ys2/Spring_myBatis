   package org.zerock.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //모델 부분(데이터 접근) 하는 부분에 많이 씀 뜻은 저장소!
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertUser(Map<String, String> map) { //회원 가입처리
		return sqlSession.insert("user.insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String username) { //로그인 처리
		return sqlSession.selectOne("user.selectUser", username);
	}

}
