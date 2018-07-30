package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.KeyStore.ProtectionParameter;
import java.sql.*;

import javax.validation.Valid;

@Controller
public class ScoreController {

	@RequestMapping(value = "/score_input", method = RequestMethod.GET)
	public String score_input(Model model, @ModelAttribute("scoreData") ScoreData scoreData) {

		return "score_input";
	}

	@RequestMapping(value = "/score_input_process", method = RequestMethod.POST)
	public String score_input_process(Model model, @Valid @ModelAttribute("scoreData") ScoreData scoreData,
			Errors errors) {

		if (errors.hasErrors()) {
			return "score_input";
		}

		// 데이터 유효하니까 DB에 Insert
		String insertSQL = 
"INSERT INTO student_score(student_no, guk, math, sahee) VALUES(?,?,?,?)";
		
		try {
			Connection con = Connector.getConnection();
			PreparedStatement ps = con.prepareStatement(insertSQL);
			ps.setString(1, scoreData.getStudent_no());
			ps.setInt(2, scoreData.getGuk());
			ps.setInt(3, scoreData.getMath());
			ps.setInt(4, scoreData.getSahee());
			
			if(1 == ps.executeUpdate()) {
				System.out.println("정상 등록");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("scoreData", scoreData);
		return "score_input_result";
	}
}
