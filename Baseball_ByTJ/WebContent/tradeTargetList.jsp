<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BaseballTeam</title>
<meta charset="utf-8">
<link href="resources/css/bootstrap_modify.css" rel="stylesheet">
<link href="resources/css/layout.css" rel="stylesheet">
<script src="resources/js/jquery-2.1.3.js"></script>


<!--
<script>
		window.onload = function() {//윈도우가 열리면
			document.getElementById("send").onclick = function() {
				var pid = targetPlayer.value;
				var sid = sorece.value;
				document.write(pid);
				location.href="trade.do?sorece="+sid+"&targetPlayer="+pid;
			}			
		}
</script>

-->




</head>
<body>
	
	
<!-- Main Navigation ================================================================================= -->
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BaseballTeam</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="teamList.do">홈</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="teamList.do">팀목록</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="playerList.do">선수목록</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- Header ========================================================================================== -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="jumbotron">
						<h2>${sorece.name }선수트레이드</h2>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<ol class="breadcrumb">
						<li>홈</li>
						<li>선수목록</li>
						<li class="active ">트레이드</li>
					</ol>
				</div>
			</div>
		</div>
	</header>

	<!-- Container ======================================================================================= -->
	<form action="trade.do" method="post"> 
		<div class="container">
			<div class="row">

				<div class="col-sm-12 col-lg-12">
					<div>
						<h3>트레이드 대상 선수 목록</h3>
					</div>


					<div class="table-responsive">


						<table class="table table-striped table-bordered table-hover">
							<colgroup>
								<col width="100" />
								<col width="200" />
								<col width="200" />
								<col width="200" />
								<col width="200" />
								<col width="*" />
							</colgroup>
							<thead>
								<tr>
									<th class="text-center">선택</th>
									<th class="text-center">이름</th>
									<th class="text-center">등번호</th>
									<th class="text-center">포지션</th>
									<th class="text-center">특징</th>
									<th class="text-center">팀명</th>
								</tr>
							</thead>
							<tbody>

								<input type="hidden" name="sorece" id = "sorece" value="${sorece.playerId }">

								<c:choose>
									<c:when test="${trades eq null || empty trades}">
										<tr>
											<th colspan="6" class="text-center">등록된 선수 정보가 존재하지
												않습니다.</th>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${trades }" var="trade" varStatus="no">
											<c:forEach items="${trade.players }" var="player"
												varStatus="num">
												<c:set var="pno" value="${pno +1 }" />
												<tr>
													<td class="text-center"><input type="radio"
														name="targetPlayer" value="${player.playerId}"></td>
													<td class="text-center">${player.name }</td>
													<td class="text-center">${player.backNumber }</td>
													<td class="text-center">${player.position }</td>
													<td class="text-center">${player.throwHand }
														${player.throwHand }</td>
													<td class="text-center">${trade.name }</td>
												</tr>
											</c:forEach>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>

					</div>

					<div class="text-right">
						<input type="submit" class="btn btn btn-warning" value="트래이드"> 
					<!--	<button type="button" class="btn btn btn-warning" id = "send">트래이드</button>-->
					</div>

				</div>

			</div>
<!--	</form> -->
	<!-- Footer ========================================================================================== -->
	<footer>
		<hr>
		<p>© NamooBaseball 2016.</p>
	</footer>
	</div>

</body>
</html>