package com.kh.mybatis.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.PageInfo;

public class BoardDao {

	public List<Board> getBoardList(SqlSession session, Map<String, String> map){
		return session.selectList("boardMapper.selectBoardList", map);
	}
	
	public int getBoardCount(SqlSession session, Map<String, String> map){
		return session.selectOne("boardMapper.selectBoardCount", map);
	}
	
	public List<Board> getBoardList(SqlSession session, Map<String, String> map, PageInfo pageinfo){
		// 페이지 정보 처리 코드부
		// offset : 몇개의 게시글을 건너 뛸지에 대한 offset(건너 뛰는 값)
		// limit : 페이지의 갯수
		// offset = 0,  limit = 10 : 0개는  건너뛰고 10개 가져오기 // 1  ~ 10
		// offset = 10, limit = 10 : 10개는 건너뛰고 10개 가져오기 // 11 ~ 20
		// offset = 20, limit = 10 : 20개는 건너뛰고 10개 가져오기 // 21 ~ 30
	
		// ※주의 : rowBounds기법의 단점은 페이지 글이 많을시 성능저하가 매우 크다! 
		int offset = (pageinfo.getCurrentPage() - 1) * pageinfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageinfo.getListLimit());
		return session.selectList("boardMapper.selectBoardList", map, rowBounds);
	}
	
	public List<Board> getBoardListByTypeFilter(SqlSession session,	List<String> filterList){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filterList", filterList);
		return session.selectList("boardMapper.selectBoardListByTypeFilters", map);
	}
	
	public int getBoardCountByTypeFilter(SqlSession session, List<String> filterList){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filterList", filterList);
		return session.selectOne("boardMapper.selectBoardCountByTypeFilters", map);
	}
	
	public List<Board> getBoardListByTypeFilter(SqlSession session,	List<String> filterList, PageInfo pageinfo){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filterList", filterList);
		
		int offset = (pageinfo.getCurrentPage() - 1) * pageinfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, pageinfo.getListLimit());
		return session.selectList("boardMapper.selectBoardListByTypeFilters", map, rowBounds);
	}
	
	public Board findBoardByNo(SqlSession session, int boardNo) {
		return session.selectOne("boardMapper.selectBoardByNo", boardNo);
	}
}
