package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@SessionAttributes({"al_infoData", "paging_info"})
public class InfoController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String info_input(Model model, @ModelAttribute("infoDataView") InfoDataView infoDataView) {

		return "info_input";
	}

	@RequestMapping(value = "/info_input_process", method = RequestMethod.POST)
	public String info_input_process(Model model, @RequestParam("picture") MultipartFile picture,
			@Valid @ModelAttribute("infoDataView") InfoDataView infoDataView, Errors errors) {

		if (errors.hasErrors()) { // 유효성 검사에서 Fail
			return "info_input";
		}

		String insertSQL = "INSERT INTO student_info"
				+ "(jumin_no, name, picture, picture_content_type, tel, created_date) " + "VALUES(?,?,?,?,?,?)";

		try {
			Connection con = Connector.getConnection();
			PreparedStatement ps = con.prepareStatement(insertSQL);

			ps.setString(1, infoDataView.getJumin_no());
			ps.setString(2, infoDataView.getName());

			InputStream is = picture.getInputStream();
			ps.setBlob(3, is);

			ps.setString(4, picture.getContentType());

			ps.setString(5, infoDataView.getTel());

			java.sql.Timestamp currentDateTime = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

			ps.setTimestamp(6, currentDateTime);

			if (1 == ps.executeUpdate()) {
				System.out.println("정상 등록");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("infoDataView", infoDataView);

		return "info_input_result";
	}

	// 학생정보 전체 조회
	@GetMapping("info_all_dis")
	public String info_all_dis(@RequestParam(value = "paging_gubun", defaultValue = "first") String pagingGubun,
			@RequestParam(value = "records_per_page", required=false) Integer nRecordsPerPage, Model model, HttpSession session) {
		List<InfoData> al_infoData = new ArrayList<InfoData>();
		PagingInfo pagingInfo = new PagingInfo();

		if (session.getAttribute("al_infoData") != null) {
			al_infoData = (List<InfoData>) session.getAttribute("al_infoData");

			pagingInfo = (PagingInfo) session.getAttribute("paging_info");
			if (nRecordsPerPage == null) {
				nRecordsPerPage = pagingInfo.getnRecordsPerPage();
			}
		} else {
			// 처음 표시 건수 = 5
			nRecordsPerPage = 5;
			Connection con = Connector.getConnection();

			String countSQL = "SELECT count(jumin_no) as totalCounts FROM student_info";

			String selectSQL = "SELECT jumin_no, student_no, name, tel, created_date "
					+ "FROM student_info ORDER BY created_date desc";

			try {
				PreparedStatement ps = con.prepareStatement(countSQL);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					pagingInfo.setnTotalRecords(rs.getInt("totalCounts"));
				}

				ps = con.prepareStatement(selectSQL);
				rs = ps.executeQuery();

				while (rs.next()) {
					InfoData infoData = new InfoData();
					infoData.setJumin_no(rs.getString("jumin_no"));
					infoData.setStudent_no(rs.getString("student_no"));
					infoData.setName(rs.getString("name"));
					infoData.setTel(rs.getString("tel"));
					infoData.setCreated_date(rs.getTimestamp("created_date"));

					al_infoData.add(infoData);
				}

				model.addAttribute("al_infoData", al_infoData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int nTotalPage = (int) Math.ceil((double) pagingInfo.getnTotalRecords() / (double) (nRecordsPerPage));

		pagingInfo.setnRecordsPerPage(nRecordsPerPage);
		pagingInfo.setnTotalPage(nTotalPage);
		int nCurrentPage = pagingInfo.getnCurrentPage();

		switch (pagingGubun) {
		case "first":
			nCurrentPage = 1;
			break;
		case "previous":
			nCurrentPage = nCurrentPage > 1 ? --nCurrentPage : 1;
			break;
		case "next":
			nCurrentPage = nCurrentPage < nTotalPage ? ++nCurrentPage : nTotalPage;
			break;
		case "last":
			nCurrentPage = pagingInfo.getnTotalPage();
			break;
		}

		pagingInfo.setnCurrentPage(nCurrentPage);

		int fromIndex = (nCurrentPage - 1) * nRecordsPerPage;
		int toIndex = fromIndex + nRecordsPerPage;

		if (toIndex >= pagingInfo.getnTotalRecords()) {
			toIndex = pagingInfo.getnTotalRecords();
		}

		List<InfoData> al_sub_infoData = al_infoData.subList(fromIndex, toIndex);

		model.addAttribute("al_sub_infoData", al_sub_infoData);
		model.addAttribute("paging_info", pagingInfo);

		model.addAttribute("current_page", pagingInfo.getnCurrentPage());
		model.addAttribute("total_page", pagingInfo.getnTotalPage());
		model.addAttribute("records_per_page", nRecordsPerPage);

		return "info_all_dis";
	}

}
