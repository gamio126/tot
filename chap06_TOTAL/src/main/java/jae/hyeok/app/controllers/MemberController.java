package jae.hyeok.app.controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jae.hyeok.app.models.InfoDaoMybatis;

@Controller
@RequestMapping("/my")
public class MemberController {

	@Autowired
	InfoDaoMybatis dao;
	
	@Autowired
	ServletContext application;
	
	@Autowired
	SimpleDateFormat sdf;
	// String i = sdf.format(System.currentTimeMillis());
	
	@RequestMapping(path="/info", method = RequestMethod.GET)
	public ModelAndView InfoGetHandle(@RequestParam Map param, HttpSession session) {
		ModelAndView mav = new ModelAndView("t_my_info");
		System.out.println("mav->"+mav);
		return mav;		
	}
	
	@RequestMapping(path="/info", method = RequestMethod.POST)
	public ModelAndView InfoPostHandle(@RequestParam Map param,
			@RequestParam(name="profile") MultipartFile upf, HttpServletRequest req, HttpSession session) throws InterruptedException {
		ModelAndView mav = new ModelAndView("t_my_info");
		String id = (String)((Map)session.getAttribute("auth")).get("ID");
		System.out.println(application.getRealPath("/temp"));
		String fname = sdf.format(System.currentTimeMillis());
		String picName = id+"_"+fname; 
		System.out.println("PN"+picName);
		boolean rst = false;
		try {
			File dst = new File(application.getRealPath("/temp"), picName);
			upf.transferTo(dst);
			rst =!rst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("rst", rst);
		return mav;
	}

}
