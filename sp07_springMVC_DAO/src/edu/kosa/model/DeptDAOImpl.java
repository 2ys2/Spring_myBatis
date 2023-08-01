package edu.kosa.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component("dao") //dao �̸����� bean ����
@Component //deptDAOImpl bean �����Ѵ�.
public class DeptDAOImpl implements DeptDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; //DML ��� ó�� Ŭ���� - insert, update, delete, select

	@Override
	public List listDept() { //selectAll
		String sql = "SELECT * FROM DEPT ORDER BY DEPTNO DESC ";
		
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public void insertDept(DeptDTO dto) { //insert
		String sql = "INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (?, ?, ?) ";
		Object[] arr = { dto.getDeptno(), dto.getDname(), dto.getLoc() };
		
		this.jdbcTemplate.update(sql, arr);
	}
}
