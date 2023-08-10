package org.zerock.security;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml", })
public class MemberTests {
	
	@Setter(onMethod_ =@Autowired)
	private PasswordEncoder pwencoder;
	
	@Setter(onMethod_ =@Autowired)
	private DataSource ds;
	
	@Test
	public void testInsertMember() {
		
		String sql = "insert into ";
		
		
	};

}
