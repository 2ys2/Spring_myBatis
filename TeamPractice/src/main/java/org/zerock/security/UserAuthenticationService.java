package org.zerock.security;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.model.CustomUser;
import org.zerock.model.UserDTO;
//로그인 처리 클래스
public class UserAuthenticationService implements UserDetailsService {

	private SqlSessionTemplate sqlSession;

	public UserAuthenticationService() { 	}

	public UserAuthenticationService(
			SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		//사용자 아이디 확인
		System.out.println(username);
		UserDTO dto = new UserDTO();
		dto = sqlSession.selectOne("user.selectUser", username);
		System.out.println(dto);
		//아이디가 없으면 예외 발생
		if(dto==null) throw new UsernameNotFoundException(username);
		
		
		return new CustomUser(dto);
	}
}








