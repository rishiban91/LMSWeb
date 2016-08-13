package com.gcit.lms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.ConnectionUtil;


public class BranchDAO extends BaseDAO {

	public BranchDAO(Connection conn){
		super(conn);
	}
	public void addBranch(Branch br) throws SQLException{
		save ("insert into tbl_library_branch (branchId, branchName, branchAddress) values (?, ?, ?)", 
				new Object[] {br.getBranchId(), br.getBranchName(), br.getBranchAddress()});
	}
	public void deleteBranch(Branch br) throws SQLException{
		save ("delete from tbl_library_branch where branchId=?", new Object[] {br.getBranchId()});
	}
	public void updateBranch(Branch br) throws SQLException{
		save ("update tbl_library_branch set branchName=?, branchAddress=? where branchId=?", 
				new Object[] {br.getBranchName(), br.getBranchAddress(), br.getBranchId()});
	}

	public List<Branch> readAllBranch(int pageNo) throws SQLException {
		//setPageNo(pageNo);
		return read("select * from tbl_library_branch", null, true);
	} 

	public Branch readByID(Integer branchID) throws SQLException {
		setPageNo(1);
		List<Branch> branch = read("select * from tbl_library_branch where branchId = ?", new Object[] {branchID}, true);
		if(branch!=null) {
			return branch.get(0);
		}
		return null;
	}
	
	public Integer existingCopies(Integer bookId, Integer branchId) throws Exception {
		Integer count = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			// Result set get the result of the SQL query
			ps = conn.prepareStatement("select noOfCopies from tbl_book_copies where bookId=? AND branchId = ?");
			int param =1;
			ps.setInt(param++, bookId);
			ps.setInt(param++, branchId);
			rs= ps.executeQuery();
			conn.commit();
			if(rs.next())
				count = rs.getInt("noOfCopies");	
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			//conn.close();
		}
		return count;
	}

	public void addCopies(Integer noOfCopies,Integer bookId,Integer branchId ) throws Exception {

		try
		{
			save("insert into tbl_book_copies  (bookId, branchId,noOfCopies) values(?,?,?)", new Object[]{bookId,branchId,noOfCopies});
			System.out.println("succcess");
		}
		catch (Exception e) {
			save("update tbl_book_copies set noOfCopies=? where bookId=? AND branchId = ?", new Object[]{noOfCopies,bookId,branchId});
		}
	}

	public Integer getBranchCount() throws SQLException {
		return getCount("select count(*) from tbl_library_branch", null);
	}
	@Override
	public List<Branch> extractData(ResultSet rs) {

		List <Branch> branches = new ArrayList <Branch>();

		try {
			BookDAO bdao = new BookDAO(conn);

			while (rs.next()) {
				Branch br = new Branch();
				br.setBranchId(rs.getInt("branchID"));
				br.setBranchName(rs.getString("branchName"));
				br.setBranchAddress(rs.getString("branchAddress"));
				br.setBook(bdao.readFirstLevel("select * from tbl_book where bookId IN (select bookId from tbl_book_loans where branchId=?)",
						new Object[] {br.getBranchId()}));

				branches.add(br);


			} 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branches;
	}
	@Override
	public <T> List<T> extractDataFirstLevel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
}
