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
		// simpleMailMassage ��ü �̿�
		SimpleMailMessage msg = new SimpleMailMessage();
		// �߽��� / ������ / ����
		try {
			msg.setTo(t);	// ������� �ּ�
			msg.setFrom("master@gmail.com");  // �����»�� �ּ�
				// smtp.gamil ���� ��ȸ�ؼ� ���۵� ��, ������ ��� �ּҰ�, gmail �ּҷ� �ڵ� ��ȯ.
			msg.setSubject("�λ����");
			String text = "����!";
			text += "�ȳ��ϻ�\n";
			text += "���Ϻ����� �������̻�\n";
			text += "�߼��� ����\n";
			text += "���� ���ղ� ��û�\n";
			text += "�����ϻ�";
			msg.setText(text);
			
			sender.send(msg);	// �߼�
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
			msg.setSubject("����!");
			//Text
			String text = "<h1>ȯ���մϴ�</h1>";
			text += "������ �����մϴ�.";
			text += "<a href=\"http://192.168.10.70\">Ȩ������ �����</a>";
			msg.setText(text, "UTF-8","html");
			//From
			sender.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@RequestMapping("/uuid")
	public void uuidHandle() {
		UUID u = UUID.randomUUID(); // ���� �ĺ��ڰ� �ʿ��ϰ� �� �� ���Ǵ� Ŭ����
		// ������ ��Ģ�� ���� ���� �Ϻ��ϰ� �ߺ����� �ʴ� ���� Ű�� �����ؼ� ����� �� ����
		System.out.println(Math.pow(16, 8));
		System.out.println(u.toString());
		String auth_str = u.toString().substring(0,13);
		System.out.println(auth_str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
