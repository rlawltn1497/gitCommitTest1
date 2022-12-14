package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;

@WebServlet("/selectAllListMap.do")
public class SelectAllStudentServletMap extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Map<String, String>> list = service.selectAllResultListMap();
		System.out.println(list.toString());
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/studentListForMap.jsp").forward(req, resp);
		
		
		
	}

}
