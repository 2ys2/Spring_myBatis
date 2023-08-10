package dao;

import java.sql.SQLException;
import java.util.List;

import vo.Notice;

//CRUD
public interface NoticeDao {
	//�Խù� ����
	int getCount(String field, String query) throws ClassNotFoundException, SQLException;
	
	//��ü �Խù�
	List<Notice> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	//�Խù� ����
	int delete(String seq) throws ClassNotFoundException, SQLException;
	
	//�Խù� ����
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	
	//�Խù� ��
	Notice getNotice(String seq) throws ClassNotFoundException, SQLException;
	
	//�Խù� �Է�
	int insert(Notice n) throws ClassNotFoundException, SQLException;
}
