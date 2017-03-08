<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='ctx' value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel= "stylesheet" type="text/css" href ="${ctx }/css/yorizori.css">
<title>요리조리 쿡북</title>
</head>
<body>
 <h1>요리책 등록</h1>
 <form action="${ctx }/cookbook/register.do" method="post">
 	<table border="1">
 		<tr>
 		<td>요리책명</td>
 		<td><input type="text" name= "bookName" value =""></td>
 		</tr>
 		<tr>
 		<td>등록자</td>
 		<td><span>${loginUser.name }${loginUser.userId }</span></td>
 		</tr>
 		<tr>
 		<td>설명</td>
 		<td><textarea name = "bookDesc" cols = "60" rows="5" ></textarea></td>
 		</tr>
 		
 	</table>
 	<button type="button" onclick="javascript:gotoMain();"  class="btn">목록</button>
 	<button type="submit" class = "btn">등록</button>
 
 </form>
 <script type="text/javascript">
 	function gotoMain(){
 		window.location.href="${ctx}/";
 		return false;
 	}
 
 
 
 
 </script>
 

</body>
</html>