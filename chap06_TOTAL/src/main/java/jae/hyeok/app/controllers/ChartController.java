package jae.hyeok.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jae.hyeok.app.models.MemberDaoMybatis;

@Controller
@RequestMapping("/chart")
public class ChartController {
	
	@Autowired
	MemberDaoMybatis dao;
	
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping("/01")
	public ModelAndView chart01Handle() {
		ModelAndView mav = new ModelAndView("t_expr");
		List<Map> list = dao.countByGender();
		System.out.println("리스트 ->"+list);
		mav.addObject("title", "chart01");
		mav.addObject("section", "chart/01");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/02")
	public ModelAndView chart02Handle() throws JsonProcessingException {
		ModelAndView mav = new ModelAndView("t_expr");
		List<Map> list =  dao.countByGender();
		mav.addObject("title", "chart02");
		mav.addObject("section", "chart/02");
		// 2차원 배열형태의 JSON 문자열을 설정해두는 .. JSON array = java ' ArrayList ,  
		List json = new ArrayList();
		for(Map m : list) {
			Object[] ar = new Object[] {m.get("GENDER"), m.get("CNT")};
			json.add(ar);
		}
		String str = mapper.writeValueAsString(json);
		System.out.println(str);
		mav.addObject("json", str);
		return mav;
	}
	
	@RequestMapping("/03")
	public ModelAndView chart03Handle() throws JsonProcessingException {
		ModelAndView mav = new ModelAndView("t_expr");
		List<Map> list =  dao.countByGender();
		mav.addObject("title", "chart03");
		mav.addObject("section", "chart/03");
		
		return mav;
	}
	
	
	
	
}
