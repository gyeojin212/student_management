package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@ModelAttribute("login") Login login,
			HttpSession session,
			Model model
			) {
		
		// 메뉴 선택시에 아래 사항 기술
		session.setAttribute("current_menu", "login");
		model.addAttribute("current_menu", "login");
		
		return "login";
	}
	
	@PostMapping("/login_process")
	public String login_process(
			@Valid @ModelAttribute("login") Login login,
			Errors error,
			HttpSession session,
			Model model
			) {
		
		if(error.hasErrors()) {
			return "login";
		}
		
		String selectSQL = 
"SELECT user_id, password FROM user WHERE user_id=? and password=?";
		try {
			Connector connector = new Connector();
			Connection con = connector.getConnection();
			PreparedStatement ps = con.prepareStatement(selectSQL);
			ps.setString(1, login.getUser_id());
			ps.setString(2, login.getPassword());
			
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				session.setAttribute
					("user_id", login.getUser_id());
				model.addAttribute
				("user_id", login.getUser_id());
				
				return "login_result";
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return "login_result";
	}
}
