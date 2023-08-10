package org.kosa.model.dao;

import java.util.List;
import java.util.Map;

import org.kosa.model.dto.AuthVO;
import org.kosa.model.dto.UserVO;

public interface UserDAO {
	
	//회원 가입 처리
	public int insertUser(Map<String, Object> map);
	public int insertAuth(Map<String, Object> map);
	//로그인 처리
	public UserVO loginUser(String id);
	public List <AuthVO> loginAuth(String id);
	//회원 정보 수정
	public int updateUser(Map<String, Object> map);
	public int updateAuth(Map<String, Object> map);
	//회원 탈퇴 처리
	public int deleteUser(String id);
	public int deleteAuth(String userid);
	//회원 목록 조회
	public List<UserVO> selectAll();
	//회원 정보 상세
	public UserVO detailUser(String id);
	public AuthVO detailUserAuth(String userid);
	public List<AuthVO> detailAuth(String userid);
	//마이페이지
	public Map<String, Object> mypage(String id);

}
