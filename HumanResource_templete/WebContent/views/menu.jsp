<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = 'c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인사관리 시스템</title>
    <link rel="stylesheet" href="${ctx }/style/css/reset.css">
    <link rel="stylesheet" href="${ctx }/style/css/style.css">
</head>
<body>
<header>
  <%@ include file="header.jspf" %>
</header>
<nav>
   <%@ include file="sideMenu.jspf" %>
</nav>
<div class="contents-wrap">
    <h2 class="page-title"> 인사관리 시스템 MENU </h2>

</div>
<footer>
    <%@ include file="footer.jspf" %>
</footer>
</body>
</html>