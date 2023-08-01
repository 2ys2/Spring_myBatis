package edu.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kosa.model.UserVO;

public abstract class UserDAO { // �߻�Ŭ����
	// DB ���� ���� �޼ҵ�
	public abstract Connection getConnection() throws Exception; // �߻�޼ҵ�

	// 1.Drive Load 2.���� �� Open 3.���(DML��ɾ�) 4.Close
	// 3. ���(DML��ɾ�)

	// insert
	public void insert(UserVO vo) throws Exception{
		Connection conn = getConnection();
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD ) VALUES(?, ?, ?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		int result = pstmt.executeUpdate();
		System.out.println(result + "�� �Է� ����!!");
		
		pstmt.close();
		conn.close();
	};


	//selectAll
	public List<UserVO> selectAll() throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT * FROM USERS ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<UserVO> list = new ArrayList<>();
		
		while (rs.next()) {
			UserVO vo = new UserVO();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
			vo.setPassword(rs.getString("password"));
			
			list.add(vo);
		}
		return list;
	};

	//selectById
	public UserVO selectById(String id) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT * FROM USERS WHERE ID = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		UserVO vo = new UserVO();
		rs.next();
		vo.setId(rs.getString("id"));
		vo.setName(rs.getString("name"));
		vo.setPassword(rs.getString("password"));

		return vo;
	};
	
	//Update
	//Delete
	//Menu
	public void menu() {
		System.out.println("�����ϼ��� : \n1.Insert ");
		System.out.println("2.SelectAll \n3.SelectById \n4.Update \n5.Delete ");
	}
}
