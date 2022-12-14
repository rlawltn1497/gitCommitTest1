package com.kh.mybatis.member.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;
import static com.kh.mybatis.common.SqlSessionTemplate.getSession;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int getMemberCount() {
		SqlSession session = getSession();
		int result = dao.getMemberCount(session);
		session.close();
		return result;
	}
	
	public List<Member> findAll(){
		SqlSession session = getSession();
		List<Member> result = dao.findAll(session);
		session.close();
		return result;
	}
	
	public Member findMemberById(String id) {
		SqlSession session = getSession();
		Member result = dao.findMemberById(session, id);
		session.close();
		return result;
	}
	
	public int insertMember(Member member) {
		SqlSession session = getSession();
		int result = dao.insertMember(session, member);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public int updateMember(Member member) {
		SqlSession session = getSession();
		int result = dao.updateMember(session, member);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public int deleteMember(int no) {
		SqlSession session = getSession();
		int result = dao.deleteMember(session, no);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
}
