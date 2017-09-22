package jae.hyeok.app.controllers;

import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

	@Autowired
	JavaMailSender sender;
	
	@RequestMapping("/check_con")
	@ResponseBody
	public String checkConfirmHandle(HttpSession session,@RequestParam String cm) {
		System.out.println("CM=>"+cm);
		String uuid = (String)session.getAttribute("uuid");
		System.out.println("UUID=>"+uuid);
		System.out.println(cm.equals(uuid));
		if(cm.equals(uuid)) {
			return "YYYYY";
		}
			return "NNNNN";
	}
	
	@RequestMapping("/confirm")
	@ResponseBody
	public String confirmHandle(@RequestBody String email, HttpSession session ) {
		System.out.println(email);
		UUID u = UUID.randomUUID(); 
		String uuid = u.toString().substring(0,13);
		try {
			MimeMessage msg =  sender.createMimeMessage();
			//To
			msg.setRecipient(RecipientType.TO,new InternetAddress(email));
			//Subject
			msg.setSubject("인증번호");
			//Text
			String text = "<h1>인증번호입니다.</h1>";
			text += uuid+"<br/>";
			text += "<a href=\"http://192.168.10.70\">홈페이지 가기</a>";
			msg.setText(text, "UTF-8","html");
			//From
			sender.send(msg);
			session.setAttribute("uuid", uuid);
			return "true";
		}catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
	
	}
}
