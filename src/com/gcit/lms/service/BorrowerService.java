package com.gcit.lms.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;

public class BorrowerService {
	public List<Branch> getBranchName(int pageNo) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			return bdao.readAllBranch(pageNo);
		}
		catch (SQLException sqle){
			throw sqle;
		}
		finally {
			conn.close();
		}
	}
	
	public void cardCheck(int cardNo) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO brw = new BorrowerDAO(conn);
			brw.cardCheck(cardNo);
		}
		catch (SQLException sqle){
			throw sqle;
		}
		finally {
			conn.close();
		}
	}
	
//	public List<Book> getBookName(int branch) throws Exception {
//		Connection conn = ConnectionUtil.getConnection();
//		try {
//			BorrowerDAO bdao = new BorrowerDAO(conn);
//			return bdao.viewByBranch(branch);
//		}
//		catch (SQLException sqle){
//			throw sqle;
//		}
//		finally {
//			conn.close();
//		}
//	}
	public boolean checkCard(int cardNo) throws SQLException
	{
	
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			return bdao.cardCheck(cardNo);
		}
		catch (SQLException sqle){
			throw sqle;
		}
		finally {
			conn.close();
		}
	}
	public List<Branch> readAllBranch() throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			return bdao.readAllBranch(1);
		}
		catch (SQLException sqle){
			throw sqle;
		}
		finally {
			conn.close();
		}
	}
	
	public List<Book> listALLBookInBranch(int branchId) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			return bdao.allBooksInBranch(branchId);
		}
		catch (SQLException sqle){
			throw sqle;
		}
		finally {
			conn.close();
		}
	}
	
	public void checkOutBook (Integer bookId, Integer branchId, Integer cardNo ) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			bdao.bookLoan(bookId, branchId, cardNo);
			conn.commit();
	
		}
		catch (SQLException sqle){
			throw sqle;
		}
		finally {
			conn.close();
		}
	}
	
	public void returnBook (Integer bookId, Integer branchId, Integer cardNo ) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			bdao.returnBook(bookId, branchId, cardNo);
			conn.commit();
	
		}
		catch (SQLException sqle){
			throw sqle;
		}
		finally {
			conn.close();
		}
	}
}

