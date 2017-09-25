package jae.hyeok.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jquery")
public class jQueryController {
	
	
	@RequestMapping("/01")
	public ModelAndView jquery01() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("title", "JQuery테스트");
		mav.addObject("section", "jquery/01");
		return mav;
	}
	
	@RequestMapping("/02")
	public ModelAndView jquery02() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("title", "JQuery테스트2");
		mav.addObject("section", "jquery/02");
		return mav;
	}
	
	@RequestMapping("/03")
	public ModelAndView jquery03() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("title", "JQuery테스트3");
		mav.addObject("section", "jquery/03");
		return mav;
	}
	
	@RequestMapping("/qz01")
	public ModelAndView jquery_qz01() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("title", "jquery_qz01");
		mav.addObject("section", "jquery/qz01");
		return mav;
	}
	
	@RequestMapping("/qz02")
	public ModelAndView jquery_qz02() {
		ModelAndView mav = new ModelAndView("t_expr");
		int a = 656000;
		mav.addObject("title", "jquery_qz02");
		mav.addObject("section", "jquery/qz02");
		mav.addObject("ok", a);
		return mav;
	}
}
