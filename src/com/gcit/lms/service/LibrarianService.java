/**
 * 
 */
package com.gcit.lms.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
/**
 * @author admin
 *
 */
public class LibrarianService {

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
	
	public void editBranch(Branch branch) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BranchDAO bdao= new BranchDAO(conn);
			bdao.updateBranch(branch);
			conn.commit();
		}
		catch (SQLException sqle){
			conn.rollback();
			sqle.printStackTrace();
		}
		finally {
			conn.close();
		}	
	}
	
	public void addBookCopies (Integer bookCopies, Integer bookId, Integer branchId) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			
			bdao.addCopies(bookCopies, bookId, branchId);
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		
	}
	
	public Branch viewBranchByID(Integer branchID) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			return bdao.readByID(branchID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	public Branch updateBranch(Branch br) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			bdao.updateBranch(br);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	public Integer getBranchCount() throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			return bdao.getBranchCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();

		}
		return null;
	}
	
	public List<Book> getBookCopiesPerBranch(Integer branchId) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		BookDAO bDao = new BookDAO(conn);
		
		try {
			return bDao.getBookCopiesPerBranch(branchId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		return null;
	}
	public List<BookCopies> viewBook( int branchId) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookCopiesDAO adao = new BookCopiesDAO(conn);
			List<BookCopies> copies =adao.readAllBooks( branchId);
			conn.commit();
			return copies;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
}
