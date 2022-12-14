package com.kh.mybatis.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	//singleTone
	private static SqlSessionFactory sf = null;
	
	public static SqlSession getSession() {
		//SqlSession은 Mybatis에서 JDBC Connection과 동일한 기능을 가지는 객체
		SqlSession session = null;
		
		try {
			if(sf == null) {
				String resource = "/mybatis-config.xml";
				InputStream is = Resources.getResourceAsStream(resource);//xml파일 로드하는 코드
				SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
				sf = sfb.build(is);
			}
			//openSession(false) : Auto Commit을 끄는 방법
			session = sf.openSession(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
		
	}
}
