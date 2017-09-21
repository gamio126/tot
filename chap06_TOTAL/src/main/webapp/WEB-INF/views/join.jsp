<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
input, button {
	width: 100%;
	padding: 5px;
	font-family: 맑은 고딕;
}
b {
	font-size: 12pt;
}
</style>
<div align="center">
	<div style="width: 380px;" align="left">
		<h3>Join HUB</h3>
		<h4>The BestWay to Study Software</h4>
		<h3 style="margin-top: 50px;">CREATE YOUR ACCOUNT</h3>
		<c:if test="${!empty temp }">
			<b style="color:red">join failed..</b>	
		</c:if>
		<form action="/join" method="post" autocomplete="off">
			<p>
				<b>ID</b><br /> <input type="text" name="id" required id="id" /><br />
				<span id="chk_rst"></span>
			</p>
			<p>
				<b>PASS</b><br /> <input type="password" name="pass" required />
			</p>
			<p>
				<b>EMAIL</b><br /> <input type="email" name="email" id="email" required />
			</p>
			<p>
				<button id="cf" type="button">C O N F I R M</button>
			</p>
			<p id="cf_view" style="display: none;">
				<b>AUTHORIZED KEY</b>
				<small id="left" style="color:red;font-weight: bold"></small><br />
				<input type="text" name="confirm" id="cm" required />
				<small id="sufa" style="color:red;font-weight: bold"></small><br />
			</p>
			<button id="sbt" type="submit">C R E A T E</button>
		</form>
	</div>
</div>
<script>
	document.getElementById("cm").onchange=function(){
		var xhr = new XMLHttpRequest();
		var cm = document.getElementById("cm").value;
		var param = "cm="+cm;
		xhr.open("get", "/check_con?"+param, true);
		xhr.send(email);
		xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					var xml = this.responseXML; 
					var con = xml.getElementsByTagName("ss");
					
					if(!con){
						document.getElementById("sufa").innerHTML = "인증번호가 틀립니다."
						document.getElementById("sufa").style.color="red"
					}else{
						document.getElementById("sufa").innerHTML = "인증번호가 일치합니다."
						document.getElementById("sufa").style.color="green"
					}
				}
		}
	}
</script>
<script>
	var tot;
	var time;
	
	document.getElementById("cf").onclick = function() {
		if (document.getElementById("email").value.length != 0) {
			var email = document.getElementById("email").value;
			var param = "email="+email;
			var xhr = new XMLHttpRequest();
			xhr.open("get", "/confirm?"+param, true);
			xhr.send(email);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					window.alert(email + " 로 인증키가 발송되었습니다.");
					console.log(this.responseText)
					document.getElementById("cf").style.display = "none";
					document.getElementById("cf_view").style.display = "";
					tot = 180;
					time = setInterval(limit, 1000);
				}
			}
		}
	}

	var limit = function() {
		var m = Math.floor(tot / 60);
		var s = tot % 60;
		//console.log(m + "/" + s);
		document.getElementById("left").innerHTML = m + " : "+ (s < 10 ? "0" + s : s);
		tot--;
		console.log(tot);
		if(tot<0) {
			window.alert("인증시간이 초과되었습니다.");
			clearInterval(time);
			document.getElementById("cf").style.display = "";
			document.getElementById("cf_view").style.display = "none";
		}
	}
</script>