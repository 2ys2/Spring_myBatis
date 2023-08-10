   package org.zerock.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //�� �κ�(������ ����) �ϴ� �κп� ���� �� ���� �����!
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertUser(Map<String, String> map) { //ȸ�� ����ó��
		return sqlSession.insert("user.insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String username) { //�α��� ó��
		return sqlSession.selectOne("user.selectUser", username);
	}

}
