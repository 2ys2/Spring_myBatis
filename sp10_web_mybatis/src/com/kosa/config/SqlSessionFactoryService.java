package com.kosa.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryService {
	
	private static SqlSessionFactory sqlSessionFactory = null; 

	static {
		try {
			if (sqlSessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //mybatis 설정 file path
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory; //자동커밋 false -> 자동커밋 끔
	}

}

