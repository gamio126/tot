package jae.hyeok.app.controllers.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component("aws")
public class AlertWSHandler extends TextWebSocketHandler {
	List<WebSocketSession> list;
	
	public void sendMessage(String message) {
		for(WebSocketSession s : list) {
			try {
			s.sendMessage(new TextMessage(message));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		list.remove(session);
	}
	
	@PostConstruct	//ºó¼³Á¤ init~method
	public void WSInit() {
		System.out.println("WSHandler...chatWSInit");
		list = new ArrayList<WebSocketSession>();
	}
}
