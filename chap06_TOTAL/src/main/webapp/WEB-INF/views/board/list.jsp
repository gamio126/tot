<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h2>게시판</h2>
	<p align="right" style="margin-right: 30px;">
		총 <b>${cnt }</b> 개의 글이 등록되어있습니다.
	</p>
	<p align="right" style="margin-right: 30px;">
		<a href="/board/add"><button type="button" style="padding: 5px;">글작성</button></a>
	</p>
	<div style="min-height: 476px;">
		<table style="width: 95%">
			<thead>
				<tr>
					<th style="width: 10%">글번호</th>
					<th style="width: 60%">글제목</th>
					<th style="width: 20%">작성자</th>
					<th style="width: 10%">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="obj" items="${list }">
					<tr>
						<td>${obj.NUM }</td>
						<td><a href="/board/view/${obj.NUM}">${fn:substring(obj.TITLE, 0, 12) }
						</a>
						<c:choose>
							<c:when test="${obj.CNT eq null}">
								[0]
							</c:when>
							<c:otherwise>
								[${obj.CNT}]
							</c:otherwise>
						</c:choose>
	
						</td>
						<td>${obj.WRITER }</td>
						<td><fmt:formatNumber value="${obj.COUNT }" pattern="#,###" />
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	<div>
		<c:forEach var="i" begin="1" end="${size }" varStatus="vs">
			<c:choose>
				<c:when test="${i eq param.page }">
					<b style="color: orange;">${i }</b>
				</c:when>
				<c:otherwise>
					<a href="/board/list?page=${i }"><b>${i }</b></a>	
				</c:otherwise>
			</c:choose>
			 
			<c:if test="${!vs.last }"> | </c:if>
		</c:forEach>
	</div>
</div>