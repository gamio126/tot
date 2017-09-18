<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<h2>상품 등록</h2>
	<c:choose>
		<c:when test="${r eq 1}">
			<p>상품 등록이 정상적으로 처리되었습니다.</p>
		</c:when>
		<c:otherwise>
			<h3>실패</h3>
			<p>
				일시적인 오류 상태입니다.<br /> <a href="/market/add">다시 시도</a>해주십시요.
			</p>
		</c:otherwise>
	</c:choose>
	<a href="/market/list"><button type="button">경매장 가기</button></a>
</div>