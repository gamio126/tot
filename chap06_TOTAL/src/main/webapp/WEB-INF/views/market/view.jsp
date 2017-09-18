<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- ---------------------------------------------------- --%>
<style>
input, textarea, button {
	padding: 4px;
	font-family: 맑은고딕;
	font-size: 9pt;
}
</style>
<div align="center" style="line-height: 35px">
	<h2>
		<a href="/market/list">경매장</a>
	</h2>
	<hr />
	<c:choose>
		<c:when test="${empty one }">
			이미 삭제된 글입니다.
		</c:when>
		<c:otherwise>
			<div
				style="width: 40%; border-radius: 10px; background-color: #e6dfdf; padding-left: 20px;"
				align="left">
				<input type="hidden" id="num" value="${one.NM }" />
				<h3>${one.NAME }</h3>
				
				<p style="padding-left: 10px;">
					<small> 경매가 : <fmt:formatNumber pattern="#,###" value="${one.STPRICE }" />  <br/> 
							즉구가 : <c:choose>
									<c:when test="${one.DRPRICE eq null}">
										-
									</c:when>
									<c:otherwise>
										<fmt:formatNumber pattern="#,###" value="${one.DRPRICE }" />
									</c:otherwise>
									</c:choose>  
					<br/> 
							마감일 : <c:choose>
									<c:when test="${one.CLOSEDATE eq null}">
											-
									</c:when>
									<c:otherwise>
										<fmt:formatDate pattern="yy.MM.dd" value="${one.CLOSEDATE }" />
									</c:otherwise>
									</c:choose> 
					</small>
				</p>
			</div>
		</c:otherwise>
	</c:choose>
	<hr />
	<c:choose>
		<c:when test="${id eq null}">
			<a href="/login">로그인 후 이용하세요.</a>
		</c:when>
		<c:otherwise>
			<div style="width: 60%">
				<h3 style="margin-bottom: 0px; margin-top: 0px;">${id }<small>님 마음에 드는 상품이 있으시면 입찰 버튼을 눌러주세요.</small></h3>
				<div align="center">
					<select id="bankname" style=" height: 27px; width: 142px;">
						<option>-은행선택-</option>
						<option>KB국민은행</option>
						<option>우리은행</option>
						<option>신한은행</option>
						<option>KEB하나은행</option>
						<option>한국씨티은행</option>
						<option>제주은행</option>
						<option>농협</option>
						<option>IBK기업은행</option>
					</select>
					<input type="number" id="acnumber" placeholder="(-)없이 계좌번호 입력" style="width: 20%"/>
					<button type="button" id="st" style="width: 60px">입 찰</button>
				</div>
				<div align="center">
					<input type="text" id="stprice" placeholder="경매가" style="width: 35.5%"/> 
					<button type="button" id="dr" >즉시구매</button>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>


