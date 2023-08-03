package com.kosa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.kosa.config.SqlSessionFactoryService;
import com.kosa.model.BoardVO;

@Component
public class BoardDAO {

	private SqlSessionFactoryService sqlSessionFactoryservice;
	//	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리 함수를 갖고 있다.

	// select all
	public List<BoardVO> selectAll() {
		try {
			// sqlSession =
			// SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			sqlSession = sqlSessionFactoryservice.getSqlSessionFactory().openSession(true);
			return sqlSession.selectList("dao.selectAll");

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int insert(BoardVO vo) {
		try {
			sqlSession = sqlSessionFactoryservice.getSqlSessionFactory().openSession(true);
			return sqlSession.insert("dao.insert", vo);

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public BoardVO selectBySeq(int seq) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			return sqlSession.selectOne("dao.selectBySeq", seq);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int delete(int seq) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			return sqlSession.delete("dao.delete", seq);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	public int update(BoardVO vo) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			return sqlSession.update("dao.update", vo);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}

		}
	}
	/*전체 검색 조회 - 1*/
	public List<BoardVO> selectSearchList(Map<String, String> map) {
		try {
			/*
			 for(Map.Entry<String, String>) m : map.entrySet(){ System.out.println(m.); }
			 */
			
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			return sqlSession.selectList("dao.selectSearch", map);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/*전체 검색 조회 - 2*/
	public List<BoardVO> selectSearchList2(Map<String, String> map) {
		try {
			
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			return sqlSession.selectList("dao.selectSearch2", map);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}