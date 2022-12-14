package com.kh.mybatis.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BoardRun {

	private static final Logger logger = LogManager.getLogger("HelloWorld");

	public static void main(String[] args) {
		logger.info("Hello, World!");
		BoardService service = new BoardService();
		Map<String, String> map = null;

		System.out.println("1. 게시글 조회");
		List<Board> list = service.getBoardList();
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("2. 게시글 조회 - writer : test1 찾기");
		map = new HashMap<String, String>();
		map.put("writer", "test1");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("3. 게시글 조회 - 제목 : 아이폰");
		map = new HashMap<String, String>();
		map.put("title", "아이폰");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("4. 게시글 조회 - 내용 : 갤럭시");
		map = new HashMap<String, String>();
		map.put("content", "갤럭시");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("5. 게시글 조회 - 제목 : 구매 / 내용 : 맥북");
		map = new HashMap<String, String>();
		map.put("title", "구매");
		map.put("content", "맥북");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("6. 게시글 조회 - Pageing 처리");
		int count = service.getBoardCount(null);
		PageInfo pageInfo = new PageInfo(2, 10, count, 10);
		list = service.getBoardList(null, pageInfo);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("7. 게시글 조회 - Pageing 처리 + 검색");
		map = new HashMap<String, String>();
		map.put("title", "게시글");
		count = service.getBoardCount(map);
		pageInfo = new PageInfo(1, 10, count, 10);
		list = service.getBoardList(map, pageInfo);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("8. 게시글 조회 - Pageing 처리 + TypeFilter 'B1, B2' ");
		List<String> filters = new ArrayList<String>();
		filters.add("B1");
		filters.add("B2");
		count = service.getBoardCountByTypeFilter(filters);
		pageInfo = new PageInfo(1, 10, count, 10);
		list = service.getBoardListByTypeFilter(filters, pageInfo);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("9. 게시글 상세 조회");
		Board board = service.findBoardByNo(1);
		System.out.println(board);
		for (Reply r : board.getReplies()) {
			System.out.println("리플 : " + r);
		}
	}
}
