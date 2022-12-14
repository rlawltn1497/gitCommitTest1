package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.vo.Student;


@WebServlet("/insertParamAll.do")
public class InsertParamAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MybatisService service = new MybatisService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		<form action="${path}/insertParamAll.do" method="post">
//		<input type="text" name="name" placeholder="이름"/>
//		<input type="text" name="tel" placeholder="전화번호"/>
//		<input type="text" name="address" placeholder="주소"/>
//		<input type="text" name="email" placeholder="이메일"/>
//		<input type="submit" value="저장">
//		</form>
		
		Student student = new Student();
		try {
			student.setName(req.getParameter("name").strip());
			student.setTel(req.getParameter("tel").strip());
			student.setAddress(req.getParameter("address").strip());
			student.setEmail(req.getParameter("email").strip());
		} catch (Exception e) {}
		
		int result = service.insertByAllParam(student);
		
		if(result > 0) {
			resp.getWriter().append("학생 객체로 등록성공!");
		}else {
			resp.getWriter().append("학생 객체로 등록실패!");			
		}
		
	}
	

}
