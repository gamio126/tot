<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div align="right">
	<c:choose>
		<c:when test="${auth.ID eq null}">
			<a href="/login">LOGIN</a> | <a href="/join">JOIN</a> | <a href="/chat">CHAT</a>
			<hr/>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${empty prof.url }">
				<a href="/chat">CHAT</a> | 
					<img id="pre" src="/temp/default.png" alt="기본이미지"
						style="width: 40px; height: 40px; border-radius: 10%; margin-left: 10px" />
				</c:when>	
				<c:otherwise>
				<a href="/chat">CHAT</a> | 
					<img id="pre" src="${prof.url }" alt="사용자프로필"
						style="width: 40px; 40px: 100%; border-radius: 10%; margin-left: 10px" />
				</c:otherwise>
			</c:choose>
			${auth.ID }(${auth.NAME })님 환영합니다.<br/>	
			<a href="/board/list">BOARD</a> | 
			<a href="/market/list">MARKET</a> | 
			<a href="/my/info">INFORMATION</a> |
			<a href="/my/allMember2">MEMBER</a><br/>
			<a href="/memo/home">MESSAGE</a> |
			<a href="/apic/park">PARKING</a> |
			<a href="http://dic.naver.com/">DICTIONARY</a> |
			<hr/>
		</c:otherwise>
	</c:choose>
</div>
<c:if test="${!empty auth }">
	<script>
		var luws = new WebSocket("ws://192.168.10.70/ws/loginUsers");
		
		luws.onmessage=function(e){
			var obj = JSON.parse(e.data);
			console.log(obj);
			switch(obj.mode) {
			case "memo" :
				window.alert(obj.sender+"님이 새 쪽지를 보냈습니다.");
				break;
			}
		}
	</script>
	
</c:if>