package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;

@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		int result = service.delete(name);
		
		if(result > 0) {
			resp.getWriter().append("이름으로 삭제성공!");
		}else {
			resp.getWriter().append("이름으로 삭제실패!");			
		}
	}

}
