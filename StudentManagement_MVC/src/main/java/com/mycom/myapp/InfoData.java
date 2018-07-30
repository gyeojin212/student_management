package com.mycom.myapp;

import java.sql.Timestamp;

public class InfoData {
	private int seq;
	private String jumin_no;
	private String student_no;
	private String name;
	private String tel;
	private Timestamp created_date;
	
	public InfoData() {
		super();
	}

	public InfoData(int seq, String jumin_no, String student_no, String name, String tel, Timestamp created_date) {
		super();
		this.seq = seq;
		this.jumin_no = jumin_no;
		this.student_no = student_no;
		this.name = name;
		this.tel = tel;
		this.created_date = created_date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
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

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "InfoData [jumin_no=" + jumin_no + ", student_no=" + student_no + ", name=" + name + ", tel=" + tel
				+ ", created_date=" + created_date + "]";
	}
		
}
