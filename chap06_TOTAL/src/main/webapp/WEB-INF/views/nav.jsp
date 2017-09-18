<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div align="right">
	<c:choose>
		<c:when test="${auth.ID eq null}">
			<a href="login">LOGIN</a> | <a href="join">JOIN</a>
			<hr/>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${empty list.URL }">
					<img id="pre" src="/temp/default.png" alt="기본이미지"
						style="width: 40px; height: 40px; border-radius: 10%;" />
				</c:when>	
				<c:otherwise>
					<img id="pre" src="${list.URL }" alt="사용자프로필"
						style="width: 40px; 40px: 100%; border-radius: 10%;" />
				</c:otherwise>
			</c:choose>
			${auth.ID }(${auth.NAME })님 환영합니다.<br/>	
			<a href="board/list">BOARD</a> | 
			<a href="market/list">MARKET</a> | 
			<a href="my/info">INFORMATION</a> |
			<a href="my/allMember2">MEMBER</a> |
			<hr/>
		</c:otherwise>
	</c:choose>
</div>