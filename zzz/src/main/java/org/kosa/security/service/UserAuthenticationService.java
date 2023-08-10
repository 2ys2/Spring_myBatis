package org.kosa.security.service;

import org.kosa.model.dto.CustomUser;
import org.kosa.model.dto.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//�α��� ó�� Ŭ����
public class UserAuthenticationService implements UserDetailsService {
	
	private SqlSessionTemplate sqlSession;
	
	public UserAuthenticationService() {	}
	
	public UserAuthenticationService( SqlSessionTemplate sqlSession ) {
		this.sqlSession = sqlSession;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String id = username;
		String userid = username;
		System.out.println("id : " + id + ", userid : " + userid);
		UserVO vo = new UserVO();
		vo = sqlSession.selectOne("user.selectUser", id);
		System.out.println("selectUser vo : " + vo);
		vo.setAuthList(sqlSession.selectList("user.selectAuthId", userid));
		//���̵� ������ ���� �߻�
		if(vo==null) throw new UsernameNotFoundException(id);
		
		return new CustomUser(vo);
	}

}
