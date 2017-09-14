package jae.hyeok.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MemberController {

	@GetMapping("/info")
	public String InfoHandle() {
		return "t_expr";
	}
}
