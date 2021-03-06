package jae.hyeok.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jae.hyeok.app.models.MemberDaoMybatis;



@Controller
@RequestMapping("/member")
public class SearchController {
	@Autowired
	MemberDaoMybatis dao;
	
	@RequestMapping("/search")
	public ModelAndView searchIdHandle() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("title", "ģ��ã��");
		mav.addObject("section", "member/search");
		return mav;
	}
	
	@RequestMapping("/searchAjax")
	@ResponseBody
	public List<Map> searchIdAjaxHandle(@RequestParam String id) {
		return dao.searchById(id+"%");
	}

}