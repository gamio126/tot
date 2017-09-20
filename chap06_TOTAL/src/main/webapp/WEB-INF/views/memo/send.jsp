<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
	<div align="center">
		<form action="/memo/send" method="post">
			<p>
			받을사람
			</p> 
			<p >
			 <input type="text" name="receiver" placeholder="받을사람" autocomplete="off" required/><br/>
				
			</p>
			보낼내용  
			<p>
			<textarea name="content" rows="6" cols="40" placeholder="보낼내용" style="margin-bottom: 10px;" required></textarea><br/>
			<button id="bt" type="submit" style="width: 172px; margin-left: 31px;">쪽지발송</button>
		</form>
	</div>
	<script>
		document.getElementById("bt").onclick=function(){
			window.alert("전송완료");
		}
	</script>