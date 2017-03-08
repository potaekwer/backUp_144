<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌수정</title>
</head>
<body>
	<a href="list.do">목록화면으로</a>
	<h3>강좌수정</h3>
	<form action="modify.do" method="post" >
		<input id="lectureId" name="lectureId" type="hidden"
			value="${lecture.id}">
		<table class="table">
			<colgroup>
				<col width="150">
				<col width="*">
			</colgroup>
			<tr>
				<th>강좌명</th>
				<td><input id="lectureName" name="lectureName"  class="form-control" type="text"
					value="${lecture.lectureName } "></td>
			</tr>
			<tr>
				<th>교수명</th>
				<td><input id="instructorName" name="instructorName"  class="form-control" 
					type="text" value="${lecture.instructor }"></td>
			</tr>
			<tr>
				<th>강좌소개</th>
				<td><textarea id="lectureIntroduce" name="lectureIntroduce"  class="form-control" 
						rows="7">${lecture.introduce }</textarea></td>
			</tr>
		</table>
		<div align="center">
		<input class="btn" type="reset" value="취소"> <input class="btn btn-success" type="submit"
			value="저장"></div>
	</form>
	<br>
</body>
</html>