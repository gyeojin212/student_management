package com.mycom.myapp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/my_map")
	public String my_map(
			HttpSession session,
			Model model
			) {
		
		session.setAttribute("current_menu", "my_map");
		model.addAttribute("current_menu", "my_map");
		
		return "my_map";
	}
}
