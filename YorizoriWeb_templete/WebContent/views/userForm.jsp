<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='ctx' value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/yorizori.css">
<title>Insert title here</title>
</head>
<body>

<h1>사용자 목록</h1>
<form action="${ctx }/user/register.do" method="post">
	<table border="1">
	
		<tr>
		<td>닉네입</td>
		<td><input type="text" name="name" value=""></td>
		</tr>
		<tr>
		<td>아이디</td>
		<td><input type="text" name="userId" value=""></td>
		</tr>
		<tr>
		<td>비밀번호</td>
		<td><input type="password" name="password" value=""></td>
		</tr>
	</table>
	<br>
	<button type="button" onclick="'location.href=${ctx}/';" class= "btn" >메인으로</button>
	<button type="submit" class= "btn" >등록</button>


</form>
</body>
</html>