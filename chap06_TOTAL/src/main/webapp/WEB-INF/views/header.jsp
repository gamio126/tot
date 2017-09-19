<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h1><a href="/">JHnP Corporation</a></h1>
</div>


<script>
	var aws = new WebSocket("ws://192.168.10.70/ws/alert");
	
	aws.onmessage=function(e){
		console.log(e.data);
		if(${auth ne null}){
			window.alert(e.data);
		}
	}
</script>