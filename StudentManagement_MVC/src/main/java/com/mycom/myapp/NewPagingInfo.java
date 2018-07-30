package com.mycom.myapp;

public class NewPagingInfo {

	private int nCurrentPage;  				
	private int nTotalPage;    			
	private int nRecordsPerPage;		
	private int nTotalRecords;

	public NewPagingInfo() {
		super();
	}

	public int getnCurrentPage() {
		return nCurrentPage;
	}

	public void setnCurrentPage(int nCurrentPage) {
		this.nCurrentPage = nCurrentPage;
	}

	public int getnTotalPage() {
		return nTotalPage;
	}

	public void setnTotalPage(int nTotalPage) {
		this.nTotalPage = nTotalPage;
	}

	public int getnRecordsPerPage() {
		return nRecordsPerPage;
	}

	public void setnRecordsPerPage(int nRecordsPerPage) {
		this.nRecordsPerPage = nRecordsPerPage;
	}

	public int getnTotalRecords() {
		return nTotalRecords;
	}

	public void setnTotalRecords(int nTotalRecords) {
		this.nTotalRecords = nTotalRecords;
	}

	@Override
	public String toString() {
		return "NewPagingInfo [nCurrentPage=" + nCurrentPage + ", nTotalPage=" + nTotalPage + ", nRecordsPerPage="
				+ nRecordsPerPage + ", nTotalRecords=" + nTotalRecords + "]";
	}
}
