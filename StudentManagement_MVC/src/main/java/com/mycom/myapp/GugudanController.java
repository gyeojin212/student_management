package com.mycom.myapp;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GugudanController {

	@RequestMapping(value = "/gugudan", 
			method = RequestMethod.GET)
	public String add(Model model) {
		
		int nDan = 3;
		
		ArrayList<String> al_gugudan = new
				ArrayList<String> ();
		
		for(int i=1; i<=9; i++) {
			String s = MessageFormat.format("{0} ¡¿ {1} = {2}",
					nDan, i, nDan * i);
			al_gugudan.add(s);
		}
		
		model.addAttribute("gugudan",  al_gugudan);
		
		return "gugudan";  
	}
}
