package jae.hyeok.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jae.hyeok.app.models.InfoDaoMybatis;

@Controller
@RequestMapping("/my")
public class MemberController {

	@Autowired
	InfoDaoMybatis dao;
	
	@GetMapping("/info")
	public String InfoHandle(@RequestParam Map param, HttpSession session) {
		String id = (String) session.getAttribute("auth");
		Map t = dao.myInfo(id);
			t.put("name", param.get("name"));
			t.put("gender", param.get("gender"));
			t.put("birth", param.get("birth"));
			t.put("address", param.get("address"));
		
		return "t_my_info";		
	}
	
	public String InfoChange(@RequestParam Map param) {
		int t = dao.myInfoChange(param) ;
		
		return "t_my_info";
	}
}
