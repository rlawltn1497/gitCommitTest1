package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.vo.Student;

@WebServlet("/selectOne2.do")
public class SelectOneServlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noStr = req.getParameter("no");
		int no = Integer.parseInt(noStr);
		
		Student s = service.selectOneV2(no);
		System.out.println(s);
		
		//JSP View로 전달하기
		req.setAttribute("s", s);
		req.getRequestDispatcher("/views/studentView.jsp").forward(req, resp);
		
		
		
	}

}
