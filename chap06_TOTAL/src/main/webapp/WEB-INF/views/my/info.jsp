<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.bt {
	padding: 3pt;
	width: 50px;
}
</style>
<div align="center">
	<form action="/my/history" method="post">
		<h3>프로필관리
		<!--  <button type="submit" class="his" id="his" >★</button>--></h3>
	</form>
	<div>
		<div style="height: 200px; width: 200px;">
			<c:choose>
				<c:when test="${empty prof }">
					<img id="pre" src="/temp/default.png" alt="기본이미지"
						style="width: 100%; height: 100%; border-radius: 10%;" />
				</c:when>
				<c:otherwise>
					<img id="pre" src="${prof.URL }" alt="사용자프로필"
						style="width: 100%; height: 100%; border-radius: 10%;" />
				</c:otherwise>
			</c:choose>
		</div>
		<div style="margin-top: 20px;">
			<form action="/my/info" method="post" id="pform"
				enctype="multipart/form-data" style="display: block;">
				<input id="profile" type="file" name="profile" style="display: none" />
				<small >사진을 눌러 새로운 사진을 올려주세요.</small><br/>
				<button type="submit" class="bt" id="sbt" style="margin-top: 10px">적용</button>
				<button type="button" class="bt"
					onclick="javascript:location.reload()">취소</button>
			</form>
		</div>
	</div>
</div>
<script>
	document.getElementById("sbt").onclick = function(){
		window.alert("수정 완료");
		
	}
	document.getElementById("pre").onclick = function() {
		document.getElementById("profile").click();
	}
	
	document.getElementById("profile").onchange = function() {
		// console.log(this.files[0]);
		// console.log("변경발생");
		var reader = new FileReader();
		reader.onload = function(e) {
			// console.log(e.target.result);
			document.getElementById("pre").src = e.target.result;
		}
		reader.readAsDataURL(this.files[0]);
	}
</script>


