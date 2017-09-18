<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
th {
	border-bottom: 1px solid;
	text-align: left;
}

th, td {
	padding: 10px;
}
</style>
<div align="center" style="line-height: 35px">
	<h2>경매장</h2>
	<p align="right" style="margin-right: 30px;">
		${id }님 반갑습니다.<br /> 총 <b>${cnt }</b> 개의 상품이 등록되어있습니다.
	</p>
	<p align="right" style="margin-right: 30px;">
		<a href="/market/add"><button type="button" style="padding: 5px;">상품
				등록</button></a>
	</p>
	<div style="min-height: 476px;">
		<table style="width: 95%; ">
			<thead>
				<tr>
					<th style="width: 10%">상품번호</th>
					<th style="width: 40%">상품명</th>
					<th style="width: 20%">경매가</th>
					<th style="width: 20%">즉시구매가</th>
					<th style="width: 10%">마감일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="obj" items="${list }">
					<tr>
						<td>${obj.NM }</td>
						<td><a href="/market/view/${obj.NM}">${fn:substring(obj.NAME, 0, 12) }</a></td>
						<td><fmt:formatNumber pattern="#,###"
								value="${obj.STPRICE }" /></td>
						<td><c:choose>
								<c:when test="${obj.DRPRICE eq null}">
							-
						</c:when>
								<c:otherwise>
									<fmt:formatNumber pattern="#,###" value="${obj.DRPRICE }" />
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${obj.CLOSEDATE eq null}">
							-
						</c:when>
								<c:otherwise>
									<fmt:formatDate pattern="yy.MM.dd" value="${obj.CLOSEDATE }" />
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form action="/market/search">
		최고가 <input type="number" name="stprice" required style="width: 100px;"
			value="${param.stprice }"> 이하 (<input type="checkbox"
			name="mode" ${param.mode ne null ? 'checked':'' } />즉구가능물품만)
		<button type="submit">검색</button>
	</form>
	<div>
		<c:forEach var="i" begin="1" end="${size }" varStatus="vs">
			<c:choose>
				<c:when test="${i eq param.page }">
					<b style="color: orange;">${i }</b>
				</c:when>
				<c:otherwise>
					<a href="/market/list?page=${i }"><b>${i }</b></a>	
				</c:otherwise>
			</c:choose>
			 
			<c:if test="${!vs.last }"> | </c:if>
		</c:forEach>
	</div>
</div>