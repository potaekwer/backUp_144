<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<style type="text/css">
body {
	padding: 50px;
}

h1 {
	font-weight: bold;
	color: #A0B0DB;
}

.ranking {
	text-align: center;
	font-size: 28pt;
}

.spanTitle {
	font-size: 18pt;
	font-weight: bold;
	margin-right: 10px;
}

.pAlbum {
	color: gray;
	margin-left: 5px;
}

.imgAlbum {
	width: 80px;
	height: 80px;
	margin-right: 10px;
}

.btnPlay {
	margin-top: 40%
}
</style>
</head>
<body>
	<%@ include file="header/header.jspf"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h1>${userName }님의 Music List</h1>
				<div style="text-align: right;">
					<a class="btn btn-xs btn-default" href="list.do">뮤직차트</a>
				</div>
				<br>
				<table class="table table-hover table-condensed">
					<colgroup>
						<col width="80" align="center">
						<col width="*">
						<col width="70">
					</colgroup>
					<thead>
						<tr>
							<th>No</th>
							<th>곡정보/곡명</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${mylist eq null || empty mylist}">
								<tr>
									<td colspan="6" align="center"></td>
								</tr>

							</c:when>
							<c:otherwise>
								<c:forEach items="${mylist }" var="mylist" varStatus="status">
									<tr>
										<td class="ranking">${status.count }</td>
										<td>
											<table>
												<tr>
													<td rowspan="2"><img class="imgAlbum"
														src="resources/img/${mylist.image }"></td>
													<td><span class="spanTitle">${mylist.name }</span><a class="btn btn-xs btn-default"
														href="detail.do?Id=${mylist.id }"><b>i</b></a></td>
												</tr>
												<tr>
													<td><p class="pAlbum">${mylist.artist } - ${mylist.album }</p></td>
												</tr>
											</table>
										<td><a class="btn btn-xs btn-danger btnPlay" href="delete.do?musicId=${mylist.id }"><b>
													X</b></a></td>
									</tr>
								</c:forEach>

							</c:otherwise>
							</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>