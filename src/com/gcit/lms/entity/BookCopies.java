package com.gcit.lms.entity;

//import org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi.PKCS1v1_5Padding_PrivateOnly;

public class BookCopies {

	private int bookId;
	private int branchId;
	private int copies;
	private String title;

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}



}
