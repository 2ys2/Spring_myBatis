package org.zerock.security;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.model.CustomUser;
import org.zerock.model.UserDTO;
//�α��� ó�� Ŭ����
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
		//����� ���̵� Ȯ��
		System.out.println(username);
		UserDTO dto = new UserDTO();
		dto = sqlSession.selectOne("user.selectUser", username);
		System.out.println(dto);
		//���̵� ������ ���� �߻�
		if(dto==null) throw new UsernameNotFoundException(username);
		
		
		return new CustomUser(dto);
	}
}








