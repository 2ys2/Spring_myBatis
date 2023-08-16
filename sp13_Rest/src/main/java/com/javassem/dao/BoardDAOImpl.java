package com.javassem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.BoardVO;

@Repository("boardDAO") 
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard() ȣ��");	
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard() ȣ��");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() ȣ��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard() ȣ��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList() {
		System.out.println("===> Mybatis getBoardList() ȣ��");
		return mybatis.selectList("BoardDAO.getBoardList");
	}
//	public List<BoardVO> getBoardList(BoardVO vo) {
//		System.out.println("===> Mybatis getBoardList() ȣ��");
//		return mybatis.selectList("BoardDAO.getBoardList", vo);
//	}
}