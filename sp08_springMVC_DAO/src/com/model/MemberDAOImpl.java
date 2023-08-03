package com.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component("dao") //bean설정 - dao 변경 가능
@Component //bean설정 - memberDAOImpl
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; //DML 명령 처리 클래스

	@Override
	public MemberVO selectMemberById(String id) throws SQLException { //특정 id 검색
		String sql = "SELECT * FROM USERMEMBER WHERE ID = ? ";
		
		try {
			return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class), id);
//			return this.jdbcTemplate.queryForObject(sql, new Object[] {id}, MemberVO.class);
			
		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return new EmptyResultDataAccessException(); //예외 발생시 null 리턴
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List memberById(String id) throws SQLException { //selectById
		String sql = "SELECT * FROM USERMEMBER WHERE ID = ? ";
		
		return this.jdbcTemplate.queryForList(sql, id);
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException { //id check
		String sql = "SELECT * FROM USERMEMBER WHERE ID = ? AND PWD = ? ";
		boolean flag = false;
		Object[] params = { id, pwd };
		
		if (this.jdbcTemplate.queryForList(sql, params).size() > 0 ) flag = true;
		
		return flag;
	}
	

	@Override
	public boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException { //insert
		String sql = "INSERT INTO USERMEMBER VALUES(?, ?, ?, ?, ?) ";
		boolean flag = false;
		
		Object[] params = { id, name, pwd, email, age };
		if ( this.jdbcTemplate.update(sql, params) > 0 ) flag = true;
		
		return flag;
	}

}
