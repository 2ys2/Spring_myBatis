package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mycom.model.BoardDTO;

public interface BoardService {
	//����, ����Ʈ, �б�, ����, ����, ��ȸ�� ����, ���� ����
	public void insertBoard(BoardDTO dto); //insert
	public List<BoardDTO> getBoardList(HashMap map); //selectAll
	public BoardDTO getBoard(int num); //selectByNum
	public int updateHit(int num); //��ȸ�� ����
	public int updateBoard(BoardDTO dto); //����
	public int deleteBoard(BoardDTO dto); //����
	public void insertReply(BoardDTO dto); //�亯
	public void updateSort(BoardDTO dto);
	
	public int getBoardCount(); //���� ��ü ����
	
	

}
