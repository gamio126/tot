<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
<h1>1103Ho 10Bun</h1>
<c:choose>
	<c:when test="${auth eq null}">
		<h3>안녕하세요.</h3>
	</c:when>
	<c:otherwise>
		<h3>${auth.ID }님 반갑습니다.</h3>
	</c:otherwise>
</c:choose>
</div>