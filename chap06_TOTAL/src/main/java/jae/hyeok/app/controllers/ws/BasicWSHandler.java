package jae.hyeok.app.controllers.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/* 
 * 	ws protocol 처리용 컨트롤러는
 *  AbstractWebSocketHandler 혹은
 *  TextWebSocketHandler 둘중에 하나를 상속받고 만드시면 되는데,  
 */

public class BasicWSHandler extends TextWebSocketHandler {

	@Override	// 클라이언트측에서 연결이 발생했을때
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished...");
		String msg = "환영합니당^.^!";
		session.sendMessage(new TextMessage(msg));
	}
	
	@Override	// 클라이언트측에서 연결이 해제 되었을때
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed...");
	}
	
	@Override	// 클라이언트로부터 데이터를 전송받았을때
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage...");
		String m = message.getPayload();
		System.out.println("수신된 내용 : ["+m+"]");
	}
	
	
	
	
	
	
}
