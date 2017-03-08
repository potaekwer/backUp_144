<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌등록</title>
</head>
<body>
	<input id="lectureId" name="lectureId" type="hidden" value="">
	<a href="list.do">강좌목록</a>
	<h3>강좌목록</h3>

	<br>
	<form action="register.do" method="post">
		<table class="table">
			<colgroup>
				<col width="150">
				<col width="*">
			</colgroup>
			<tr>
				<th>강좌명</th>
				<td><input id="lectureName" name="lectureName"
					class="form-control" type="text" value=""></td>
			</tr>
			<tr>
				<th>교수명</th>
				<td><input id="instructorName" name="instructorName"
					class="form-control" type="text" value=""></td>
			</tr>
			<tr>
				<th>강좌소개</th>
				<td><textarea id="lectureIntroduce" name="lectureIntroduce"
						class="form-control" rows="7"></textarea>
			</tr>
		</table>
		<br>
		<div align="center">
			<input class="btn" type="reset" value="취소"> <input
				class="btn btn-success" type="submit" value="저장">
		</div>
	</form>
	<br>
</body>
</html>