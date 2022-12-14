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

		System.out.println("1. �Խñ� ��ȸ");
		List<Board> list = service.getBoardList();
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("2. �Խñ� ��ȸ - writer : test1 ã��");
		map = new HashMap<String, String>();
		map.put("writer", "test1");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("3. �Խñ� ��ȸ - ���� : ������");
		map = new HashMap<String, String>();
		map.put("title", "������");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("4. �Խñ� ��ȸ - ���� : ������");
		map = new HashMap<String, String>();
		map.put("content", "������");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("5. �Խñ� ��ȸ - ���� : ���� / ���� : �ƺ�");
		map = new HashMap<String, String>();
		map.put("title", "����");
		map.put("content", "�ƺ�");
		list = service.getBoardList(map);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("6. �Խñ� ��ȸ - Pageing ó��");
		int count = service.getBoardCount(null);
		PageInfo pageInfo = new PageInfo(2, 10, count, 10);
		list = service.getBoardList(null, pageInfo);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("7. �Խñ� ��ȸ - Pageing ó�� + �˻�");
		map = new HashMap<String, String>();
		map.put("title", "�Խñ�");
		count = service.getBoardCount(map);
		pageInfo = new PageInfo(1, 10, count, 10);
		list = service.getBoardList(map, pageInfo);
		for (Board b : list) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------\n");

		System.out.println("8. �Խñ� ��ȸ - Pageing ó�� + TypeFilter 'B1, B2' ");
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

		System.out.println("9. �Խñ� �� ��ȸ");
		Board board = service.findBoardByNo(1);
		System.out.println(board);
		for (Reply r : board.getReplies()) {
			System.out.println("���� : " + r);
		}
	}
}
