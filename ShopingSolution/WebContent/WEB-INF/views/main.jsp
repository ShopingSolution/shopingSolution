<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<style></style>
</head>
<body>
	<c:if test="${ !empty message }">
		<script> alert('${message}'); </script>
	</c:if> 
	<button type="button" onclick="findId_go();">아이디 찾기</button>
	<button type="button" onclick="findPwd_go();">비밀번호 찾기</button>
</body>
<script>
	function findId_go(){
		location.href = "findIdFormAction.do";
	}
	function findPwd_go(){
		location.href = "findPwdFormAction.do";
	}
</script>
</html>