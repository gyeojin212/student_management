package com.mycom.myapp;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddController {

	@RequestMapping(value = "/add", 
			method = RequestMethod.GET)
	public String add(Model model) {
		
		// ������ ����
		int value1 = 2;
		int value2 = 3;
		
		model.addAttribute("value1", value1);
		model.addAttribute("value2", value2);
		
		ArrayList<String> al_message = new
				ArrayList<String> ();
		al_message.add("dddd");
		al_message.add("dddd1");
		
		model.addAttribute("s",  al_message);
		
		return "add";  // add.jsp �� �������� �� ǥ��
	}
	
	
	
}
