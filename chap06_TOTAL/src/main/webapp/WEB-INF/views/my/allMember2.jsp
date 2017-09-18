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
	<h2>회원목록<small style="font-size: 16px;">(총 ${cnt }명)</small></h2>
	<div style="min-height: 410px;">
		<div style="width: 40%;margin-left: 200px;" align="left" >
		<c:forEach var="obj" items="${list }" varStatus="vs">
			<p>
				<c:choose>
					<c:when test="${empty obj.URL }">
						<img id="pre" src="/temp/default.png" alt="기본이미지"
							style="width: 40px; height: 40px; border-radius: 10%;" />
					</c:when>
					<c:otherwise>
						<img id="pre" src="${obj.URL }" alt="사용자프로필"
							style="width: 40px; 40px: 100%; border-radius: 10%;" />
					</c:otherwise>
				</c:choose>
				 ${obj.ID } (${obj.EMAIL }) 
			</p>
		</c:forEach>
		</div>
	</div>
	<div>
		<c:forEach var="i" begin="1" end="${size }" varStatus="vs">
			<c:choose>
				<c:when test="${i eq param.page }">
					<b style="color: orange;">${i }</b>
				</c:when>
				<c:otherwise>
					<a href="/my/allMember2?page=${i }"><b>${i }</b></a>	
				</c:otherwise>
			</c:choose>
			 
			<c:if test="${!vs.last }"> | </c:if>
		</c:forEach>
	</div>
</div>