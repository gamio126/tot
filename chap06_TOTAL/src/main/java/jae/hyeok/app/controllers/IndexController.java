package jae.hyeok.app.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@PostMapping("/login")
	public ModelAndView sessionHandle(@RequestParam Map param, HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView();
		int t = memberDao.existOne(param);
		if (t == 1) {
			HashMap u = memberDao.readOneByIdOrEmail((String)param.get("idmail"));
			System.out.println(t);
			session.setAttribute("auth", u);
			mav.setViewName("redirect:/");
		} else {
			mav.setViewName("t_login");
			mav.addObject("temp", "temp");
		}
		return mav;
	}
}
