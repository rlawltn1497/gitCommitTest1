package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;

@WebServlet("/selectOne3.do")
public class SelectOneServletMap extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noStr = req.getParameter("no");
		int no = Integer.parseInt(noStr);
		
		Map<String,String> map = service.selectOneMap(no);
		System.out.println(map.toString());
		
		//JSP View로 전달하기
		req.setAttribute("map", map);
		req.getRequestDispatcher("/views/studentViewForMap.jsp").forward(req, resp);
		
		
		
	}

}
