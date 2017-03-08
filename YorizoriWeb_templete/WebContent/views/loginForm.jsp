<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='ctx' value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/yorizori.css">
<title>요리조리 쿡북</title>
</head>
<body>
	<h1>로그인</h1>

	<form action="${ctx }/user/login.do" method="post">
		<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" value="${userId }">
				<label><input type="checkbox" value="Y" name="saveIdYn"
				<c:if test="${userId !=null }">checked</c:if>>아이디저장</label>
					
					
					</td>
					</tr>
					
					<td>비밀번호</td>
					<td><input type="password" name="password" value =""></td>
					
		</table>

		<button type="button" onclick="location.href = '${ctx}/views/userFrom.jsp'" class = "btn" style ="float:left">사용자 등록</button>
		<button type="submit" class = "btn">로그인</button>

	</form>
</body>
</html>