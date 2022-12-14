package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.vo.Student;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name").strip();
		String tel = req.getParameter("tel").strip();
		String address = req.getParameter("address").strip();
		String email = req.getParameter("email").strip();
		
		//Lombok Builder를 활용하는법
		Student s = Student.builder().name(name).tel(tel).address(address).email(email).build();
		
		int result = service.updateAll(s);
		
		if(result > 0) {
			resp.getWriter().append("업데이트 성공!");
		}else {
			resp.getWriter().append("업데이트 실패!");			
		}
	}

}
