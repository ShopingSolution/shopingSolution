<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
</head>
<body>
	<h1>패스워드 찾기</h1>
	<h3>hint : 가입당시 사용한 아이디와 이메일을 입력 </h3>
	<form name="frm" action="findPwdAction.do" method="get">
		<label>아이디</label>
		<input type="text" name="id" title="아이디" placeholder="아이디를 입력..." /><br/>
		<label>이메일</label>
		<input type="email" name="email" title="이메일" placeholder="이메일을 입력..." /><br/>
		<button type="button" onclick="submit_go();">확인</button>
		<input type="reset" value="초기화" />
		<button type="button" onclick="back_go();">뒤로</button>
	</form>
</body>
<script>
	function submit_go(){
		document.frm.submit();
	}
	function back_go(){
		history.go(-1);
	}
</script>
</html>