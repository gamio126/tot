package jae.hyeok.app.controllers.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/* 
 * 	ws protocol ó���� ��Ʈ�ѷ���
 *  AbstractWebSocketHandler Ȥ��
 *  TextWebSocketHandler ���߿� �ϳ��� ��ӹް� ����ø� �Ǵµ�,  
 */

public class BasicWSHandler extends TextWebSocketHandler {

	@Override	// Ŭ���̾�Ʈ������ ������ �߻�������
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished...");
		String msg = "ȯ���մϴ�^.^!";
		session.sendMessage(new TextMessage(msg));
	}
	
	@Override	// Ŭ���̾�Ʈ������ ������ ���� �Ǿ�����
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed...");
	}
	
	@Override	// Ŭ���̾�Ʈ�κ��� �����͸� ���۹޾�����
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage...");
		String m = message.getPayload();
		System.out.println("���ŵ� ���� : ["+m+"]");
	}
	
	
	
	
	
	
}
