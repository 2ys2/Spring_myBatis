package com.example.security.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class UserDAOImpl implements UserDAO {
	
	//3가지 방법이 있다. 모두 사용 가능 ~
//	@Autowired //import org.springframework.beans.factory.annotation.Autowired;
//	@Repository //import org.springframework.stereotype.Repository;
	@Inject
	SqlSession sqlSession;

	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("user.insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String userid) {
		return sqlSession.selectOne("user.selectUser", userid);
	}

}
