package com.kosta.example.person.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.example.person.domain.Person;
import com.kosta.example.person.service.PersonServiceLogic;

public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		
		PersonServiceLogic service = new PersonServiceLogic();
		Person p = service.getPerson(name);
		resp.setContentType("text/html;charset=utf-8");//보내는 값의 설정
		PrintWriter out = resp.getWriter();
		
		
		if(p !=null){
			out.println("이름 : "+p.getName());
			out.println("나이 : "+p.getAge());
			out.println("주소 : "+p.getAddress());
		}else{
			out.println("사용자가 없습니다.");
		}
	}
}
