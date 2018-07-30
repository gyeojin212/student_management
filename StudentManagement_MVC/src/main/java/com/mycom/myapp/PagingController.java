package com.mycom.myapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sun.management.jmxremote.ConnectorBootstrap.DefaultValues;

@Controller
@SessionAttributes({"al_info_data", "paging_info"})
public class PagingController {

	@GetMapping("/paging_test")
	public String paging_test(
		@RequestParam(value="paging_gubun", required=false, defaultValue="first") 
		              String paging_gubun,
		@RequestParam(value="display_count_per_page", required=false)
		              Integer display_count_per_page, 
		Model model, 
		HttpSession session
			) {

		System.out.println(paging_gubun);
		List<InfoData> al_info_data = new ArrayList<InfoData>();
		PagingInfo pagingInfo = new PagingInfo();
		
		// 로컬 변수 
		int nCurrentPage = 0;
		int nTotalPage = 0;
		int nRecordsPerPage = 5;
		int nTotalRecords = 0;

		if (session.getAttribute("al_info_data") == null) {
			for (int i = 1; i <= 20; i++) {
				InfoData infoData = new InfoData();
				infoData.setJumin_no("jumin_no_" + i);
				infoData.setName("이름_" + i);

				al_info_data.add(infoData);
			}
			
			nTotalRecords = al_info_data.size();
			pagingInfo.setnTotalRecords(nTotalRecords);
			pagingInfo.setnRecordsPerPage(nRecordsPerPage);
			
			model.addAttribute("al_info_data", al_info_data);
		
		} else {
			al_info_data = 
		(List<InfoData>)session.getAttribute("al_info_data");
			
			pagingInfo = 
				(PagingInfo)session.getAttribute("paging_info");
			
			nCurrentPage = pagingInfo.getnCurrentPage();;
			//nTotalPage = pagingInfo.getnTotalPage();
			nRecordsPerPage = pagingInfo.getnRecordsPerPage();
			nTotalRecords = pagingInfo.getnTotalRecords();
			
			System.out.println(pagingInfo);
			
		}
		
		if(display_count_per_page != null) {
			nRecordsPerPage = display_count_per_page;
			nTotalPage = 
					(int) Math.ceil((double) nTotalRecords / 
							(double) nRecordsPerPage);
		} else {
			nRecordsPerPage = pagingInfo.getnRecordsPerPage();
			nTotalPage = 
					(int) Math.ceil((double) nTotalRecords / 
							(double) nRecordsPerPage);
		}

		
		
		switch (paging_gubun) {
		case "first":
			nCurrentPage = 1;
			break;
		case "previous":
			nCurrentPage = nCurrentPage - 1;
			if(nCurrentPage < 1) {
				nCurrentPage = 1;
			}
			break;
		case "next":
			nCurrentPage = nCurrentPage + 1;
			if(nCurrentPage > nTotalPage) {
				nCurrentPage = nTotalPage;
			}
			break;
		case "last":
			nCurrentPage = nTotalPage;
			break;
		}
		
		pagingInfo.setnTotalRecords(nTotalRecords);
		pagingInfo.setnRecordsPerPage(nRecordsPerPage);
		pagingInfo.setnTotalPage(nTotalPage);
		pagingInfo.setnCurrentPage(nCurrentPage);
		
		System.out.println(pagingInfo);
		
		
		int fromIndex = (nCurrentPage - 1) * nRecordsPerPage;
		int toIndex = fromIndex + nRecordsPerPage;
		
		if(toIndex > nTotalRecords) {
			toIndex = nTotalRecords; 
		}
		
		List<InfoData> al_sub_infoData = 
				al_info_data.subList(fromIndex, toIndex);

		model.addAttribute("paging_info", pagingInfo);
		model.addAttribute("al_sub_infoData", al_sub_infoData);
		//model.addAttribute("display_count_per_page", 
		//		nRecordsPerPage);
		
		return "paging_test";
	}
}
