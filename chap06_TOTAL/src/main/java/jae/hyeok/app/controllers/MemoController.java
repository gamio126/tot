package jae.hyeok.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jae.hyeok.app.controllers.ws.LoginUserWsHandler;
import jae.hyeok.app.models.MemoDaoMybatis;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	MemoDaoMybatis dao;
	
	@Autowired
	LoginUserWsHandler luws;
	
	@GetMapping("/home")
	public ModelAndView MyReceiveMemoHomeHandle(HttpSession session, @RequestParam(name = "page", defaultValue="1") int page) {
		ModelAndView mav = new ModelAndView("t_memo_home");
		String id = (String) session.getAttribute("auth_id");
		//List<Map> list = dao.MyReceiveMemo(id);
		Map p = new HashMap();
			p.put("receiver", id);
			p.put("start", (page-1)*8+1);
			p.put("end", page*8);
		List<Map> list = dao.listAll(p);
		int size = dao.ListCount(id);
		int num = size / 8 + (size % 8 != 0 ? 1 : 0);
		mav.addObject("list", list);
		mav.addObject("cnt", size);
		mav.addObject("size", num);
		return mav;
	}
	
	
	@GetMapping("/send")
	public String addGetHanle(Map map) {
		
		return "t_memo_send";
	}

	@PostMapping("/send")
	public String addPost(@RequestParam Map param, Map model, HttpSession session) {
		try {
			param.put("sender", session.getAttribute("auth_id"));
			int r = dao.addNew(param);
			model.put("rst", r);
			String msg = String.format("{\"mode\":\"memo\",\"sender\":\"%s\"}", session.getAttribute("auth_id"));
			luws.sendMessageToUser((String) param.get("receiver"), msg);
		} catch (Exception e) {
			model.put("rst", -1);
		}
		return "t_memo_send";
	}
}
