package com.example.security.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository //�� �κ�(������ ����) �ϴ� �κп� ���� �� ���� �����!
public class UserDAOImpl implements UserDAO {
	
	@Inject //���̺� ���� �߰��ؾ� ��� ����
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
