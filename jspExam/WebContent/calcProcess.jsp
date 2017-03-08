<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	int number1 = Integer.parseInt(request.getParameter("num1"));
	int number2 = Integer.parseInt(request.getParameter("num2"));
	String operator = request.getParameter("operator");

	String result="0";
	switch(operator){
	case "+":
		result = number1 + number2 + "";
		break;
	case "-":
		result = number1 - number2 + "";
		break;
	case "*":
		result = number1 * number2 + "";
		break;
	case "/":
		result = number1 / number2 + "";
		break;
	}

	

	request.setAttribute("result", result);
	
	ServletContext context = getServletContext();
	RequestDispatcher dispatcher = context.getRequestDispatcher("/calcForm.jsp");
	dispatcher.forward(request, response);
	
	
	
	
	
	
%>
