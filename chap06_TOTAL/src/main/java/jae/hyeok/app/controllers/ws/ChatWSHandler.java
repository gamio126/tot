package jae.hyeok.app.controllers.ws;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component("cws")
public class ChatWSHandler extends TextWebSocketHandler {
	List<WebSocketSession> list;
	@Autowired
	ObjectMapper mapper;
			
	
	@Override	// Ŭ���̾�Ʈ�κ��� �����͸� ���۹޾�����
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map map = new HashMap();
			map.put("mode", "chat");
			map.put("sender", "�����"+session.getId());
			map.put("msg", message.getPayload());
		String json = mapper.writeValueAsString(map);
		System.out.println(json);
		for(WebSocketSession wss : list) {
			wss.sendMessage(new TextMessage(json));
		}
	}
	
	@PostConstruct	//���� init~method
	public void chatWSInit() {
		System.out.println("ChatWSHandler...chatWSInit");
		list = new ArrayList<WebSocketSession>();
	}

	@Override	// Ŭ���̾�Ʈ������ ������ �߻�������
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		String json = String.format("{\"mode\":\"join\", \"cnt\":%d }", list.size());
		System.out.println(json +" at afterConnectionEstablished." );
		for(WebSocketSession wss : list) {
			wss.sendMessage(new TextMessage(json));
		}
	}
	
	@Override	// Ŭ���̾�Ʈ������ ������ ���� �Ǿ�����
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		list.remove(session);
	}
	

	
}