<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ='ctx' value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./header.jspf" %>


<button onclick="location.href='${ctx }/cookbook/register.do;'">요리책등록</button></br></br>
<div>
	<c:forEach items="${cookbooks }" var ="cookbook">
		<table border="1">
			<tr>
				<td>
					<a href="${ctx }/recipe/list.do?cdId=${cookbook.id}">${cookbook.name }</a><br>
					-${cookbook.author.name }-
					</td>
					</tr>
					
		</table>
	
	
	</c:forEach>
</div>

</body>
</html>