<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<title>상세정보</title>
</head>
<body>
	<input id="lectureId" name="lectureId" type="hidden"
		value="${lecture.id}">
	<a href="list.do">강좌목록</a>
	<h3>상세조회</h3>
	<table class="table">
		<colgroup>
			<col width="150">
			<col width="*">
		</colgroup>
		<tr>
			<th>강좌명</th>
			<td><input id="lectureName" name="lectureName"
				class="form-control" type="text" value="${lecture.lectureName }"
				readonly></td>
		</tr>
		<tr>
			<th>교수명</th>
			<td><input id="instructorName" name="instructorName"
				class="form-control" type="text" value="${lecture.instructor }"
				readonly></td>
		</tr>
		<tr>
			<th>강좌소개</th>
			<td><textarea id="lectureIntroduce" name="lectureIntroduce"
					class="form-control" rows="7" readonly>${lecture.introduce }</textarea></td>
		</tr>
	</table>
	<br>

</body>
</html>