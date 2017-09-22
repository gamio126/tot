package jae.hyeok.app.controllers;

import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/apic")
public class APIParkController {

	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping("/park")
	public ModelAndView parkListHandle() {
		ModelAndView mav = new ModelAndView("t_api_park");
		RestTemplate rt = new RestTemplate();
		String str = rt.getForObject(
				"http://openapi.seoul.go.kr:8088/6f66654142746530383254796c4859/json/GetParkInfo/1/1000", String.class);
		try {
			Map obj = mapper.readValue(str, Map.class);
			Map info = (Map)obj.get("GetParkInfo");
			mav.addObject("data", info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
