package com.mycom.myapp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InfoDataView {
	
	@NotNull
	@Size(min=8, max=8, message="�ֹι�ȣ�� 8�ڸ� �Դϴ�.")
	private String jumin_no;
	
	@NotNull
	@Size(min=2, message="�̸��� 2�ڸ� �̻� �Դϴ�.")
	private String name;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", 
				message="��ȭ��ȣ�� ��Ȯ���� �ʽ��ϴ�")
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
