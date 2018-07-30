package com.mycom.myapp;

public class PagingInfo {
	private int nCurrentPage;  				
	private int nTotalPage;    			
	private int nRecordsPerPage;		
	private int nTotalRecords;           
	
	public PagingInfo() {
		super();
		nCurrentPage = 0;
	}

	public PagingInfo(int nCurrentPage, int nTotalPage, int nRecordsPerPage, int nTotalRecords) {
		super();
		this.nCurrentPage = nCurrentPage;
		this.nTotalPage = nTotalPage;
		this.nRecordsPerPage = nRecordsPerPage;
		this.nTotalRecords = nTotalRecords;
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
		return "PagingInfo [nCurrentPage=" + nCurrentPage + ", nTotalPage=" + nTotalPage + ", nRecordsPerPage="
				+ nRecordsPerPage + ", nTotalRecords=" + nTotalRecords + "]";
	}
}
