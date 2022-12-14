package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;

@WebServlet("/insertName.do")
public class InsertNameServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("InsertNameServlet name : " + name);
		
		int result = service.insertByName(name);
		
		if(result > 0) {
			resp.getWriter().append("이름으로 등록성공!");
		}else {
			resp.getWriter().append("이름으로 등록실패!");			
		}
	}

}
