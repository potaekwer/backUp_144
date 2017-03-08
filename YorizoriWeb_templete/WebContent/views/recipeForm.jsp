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
	<h1>레시피 등록</h1>
	<form action="${ctx }/recipe/register.do" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>레시피명</td>
				<td><input type="text" name="recipeName" value=""></td>
				<td>등록자</td>
				<td>${loginUser.name }</td>
			</tr>
			<tr>
				<td>조리시간</td>
				<td><input type="text" name="recipeTime" value=""></td>
				<td>난이도</td>
				<td><select name="recipeLevel">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select></td>
			</tr>


			<tr>
				<td>재료</td>
				<td colspan="3"><input type="text" name="recipeIngredients" value=""></td>
			</tr>
			<tr>
				<td>조리 절차</td>
				<td colspan="3"><textarea name="recipeProcedure" cols="60" rows="5"></textarea></td>
			</tr>
			<tr>
				<td align="right">파일첨부</td>
				<td align="left" style="padding-left: 20; padding-right: 30" colspan="3" >
				<input type="file" id = "attachFile" name="attachFile" style="color: slategray; border: 1 solid silver; width: 300; height: 20">
					(최대 4M)</td>
			</tr>

		</table>
		<button type="button" onclick="javascript:gotoMain();" class="btn">목록</button>
		<button type="submit" class="btn">등록</button>
		<input type="hidden" value="${cbId }" id= "cbId" name = "cbId">
		<input type="hidden" value="${loginUser.userId }" id= "userId" name = "userId">
		</form>
		<script type="text/javascript">
			function gotoMain() {
				window.location.href = "${ctx}/";
				return false;
			}
		</script>



	
</body>
</html>