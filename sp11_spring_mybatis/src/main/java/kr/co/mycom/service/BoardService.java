package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mycom.model.BoardDTO;

public interface BoardService {
	//쓰기, 리스트, 읽기, 수정, 삭제, 조회수 증가, 글의 개수
	public void insertBoard(BoardDTO dto); //insert
	public List<BoardDTO> getBoardList(HashMap map); //selectAll
	public BoardDTO getBoard(int num); //selectByNum
	public int updateHit(int num); //조회수 증가
	public int updateBoard(BoardDTO dto); //수정
	public int deleteBoard(BoardDTO dto); //삭제
	public void insertReply(BoardDTO dto); //답변
	public void updateSort(BoardDTO dto);
	
	public int getBoardCount(); //글의 전체 개수
	
	

}
