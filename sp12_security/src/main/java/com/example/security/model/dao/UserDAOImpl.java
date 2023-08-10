package com.example.security.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository //모델 부분(데이터 접근) 하는 부분에 많이 씀 뜻은 저장소!
public class UserDAOImpl implements UserDAO {
	
	@Inject //메이븐 레포 추가해야 사용 가능
	SqlSession sqlSession;

	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("user.insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String userid) {
//	public int selectUser(Map<String, Object> map) {
		return sqlSession.selectOne("user.selectUser", userid);
//		return sqlSession.selectOne("user.selectUser", map);
	}

}
