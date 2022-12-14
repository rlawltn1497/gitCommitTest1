package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.vo.Student;

@WebServlet("/selectAll.do")
public class SelectAllStudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = service.selectAll();
		System.out.println(list.toString());
		
		//JSP View로 전달하기
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/studentList.jsp").forward(req, resp);
		
		
		
	}

}
