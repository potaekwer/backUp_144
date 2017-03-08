<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = 'c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>로그인</title>
    <link rel="stylesheet" href="${ctx }/style/css/reset.css">
    <link rel="stylesheet" href="${ctx }/style/css/style.css">
    
    <script type="text/javascript">
    //로그인시 아이디 패스워드 입력을 확인
    //입력하지 않은 항복에 대한 사용자 알림
    
    function loginValidate(){
    	var loginId = document.getElementById("iptLoginId").value;
    	if(loginId===""){
    		alert("아이디를 입력하세요");
    		document.getElementById("iptLoginId").focus();
    		return false;
    	}
    	return true;
    }
    </script>
</head>
<body>
<div class="login-wrap">
    <h3>로그인</h3>
    <form action="${ctx }/login.do" method="post" onsubmit = "return loginValidate();">
        <label>아이디</label>
        <input type="text" id = "iptLoginId" name="loginId" placeholder="아이디를 입력하세요.">
        <label>비밀번호</label>
        <input type="password" name="passwd" placeholder="패스워드를 입력하세요.">
        <div class="login-btn">
            <input type="reset" value="취소">
            <input type="submit" value="로그인">
        </div>
    </form>
</div>
</body>
</html>