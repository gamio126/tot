<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center">
	<h3>세부정보</h3>
		<form action="/my/info_rst.jsp" method="get">
			<p>
				<b>NAME</b><br />
				<input type="text" value="" name="name" required />
			</p>
			<p>
				<b>GENDER</b><br />
				<input type="radio" name="gender" value="남"  ? "checked":"" %> 
					required />남 
				<input type="radio" name="gender" value="여"  ? "checked":"" %>
					required />여
			</p>
			<p>
				<b>BIRTH</b><br />
				<select name="birth"  >
				
				</select>
			</p>
			<p>
				<b>ADDRESS</b><br />
				<input type="text" name="address" size="50" value="" required />
			</p>
			<button type="submit">정보변경</button>
			<a href="/my/drop.jsp"><button type="button">회원탈퇴</button></a>
		</form>

</div>