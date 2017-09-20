package jae.hyeok.app.controllers.ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component("luws")
public class LoginUserWsHandler extends TextWebSocketHandler {
	Map<String, WebSocketSession> users = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// HttpSession�� ��� ����?
		Map<String, Object> hs = session.getAttributes();
		// HttpSession setAttribute �Ǿ��ִ� ������ Map���� ����
		System.out.println("hs�� = "+hs);
		String id = (String)hs.get("auth_id");
		System.out.println("id�� = "+id);
		users.put(id, session);
	}
		// ��Ʈ�ѷ� �ʿ��� ����ϱ� ���ؼ�, �޼��� �ϳ��� �߰��ϴ°ǵ�,
	public void sendMessageToUser(String id, String msg) {
		if(users.containsKey(id)) {
			try {
				users.get(id).sendMessage(new TextMessage(msg));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}
