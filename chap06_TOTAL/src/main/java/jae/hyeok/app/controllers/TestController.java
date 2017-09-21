package jae.hyeok.app.controllers;

import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	JavaMailSender sender;
	
	@RequestMapping("/basic")
	public String basicHandle() {
		return "test/basic";
	}
	
	@RequestMapping("/send01")
	public void send01Handle(@RequestParam(name="t")String t) {
		// simpleMailMassage 객체 이용
		SimpleMailMessage msg = new SimpleMailMessage();
		// 발신자 / 수신자 / 내용
		try {
			msg.setTo(t);	// 받을사람 주소
			msg.setFrom("master@gmail.com");  // 보내는사람 주소
				// smtp.gamil 이쪽 우회해서 전송될 때, 보내는 사람 주소가, gmail 주소로 자동 변환.
			msg.setSubject("인사메일");
			String text = "리모!";
			text += "안녕하삼\n";
			text += "메일보내기 공부중이삼\n";
			text += "추석때 보삼\n";
			text += "점심 맛잇께 드시삼\n";
			text += "수고하삼";
			msg.setText(text);
			
			sender.send(msg);	// 발송
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/send02")
	public void send02Handle(@RequestParam(name="t")String t) {
		// MineMessage
		try {
			MimeMessage msg =  sender.createMimeMessage();
			//To
			msg.setRecipient(RecipientType.TO,new InternetAddress(t));
			//Subject
			msg.setSubject("웰컴!");
			//Text
			String text = "<h1>환영합니다</h1>";
			text += "가입을 축하합니다.";
			text += "<a href=\"http://192.168.10.70\">홈페이지 놀러가기</a>";
			msg.setText(text, "UTF-8","html");
			//From
			sender.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@RequestMapping("/uuid")
	public void uuidHandle() {
		UUID u = UUID.randomUUID(); // 고유 식별자가 필요하게 될 때 사용되는 클래스
		// 정해진 규칙에 의해 거의 완벽하게 중복되지 않는 고유 키를 생성해서 사용할 수 있음
		System.out.println(Math.pow(16, 8));
		System.out.println(u.toString());
		String auth_str = u.toString().substring(0,13);
		System.out.println(auth_str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
