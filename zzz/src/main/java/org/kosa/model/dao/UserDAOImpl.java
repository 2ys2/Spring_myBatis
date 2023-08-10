package org.kosa.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kosa.model.dto.AuthVO;
import org.kosa.model.dto.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //�� �κ�(������ ����) �ϴ� �κп� ���� �� ���� �����!
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertUser(Map<String, Object> map) { //ȸ������ó��
		return sqlSession.insert("user.insertUser", map);
	}
	
	@Override
	public int insertAuth(Map<String, Object> map) { //ȸ������ó��
		return sqlSession.insert("user.insertAuth", map);
	}


	@Override
	public UserVO loginUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AuthVO> loginAuth(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(Map<String, Object> map) {
		return sqlSession.update("user.updateUser", map);
	}
	
	@Override
	public int updateAuth(Map<String, Object> map) {
		return sqlSession.update("user.updateAuth", map);
	}


	@Override
	public int deleteUser(String username) {
		return sqlSession.delete("user.deleteUser",username);
	}
	
	@Override
	public int deleteAuth(String userid) {
		return sqlSession.delete("user.deleteAuth", userid);
	}
	

	@Override
	public List<UserVO> selectAll() {
		return sqlSession.selectList("user.selectAll");
	}


	@Override
	public UserVO detailUser(String id) {
		return sqlSession.selectOne("user.selectUser", id);
	}

	@Override
	public List<AuthVO> detailAuth(String userid) {
		return sqlSession.selectList("user.selectAuthId",userid);
	}

	@Override
	public Map<String, Object> mypage(String id) {
		return sqlSession.selectMap("user.mypage", id);
	}

	@Override
	public AuthVO detailUserAuth(String userid) {
		return sqlSession.selectOne("user.selectAuthId", userid);
	}







}
