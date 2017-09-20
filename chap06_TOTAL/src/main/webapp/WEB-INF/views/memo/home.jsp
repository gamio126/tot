<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<style>
th {
	border-bottom: 1px solid;
	text-align: left;
}

th, td {
	padding: 10px;
}
</style> 
<div align="center">

	<h2>${auth_id }'s 쪽지함</h2>
	<p><b>${cnt }</b>개의 쪽지가 있습니다.</p>
	<div style="min-height: 400px;">
		<table style="width: 90%; margin-bottom: 20px;">
			<thead></thead>
			<thead>
				<tr>
					<th style="width: 5%">#</th>
					<th style="width: 20%">보낸사람</th>
					<th style="width: 75%">메모내용</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${empty list}">
					<td align="center" colspan="3">받은 쪽지가 존재하지 않습니다</td>
				</c:when >
				<c:otherwise>
					<c:forEach var="i" begin="0" end="${list.size()-1}">
						<tr>
							<td><input type="checkbox" name="no" value="${list[i].NO }" /></td>
							<td><c:choose>
									<c:when test="${list[i].SENDER eq auth_id}">
										${list[i].SENDER }
									</c:when>
									<c:otherwise>
										<a href="/member/info.jsp?target=${list[i].SENDER }">
											${list[i].SENDER }</a>
									</c:otherwise>
								</c:choose></td>
							<td>${list[i].CONTENT }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<a style=""  href="/memo/send"><button type="button">쪽지보내기</button></a>
	</div>
	<div style="margin-top: 10px">
		<c:forEach var="i" begin="1" end="${size }" varStatus="vs">
			<c:choose>
				<c:when test="${i eq param.page }">
					<b style="color: orange;">${i }</b>
				</c:when>
				<c:otherwise>
					<a href="/memo/home?page=${i }"><b>${i }</b></a>	
				</c:otherwise>
			</c:choose>
			 
			<c:if test="${!vs.last }"> | </c:if>
		</c:forEach>
	</div>	
</div>