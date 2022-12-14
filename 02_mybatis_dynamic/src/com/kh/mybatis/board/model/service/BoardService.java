package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.PageInfo;

public class BoardService {
	private BoardDao dao = new BoardDao();

	public List<Board> getBoardList() {
		return this.getBoardList(null);
	}
	
	public List<Board> getBoardList(Map<String, String> map) {
		SqlSession session = getSession();
		List<Board> list = dao.getBoardList(session, map);
		session.close();
		return list;
	}

	public List<Board> getBoardList(Map<String, String> map, PageInfo pageinfo) {
		SqlSession session = getSession();
		List<Board> list = dao.getBoardList(session, map, pageinfo);
		session.close();
		return list;
	}
	
	
	public int getBoardCount(Map<String, String> map) {
		SqlSession session = getSession();
		int result = dao.getBoardCount(session, map);
		session.close();
		return result;
	}

	public List<Board> getBoardListByTypeFilter(List<String> filterList) {
		SqlSession session = getSession();
		List<Board> result = dao.getBoardListByTypeFilter(session, filterList);
		session.close();
		return result;
	}

	public int getBoardCountByTypeFilter(List<String> filterList) {
		SqlSession session = getSession();
		int result = dao.getBoardCountByTypeFilter(session, filterList);
		session.close();
		return result;
	}

	public List<Board> getBoardListByTypeFilter(List<String> filterList, PageInfo pageinfo) {
		SqlSession session = getSession();
		List<Board> result = dao.getBoardListByTypeFilter(session, filterList, pageinfo);
		session.close();
		return result;
	}

	public Board findBoardByNo(int boardNo) {
		SqlSession session = getSession();
		Board result = dao.findBoardByNo(session, boardNo);
		session.close();
		return result;
	}
}
