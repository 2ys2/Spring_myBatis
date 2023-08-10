package org.zerock.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	private static final long serialVersionUID = 1L;
	
	private UserDTO dto;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(UserDTO dto) {
		super(dto.getUsername(), dto.getPassword(), getAuthorities(dto) );
		this.dto = dto;
	}
	
	public static Collection<GrantedAuthority> getAuthorities(UserDTO dto) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        authorities.add(new SimpleGrantedAuthority(dto.getAuthority()));
        System.out.println("authorities : " + authorities);
        return authorities;
    }
	
	
}


/* Áï Spring Security => Authentication °´Ã¼ => UserDetails °´Ã¼ */