package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ImageController {

	@GetMapping(value = "/show_image/{jumin_no}")
	public void showImage(@PathVariable String jumin_no,
			HttpServletResponse response
			) {
		try {
			Connection con = Connector.getConnection();

			String selectSQL = "SELECT picture, picture_content_type FROM student_info " + "WHERE jumin_no=?";

			PreparedStatement ps = con.prepareStatement(selectSQL);
			ps.setString(1, jumin_no);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				byte[] bPicture = rs.getBytes("picture");
				//String picture_content_type = rs.getString("picture_content_type");
				
				response.setContentType("image/jpeg");
				response.getOutputStream().write(bPicture);

				response.getOutputStream().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
