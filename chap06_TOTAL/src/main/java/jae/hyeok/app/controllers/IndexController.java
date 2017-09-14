package jae.hyeok.app.controllers;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jae.hyeok.app.models.MemberDaoMybatis;

@Controller
public class IndexController {
	@Autowired
	MemberDaoMybatis memberDao;

	@RequestMapping({ "/", "/index" })
	public String rootHandle() {
		return "t_index";
	}

	@RequestMapping("/login")
	public String loginHandle() {
		return "t_login";
	}

	@RequestMapping("/session")
	public String sessionHandle(@RequestParam Map param, Model model, HttpSession session) throws SQLException {
		int t = memberDao.existOne(param);
		if (t == 1) {
			session.setAttribute("auth", param.get("idmail"));
			return "redirect:/";
		} else {
			model.addAttribute("temp", param);
			return "t_login";
		}
	}
}
