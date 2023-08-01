package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.kosa.model.UserVO;

public class UserDAO {

	@Autowired
	private ConnectionMaker connectionMaker; //has-a

	public UserDAO() {	};

	/*
	public UserDAO(ConnectionMaker connectionMaker) { //DI - constructor
		this.connectionMaker = connectionMaker;
	}
	public void setConnectionMaker(ConnectionMaker connectionMaker) { //DI = setter method
		this.connectionMaker = connectionMaker;
	}
	 */

	//3.DML 명령어
	//insert
	public void insert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connectionMaker.makeConnection(); // DB connect

			String sql = "INSERT INTO USERS(ID, NAME, PASSWORD ) VALUES(?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			int result = pstmt.executeUpdate();
			System.out.println(result + "개 입력 성공!! connectionMaker ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {	pstmt.close();	conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		} // end try
	} // end insert

	//selectAll
	public List<UserVO> selectAll() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> list = new ArrayList<>();
		
		try {
			conn = connectionMaker.makeConnection();
			String sql = "SELECT * FROM USERS ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {	pstmt.close();	conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
		return list;
	};
	
	//selectById
	public UserVO selectById(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO vo = new UserVO();

		try {
			conn = connectionMaker.makeConnection();
			String sql = "SELECT * FROM USERS WHERE ID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
			vo.setPassword(rs.getString("password"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {	try {	pstmt.close();	conn.close();	} catch (SQLException e) {	e.printStackTrace();	}		
		}
		return vo;
	}
	
	//updateById
	public void updateById(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connectionMaker.makeConnection();
			String sql = "UPDATE USERS SET NAME = ?, PASSWORD = ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "개를 수정했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {	pstmt.close();	conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
	}
	
	
	//deleteById - 실습과제
	public void deleteById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connectionMaker.makeConnection();
			String sql = "DELETE FROM USERS WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "개를 삭제했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {	pstmt.close();	conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
	}
	
	//Menu
	public void menu() {
		System.out.println("선택하세요 : \n1.Insert ");
		System.out.println("2.SelectAll \n3.SelectById \n4.UpdateById \n5.DeleteById ");
	}

}
