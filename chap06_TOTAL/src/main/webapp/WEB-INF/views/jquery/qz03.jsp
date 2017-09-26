<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
span, input, button {
	padding: 3px;
}
</style>
<h3>JQuery 연습#3</h3>
<small>현재 생각나는 것 5개를 적어주세요. (필요없으면 X)</small>
<div>
	<c:forEach begin="1" end="5" var="i">
		<div style="margin: 3px;">
			<span>#${i }</span><input type="text" />
			<button class="ubt">▲</button>
			<button class="dbt">▼</button>
			<button class="rbt">X</button>
		</div>
	</c:forEach>
</div>
<script>
	$(".ubt").click(function() {
		$(this).parent().prev().before($(this).parent());
	});
	$(".dbt").click(function() {
		$(this).parent().next().after($(this).parent());
	});
	
	
	$(".rbt").click(function() {
		if ($(this).parent().find("input").val().length != 0) {
			if (!window.confirm("정말삭제하시겠습니까?"))
				return;
		}
		$(this).parent().remove();
	});
</script>