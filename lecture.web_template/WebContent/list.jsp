<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌목록</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>

<%@ include file = "header/header.jspf" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3>강좌목록</h3>
				<table class="table table-hover table-condensed">
					<colgroup>
						<col width="80" align="center">
						<col width="100">
						<col width="30%">
						<col width="*">
						<col width="100">
						<col width="100">
					</colgroup>
					<thead>
						<tr>
							<th>No</th>
							<th>강좌ID</th>
							<th>강좌명</th>
							<th>강사</th>
							<c:if test="${isAdmin }">
							<th>UPDATE</th>
							<th>DELETE</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${lectures eq null || empty lectures }">
								<tr>
									<td colspan="6" align="center">등록된 강좌가 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${lectures }" var="lecture" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${lecture.id }</td>
										<td><a href="detail.do?id=${lecture.id }">${lecture.lectureName }</a></td>
										<td>${lecture.instructor }</td>
											<c:if test="${isAdmin }">
												<td><a href="modify.do?id=${lecture.id }"
													class="btn btn-xs btn-warning">update</a></td>
												<td><a href="remove.do?id=${lecture.id }"
													class="btn btn-xs btn-danger">delete</a></td>
											</c:if>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<c:if test="${isAdmin }">
				<a class="btn btn-sm btn-success" href="registerForm.jsp">강좌등록</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>