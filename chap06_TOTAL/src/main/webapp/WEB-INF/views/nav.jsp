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
			${auth.ID }(${auth.NAME })님 환영합니다.<br/>	
			<a href="board/list">BOARD</a> | <a href="market/list">MARKET</a> | <a href="my/info">INFORMATION</a>
			<hr/>
		</c:otherwise>
	</c:choose>
</div>