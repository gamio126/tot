<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	String id = (String)session.getAttribute("auth");
	request.setAttribute("id", id);
%>
<div align="right">
	<c:choose>
		<c:when test="${id eq null}">
			<a href="login">LOGIN</a> | <a href="join">JOIN</a>
			<hr/>
		</c:when>
		<c:otherwise>
			${id }님 환영합니다.<br/>
			<a href="board/list">BOARD</a> | <a href="market/list">MARKET</a>
			<hr/>
		</c:otherwise>
	</c:choose>
</div>