package com.example.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.security.model.dto.UserDTO;
//�α��� ó�� Ŭ����
public class UserAuthenticationService implements UserDetailsService {

	private SqlSessionTemplate sqlSession;
	
	public UserAuthenticationService() { 	}
	
	public UserAuthenticationService(
			SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userid) 
			throws UsernameNotFoundException {
		//����� ���̵� Ȯ��
		System.out.println(userid);
		Map<String,Object> user=sqlSession.selectOne("user.selectUser", userid);
		System.out.println(user);
		//���̵� ������ ���� �߻�
		if(user==null) throw new UsernameNotFoundException(userid);
		
		//������ ���
		List<GrantedAuthority> authority= new ArrayList<>();
		authority.add(new SimpleGrantedAuthority(user.get("AUTHORITY").toString())); //�ʵ���� �빮�ڷ�
		return new UserDTO(user.get("USERNAME").toString(),
								user.get("PASSWORD").toString(),
								(Integer)Integer.valueOf(user.get("ENABLED").toString())==1,
								true,true,true,authority,
								user.get("USERNAME").toString() );
	}

}
/*
�̷��� �ᵵ �Ǵµ� dto�� ���Ŀ� ���� ���� �����ϱ� �ٷ� return�� �־ ����ߴ�
UserDTO dto =  new UserDTO(user.get("USERNAME").toString(),
		user.get("PASSWORD").toString(),
		(Integer)Integer.valueOf(user.get("ENABLED").toString())==1,
		true,true,true,authority,
		user.get("USERNAME").toString() );
return dto;
*/











