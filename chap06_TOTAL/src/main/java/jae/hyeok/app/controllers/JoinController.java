package jae.hyeok.app.controllers;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jae.hyeok.app.models.MemberDaoMybatis;

@Controller
public class JoinController {
	@Autowired
	MemberDaoMybatis memberDao;

	@GetMapping(path = "/join")
	public String joinGetHandle() {
		return "t_join";
	}

	@PostMapping("/join")
	public String joinPostHandle(@RequestParam Map map, HttpSession session, Model model) {
		try {
			boolean b = memberDao.addOne(map);
			/*session.setAttribute("auth", "on");*/
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("temp", map);
			return "t_join";
		}
	}

	@PostMapping("/signup_check/{mode}")
	public String signupHandle() {
		return "";
	}
}
