package kr.co.mycom.model;

import java.util.HashMap;
import java.util.List;

import kr.co.mycom.model.BoardDTO;

public interface BoardDAO {
	
	//����, ����Ʈ, �б�, ����, ����, ��ȸ�� ����, ���� ����
	public void insertBoard(BoardDTO dto); //insert
	public List<BoardDTO> getBoardList(HashMap map); //selectAll
	public BoardDTO getBoard(int num); //selectByNum

}
