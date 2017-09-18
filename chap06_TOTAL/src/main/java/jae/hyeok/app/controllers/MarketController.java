package jae.hyeok.app.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jae.hyeok.app.models.MarketDaoMyBatis;

@Controller
@RequestMapping("/market")
public class MarketController {

	@Autowired
	MarketDaoMyBatis dao;
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addGetHandle() {
		return "market_add";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addPostHandle(@RequestParam Map param, ModelMap map) {
		int b = dao.addArticle(param);
		
		map.put("r", b);
		return "market_add_rst";
	}
	
/*	@RequestMapping("/list")
	public ModelAndView ListHandle(HttpSession session)  {
		List<Map> li = dao.allArticle();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("market_list");
		String id = (String) ((Map) session.getAttribute("auth")).get("ID");
		mav.addObject("id", id);
		mav.addObject("list", li);
		mav.addObject("cnt", li.size());
		return mav;
	}*/
	
	@RequestMapping(path = "/view/{num}")
	public ModelAndView boardAddPostHandle(@PathVariable int num, HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView("market_view");	// 바로 뷰이름지정
		Map one = dao.readArticle(num);
		String id = (String) ((Map) session.getAttribute("auth")).get("ID");
		mav.addObject("id", id);
		mav.addObject("one", one);
	
		return mav;
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public ModelAndView searchHandle(@RequestParam Map param, HttpSession session){
		System.out.println(param);
		ModelAndView mav = new ModelAndView("market_list");
		String id = (String) ((Map) session.getAttribute("auth")).get("ID");
		mav.addObject("id", id);
		mav.addObject("cnt", dao.searchArticle(param).size());
		mav.addObject("list", dao.searchArticle(param));
		return mav;
	}
	
	
	
	//==========================
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ModelAndView boardListHandle
	(@RequestParam(name = "page", defaultValue="1") int page,HttpSession session) throws SQLException {
		String id = (String) ((Map) session.getAttribute("auth")).get("ID");
		ModelAndView mav = new ModelAndView("market_list");
		Map p = new HashMap();
			p.put("start", (page-1)*10+1);
			p.put("end", page*10);
		List<Map> list = dao.ListAll(p);
		int size = dao.ListCount();
		int num = size / 10 + (size % 10 != 0 ? 1 : 0);
		mav.addObject("id", id);
		mav.addObject("list", list);
		mav.addObject("cnt", size);
		mav.addObject("size", num);
		return mav;
	}
	
	
}
