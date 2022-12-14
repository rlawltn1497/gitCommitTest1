package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.vo.Student;


@WebServlet("/insertParamAllMap.do")
public class InsertParamAllServletMap extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라메터를 Map으로 처리하는 방법
		
		Map<String, String> map = new HashMap<>();
		
		try {
			String name = req.getParameter("name").strip();
			String tel = req.getParameter("tel").strip();
			String address = req.getParameter("address").strip();
			String email = req.getParameter("email").strip();
			map.put("name", name);
			map.put("tel", tel);
			map.put("address", address);
			map.put("email", email);
			System.out.println(map.toString());
		} catch (Exception e) {}
		
		int result = service.insertByAllParamMap(map);
		
		if(result > 0) {
			resp.getWriter().append("Map으로 등록성공!");
		}else {
			resp.getWriter().append("Map으로 등록실패!");			
		}
		
	}
	

}
