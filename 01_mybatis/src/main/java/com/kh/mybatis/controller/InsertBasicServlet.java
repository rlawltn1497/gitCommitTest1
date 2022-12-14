package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;

@WebServlet("/insert.do")
public class InsertBasicServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MybatisService service = new MybatisService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = service.insertBasic();
		
		if(result > 0) {
			resp.getWriter().append("등록성공!");
		}else {
			resp.getWriter().append("등록실패!");			
		}
	}
}
