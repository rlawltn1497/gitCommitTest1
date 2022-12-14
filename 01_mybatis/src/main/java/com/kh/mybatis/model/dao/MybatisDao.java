package com.kh.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public class MybatisDao {

	// 파라메터가 없는 쿼리문
	public int insetBasic(SqlSession session) {
		//session 객체에서 'namespace.id'를 맵핑하면 자동으로 sql문을 호출함
		//mapper유형 : insert, update, delete, select
		return session.insert("studentMapper.insert");
	}

	// 파라메터가 1개일때
	public int insertByName(SqlSession session, String name) {
		return session.insert("studentMapper.insertByName", name);
	}

	// 파라메터가 다수인데, 객체로 정의되어 있을때
	public int insertByAllParam(SqlSession session, Student student) {
		return session.insert("studentMapper.insertByAllParam", student);
	}
	
	//파라메터가 다수인ㄴ데, 객체로 정의가 불가능할때
	public int insertByAllParamMap(SqlSession session, Map<String, String> map) {
		return session.insert("studentMapper.insertByAllParamMap", map);
	}

	public int updateAll(SqlSession session, Student s) {
		return session.update("studentMapper.updateByName", s);
	}
	
	public int delete(SqlSession session, String name) {
		return session.delete("studentMapper.deleteByName", name);
	}

	public int selectCount(SqlSession session) {
		return session.selectOne("studentMapper.selectCount");
	}

	public Student selectOne(SqlSession session, int no) {
		 return session.selectOne("studentMapper.selectByNo", no);
	}

	public Student selectOneV2(SqlSession session, int no) {
		return session.selectOne("studentMapper.selectByNoV2", no);
	}

	public Map<String, String> selectOneMap(SqlSession session, int no) {
		return session.selectOne("studentMapper.selectByNoMap", no);
	}

	public List<Student> selectAll(SqlSession session) {
		return session.selectList("studentMapper.selectAll");
	}

	public List<Student> selectAllResultMap(SqlSession session) {
		return session.selectList("studentMapper.selectAllWithResultMap");
	}
	
	public List<Map<String, String>> selectAllResultListMap(SqlSession session) {
		return session.selectList("studentMapper.selectAllWithListMap");
	}

	public List<Student> selectByEmailKeyword(SqlSession session, String email) {
		return session.selectList("studentMapper.selectByEmailKeyword", email);
	}

}
