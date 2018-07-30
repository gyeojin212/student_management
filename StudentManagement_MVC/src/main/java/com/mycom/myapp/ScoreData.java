package com.mycom.myapp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.jboss.logging.Message;
import org.jboss.logging.MessageBundle;

public class ScoreData {
	// 제약조건 : constraint 
	@NotNull
    @Size(min=8,max=8, message="학사번호는 8자리이어야 합니다.")
	private String student_no;
	
	@NotNull
	@Min(0) @Max(100)
	private int guk;
	
	@NotNull
	@Min(0)
	@Max(100)
	private int math;
	
	@NotNull
	@Min(0)
	@Max(100)
	private int sahee;

	public ScoreData() {
		super();
	}

	public ScoreData(String student_no, int guk, int math, int sahee) {
		super();
		this.student_no = student_no;
		this.guk = guk;
		this.math = math;
		this.sahee = sahee;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}

	public int getGuk() {
		return guk;
	}

	public void setGuk(int guk) {
		this.guk = guk;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSahee() {
		return sahee;
	}

	public void setSahee(int sahee) {
		this.sahee = sahee;
	}

	@Override
	public String toString() {
		return "ScoreData [student_no=" + student_no + ", guk=" + guk + ", math=" + math + ", sahee=" + sahee + "]";
	}
}
