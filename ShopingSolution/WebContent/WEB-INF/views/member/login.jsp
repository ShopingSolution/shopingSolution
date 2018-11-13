<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <article>
  	<h1>Login</h1>
  	<form method ="post" action="Login.do">
  		<fieldset>
  		<legend></legend>
  			<label>User ID</label>
  			<input name="id" type="text" value="${id }"><br>
  			<label>Password</label>
  			<input name="pwd" type="password"><br>
  		</fieldset>
  		<div class="clear"></div>
  		<div id="buttons">
  			<input type="submit" value="로그인" class="sybmut">
  			<input type="button" value="회원가입" calss="cancel"
  				onclick="location='contract.do'">
  				<input type="button" value="아이디 비밀번호 찾기" class="submit"
  				onclick="location='findIdForm.do'">  		
  		</div>
  	</form>
  </article>