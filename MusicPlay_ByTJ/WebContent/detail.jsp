<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<style>
body {
	padding : 10% 30%;
}
td{
	padding: 10px;
}
#musicDetail {
	width:100%;
}
</style>
</head>
<body>
<%@ include file = "header/header.jspf" %>
	<div style="text-align: right;">
		<c:if test="${loginCheck }"><a class="btn btn-xs btn-info" href="addList.do?musicId=${music.id }">담기</a></c:if>&nbsp;
		<a class="btn btn-xs btn-default" href="list.do">뮤직차트</a>
	</div>
	<h2>${detailmusic.name }</h2>
	<hr>
	<table id="musicDetail">
		<colgroup>
			<col width="200px">
			<col width="*">
		</colgroup>
		<tr>
			<td><img src="resources/img/${detailmusic.image }" width="180px"></td>
			<td>
			<table class="table">
					<colgroup>
						<col width="150">
						<col width="*">
					</colgroup>
					<tr>
						<th>곡명</th>
						<td>${detailmusic.name }</td>
					</tr>
					<tr>
						<th>앨범명</th>
						<td>${detailmusic.album }</td>
					</tr>
					<tr>
						<th>아티스트</th>
						<td>${detailmusic.artist }</td>
					</tr>
					<tr>
						<th>기획사</th>
						<td>${detailmusic.agent }</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>

</body>
</html>