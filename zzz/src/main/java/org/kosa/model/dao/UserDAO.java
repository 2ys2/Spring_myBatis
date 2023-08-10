package org.kosa.model.dao;

import java.util.List;
import java.util.Map;

import org.kosa.model.dto.AuthVO;
import org.kosa.model.dto.UserVO;

public interface UserDAO {
	
	//ȸ�� ���� ó��
	public int insertUser(Map<String, Object> map);
	public int insertAuth(Map<String, Object> map);
	//�α��� ó��
	public UserVO loginUser(String id);
	public List <AuthVO> loginAuth(String id);
	//ȸ�� ���� ����
	public int updateUser(Map<String, Object> map);
	public int updateAuth(Map<String, Object> map);
	//ȸ�� Ż�� ó��
	public int deleteUser(String id);
	public int deleteAuth(String userid);
	//ȸ�� ��� ��ȸ
	public List<UserVO> selectAll();
	//ȸ�� ���� ��
	public UserVO detailUser(String id);
	public AuthVO detailUserAuth(String userid);
	public List<AuthVO> detailAuth(String userid);
	//����������
	public Map<String, Object> mypage(String id);

}
