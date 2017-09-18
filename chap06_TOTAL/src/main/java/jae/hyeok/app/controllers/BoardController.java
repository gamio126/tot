package jae.hyeok.app.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jae.hyeok.app.models.BoardDaoMyBatis;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardDaoMyBatis boardDao;
	// View로 넘길때 데이터를 설정해야된다면,
	// 1. 매개변수로 (Map, Model, ModelMap)을 받아서 거기에 설정하고, 뷰이름만 반환.
	// 2. ModelAndView 객체를 반환
	/*@RequestMapping("/list")
	public ModelAndView boardListHandle() throws SQLException {
		List<Map> li = boardDao.readAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("t_board_list");
		mav.addObject("list", li);
		mav.addObject("cnt", li.size());
		return mav;
	}*/
	// @GetMapping("/add")
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String boardAddGetHandle() {
		return "t_board_add"; 
	}
	// @PostMapping("/add");
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String boardAddPostHandle(@RequestParam Map param, ModelMap map) throws SQLException {
		int b = boardDao.addOne(param);
		/*if (b==1) {
			return "redirect:/board/list";
		}*/
		map.put("r", b);
		return "t_board_add_rst";
	}
	@RequestMapping(path = "/view/{num}")
	public ModelAndView boardAddPostHandle(@PathVariable String num) throws SQLException {
		ModelAndView mav = new ModelAndView("board/view");	// 바로 뷰이름지정
		Map one = boardDao.readOne(num);
		int b = boardDao.CountOne(num);
		one.put("count", b);
		mav.addObject("one", one);
		return mav;
	}
	//==========================
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ModelAndView boardListHandle(@RequestParam(name = "page", defaultValue="1") int page) throws SQLException {
		ModelAndView mav = new ModelAndView("t_board_list");
		Map p = new HashMap();
			p.put("start", (page-1)*10+1);
			p.put("end", page*10);
		List<Map> list = boardDao.ListAll(p);
		int size = boardDao.ListCount();
		int num = size / 10 + (size % 10 != 0 ? 1 : 0);
		mav.addObject("list", list);
		mav.addObject("cnt", size);
		mav.addObject("size", num);
		return mav;
	}
	
	
	
	
	
	
}
