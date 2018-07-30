package com.mycom.myapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {
	
	@ResponseBody
	@RequestMapping(value = "/api/is_exist_of_jumin_no", method = RequestMethod.GET, produces = "application/json")
	public boolean IsExistOfjumin_no(String jumin_no) {
		
		System.out.println(jumin_no);
		System.out.println("called");
		
		return true;
	}
}
