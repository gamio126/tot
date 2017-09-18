package jae.hyeok.app.controllers;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public ModelAndView InfoGetHandle(@RequestParam Map param, HttpSession session) {
		ModelAndView mav = new ModelAndView("t_my_info");
		String id = (String) ((Map) session.getAttribute("auth")).get("ID");
		Map prof = dao.representPic(id);
		mav.addObject("prof", prof);
		System.out.println("mav->" + mav);
		return mav;
	}

	@RequestMapping(path = "/info", method = RequestMethod.POST)
	public ModelAndView InfoPostHandle(@RequestParam Map param, @RequestParam(name = "profile") MultipartFile mpf,
			HttpServletRequest req, HttpSession session) throws InterruptedException {
		ModelAndView mav = new ModelAndView("redirect:/my/info");
		String id = (String) ((Map) session.getAttribute("auth")).get("ID");
		System.out.println(application.getRealPath("/temp"));
		String fname = sdf.format(System.currentTimeMillis());
		String picName = id + "_" + fname;
		System.out.println("PN" + picName);
		boolean rst = false;
		try {
			File dst = new File(application.getRealPath("/temp"), picName);
			mpf.transferTo(dst);
			rst = !rst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rst) {
			Map data = new HashMap<>();
			data.put("id", id);
			data.put("url", "/temp/" + picName);
			dao.addPic(data);
		}
		mav.addObject("rst", rst);
		return mav;
	}

	@RequestMapping(path = "/history", method = RequestMethod.POST)
	public ModelAndView InfoHistoryGetHandle(@RequestParam Map param, HttpSession session) {
		ModelAndView mav = new ModelAndView("t_my_infoHistory");
		String id = (String) ((Map) session.getAttribute("auth")).get("ID");
		List<Map> list = dao.picHistory(id);
		mav.addObject("list", list);
		System.out.println("mav->" + mav);
		return mav;
	}

	@RequestMapping(path = "/allMember2", method = RequestMethod.GET)
	public ModelAndView boardListHandle(@RequestParam(name = "page", defaultValue="1") int page) throws SQLException {
		ModelAndView mav = new ModelAndView("t_my_list");
		Map p = new HashMap();
			p.put("start", (page-1)*6+1);
			p.put("end", page*6);
		List<Map> list = dao.allMember2(p);
		int size = dao.countMember();
		mav.addObject("list", list);
		mav.addObject("cnt", size);
		int num = size / 6 + (size % 6 != 0 ? 1 : 0);
		mav.addObject("size", num);
		return mav;
	}

	
}

