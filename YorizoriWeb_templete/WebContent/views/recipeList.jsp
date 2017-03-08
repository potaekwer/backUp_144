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

<%@ include file = "./header.jspf" %>

<h1>레시피 목록</h1>
<h2>${cookbook.name }</h2>
<span>${cookbook.description }</span>

<button type="button" onclick="javascript:location.href='${ctx}/recipe/register.do?cbId=${cookbook.id }';" class = "btn">레시피 등록</button>

<br><br>
<br>

<c:forEach items="${cookbook.recipes }" var="recipe">
	<table class="section">
		<tr>
		<td>
			<img src="${ctx }/recipe/image.do?recipeId=${recipe.id}" width ="128" height = "123">
		</td>
		</tr>
		<tr>
		<td><a href="${ctx }/recipe/detail.do?recipeId=${recipe.id}" >${recipe.name }</a>
		<br>
		(${recipe.time }분/난이도 ${recipe.level })		
		</td>
		</tr>
		
	
	</table>

</c:forEach>

<c:if test="${empty cookbook.recipes }">
	<h2>등록된 레시비가 없습니다.</h2>
</c:if>
</body>
</html>