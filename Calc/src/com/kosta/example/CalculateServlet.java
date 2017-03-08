package com.kosta.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String oper = request.getParameter("operator");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		switch(oper){
		
		case "+":
			out.println("<h1>"+num1 +" + "+num2+" = "+(num1+num2)+"</h1>");
			break;
		case "-":
			out.println("<h1>"+num1 +" - "+num2+" = "+(num1-num2)+"</h1>");
			break;
		case "*":
			out.println("<h1>"+num1 +" * "+num2+" = "+(num1*num2)+"</h1>");
			break;
		case "/":
			out.println("<h1>"+num1 +" / "+num2+" = "+(num1/num2)+"</h1>");
			break;
		
		}
		
	
		out.println("</html>");
		
	}

}
