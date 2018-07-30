package com.mycom.myapp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InfoDataView {
	
	@NotNull
	@Size(min=8, max=8, message="주민번호는 8자리 입니다.")
	private String jumin_no;
	
	@NotNull
	@Size(min=2, message="이름은 2자리 이상 입니다.")
	private String name;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", 
				message="전화번호가 정확하지 않습니다")
	private String tel;  // 010-1234-1245

	public InfoDataView() {
		super();
	}

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
