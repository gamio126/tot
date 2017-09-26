<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
	<h3>친구찾기 </h3>
	<small>찾고싶은 친구의 ID를 검색해보세요.</small>
	<p>
		<input type="text" id="srch" style="padding: 3px; width: 50%; font-size:12pt;" />
	</p>
	
</div>
<script>
	// keypress , keydown, keyup
	// select * from member where id like #{id}   // word+"%";
	$("#srch").keyup(function() {
		console.log( $(this).val() );
	});
</script>