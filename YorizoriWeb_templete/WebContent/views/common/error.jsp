<%@page import="yorizori.common.exception.YzRuntimeException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요리조리 쿡북 </title>
</head>
<body>
	<header>에러메시지</header>
	<br>
	
	<h1><%=exception.getMessage() %></h1>
	
	<%
		String redirectURL = null;
		if(exception instanceof YzRuntimeException){
			
			YzRuntimeException ex = (YzRuntimeException)exception;
			
			redirectURL = ex.getRedirectURL();
			
			
		}
		
		if(redirectURL != null && redirectURL.length() > 0){
	%>
		<button onclick="javascript:Iocation.href='<%=redirectURL %>'">확인</button>
	
	<%
		}else{
			%>
			<button onclick="javascript:history.back();">확인</button>
		
		<%
		}
	
	
	%>
	
	
</body>
</html>