package com.kh.mybatis.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.dao.MybatisDao;
import com.kh.mybatis.model.vo.Student;

import static com.kh.mybatis.common.SqlSessionTemplate.*;

import java.util.List;
import java.util.Map;

public class MybatisService {
	
	private MybatisDao dao = new MybatisDao();

	
	public int insertBasic() {
		SqlSession session = getSession();
		int result = dao.insetBasic(session);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	
	//commit부를 단축하는 코드
	private int autoCommitCheck(int result, SqlSession session) {
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	
	public int insertByName(String name) {
		SqlSession session = getSession();
		int result = dao.insertByName(session, name);
		return autoCommitCheck(result, session); //한줄로 깔끔하게 커밋 롤백분이 실행된다 앞으로 이렇게 하자.
	}


	public int insertByAllParam(Student student) {
		SqlSession session = getSession();
		int result = dao.insertByAllParam(session, student);
		return autoCommitCheck(result, session); //한줄로 깔끔하게 커밋 롤백분이 실행된다 앞으로 이렇게 하자.
	}


	public int insertByAllParamMap(Map<String, String> map) {
		SqlSession session = getSession();
		int result = dao.insertByAllParamMap(session, map);
		return autoCommitCheck(result, session); //한줄로 깔끔하게 커밋 롤백분이 실행된다 앞으로 이렇게 하자.
	}


	public int updateAll(Student s) {
		SqlSession session = getSession();
		int result = dao.updateAll(session, s);
		return autoCommitCheck(result, session); //한줄로 깔끔하게 커밋 롤백분이 실행된다 앞으로 이렇게 하자.
	}
	
	public int delete(String name) {
		SqlSession session = getSession();
		int result = dao.delete(session, name);
		return autoCommitCheck(result, session); //한줄로 깔끔하게 커밋 롤백분이 실행된다 앞으로 이렇게 하자.
	}


	public int selectCount() {
//		이렇게 쓰는 방법도 있다
//		try (SqlSession session = getSession();){
//			int result = dao.selectCount(session);			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		SqlSession session = getSession();
		int result = dao.selectCount(session);	
		session.close();
		return result;
	}


	public Student selectOne(int no) {
		SqlSession session = getSession();
		Student result = dao.selectOne(session, no);	
		session.close();
		return result;
	}


	public Student selectOneV2(int no) {
		SqlSession session = getSession();
		Student result = dao.selectOneV2(session, no);	
		session.close();
		return result;
	}


	public Map<String, String> selectOneMap(int no) {
		SqlSession session = getSession();
		Map<String, String> result = dao.selectOneMap(session, no);	
		session.close();
		return result;
	}


	public List<Student> selectAll() {
		SqlSession session = getSession();
		List<Student> result = dao.selectAll(session);	
		session.close();
		return result;
	}


	public List<Student> selectAllResultMap() {
		SqlSession session = getSession();
		List<Student> result = dao.selectAllResultMap(session);	
		session.close();
		return result;
	}
	
	public List<Map<String, String>> selectAllResultListMap() {
		SqlSession session = getSession();
		List<Map<String, String>> result = dao.selectAllResultListMap(session);	
		session.close();
		return result;
	}


	public List<Student> searchEmail(String email) {
		SqlSession session = getSession();
		List<Student> result = dao.selectByEmailKeyword(session, email);	
		session.close();
		return result;
	}

}
