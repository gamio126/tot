<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div align="center" style="margin: 10px;">
	<h3>RANDOM CHATTING</h3>
	<div style="padding:4px; width: 65%; height:5%; background-color: #FFCCFF; font-size: 10pt;" align="left" id="log">
	</div>
	<div style="padding:4px; width: 65%; height:5%; background-color: #FFCCFF; font-size: 10pt;" align="left" id="log1">
	</div>
	<div style="padding:4px; width: 65%; height:50%; background-color: #FFCCFF; overflow-y : scroll; word-break: break-all; 
	font-size: 10pt;" align="left" id="log2">
	</div>
	<input type="text" id="f" style="width: 65%; margin-top:5px; padding: 4px"/>
</div>
<script>
	document.getElementById("f").onchange=function(){
		if(this.value.length!=0) {
			ws.send(this.value);
			this.value="";
		}
	}

	var ws = new WebSocket("ws://192.168.10.70/ws/chat");
	ws.onopen=function(e){
		document.getElementById("log").innerHTML += "<p><b>[오픈채팅 서버 접속 성공]</b></p>";
		window.alert("오픈채팅 서버 접속 성공");
	}
		
	ws.onerror=function(e) {
		if(window.confirm("채팅서버 접속 실패\n다시 접속하시겠습니까?")) {
			ws = new WebSocket("ws://192.168.10.70/ws/chat");
		}
	}
	
	ws.onmessage=function(e){
		//console.log(e);
		var text = e.data;
		var ment = JSON.parse(text);
		console.log(ment);
		if(ment.mode != "chat"){
			document.getElementById("log1").innerHTML = "채팅방 접속자 : "+ment.cnt+"명 <hr/>";
		}else{
			document.getElementById("log2").innerHTML += ment.sender + " => " + ment.msg+"<br/>";
			document.getElementById("log2").scrollTop = document.getElementById("log2").scrollHeight;
		}
	}
</script>