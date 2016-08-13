package com.gcit.lms.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;


@SuppressWarnings("unchecked")

public class BorrowerDAO extends BaseDAO {
	
	public BorrowerDAO (Connection conn) {
		super(conn);
	}
	public void addBorrower(Borrower brw) throws SQLException{
		save("insert into tbl_borrower (cardNo, name, address, phone) values (?, ?, ?, ?)", 
				new Object[] {brw.getCardNo(), brw.getName(), brw.getAddress(), brw.getPhone()});
	}

	public void updateBorrower(Borrower brw) throws SQLException {
		save("update tbl_borrower set name = ?, address=?, phone=? where cardNo = ?", 
				new Object[] {brw.getName(), brw.getAddress(), brw.getPhone(), brw.getCardNo()});
	}

	public void deleteBorrower(Borrower brw) throws SQLException {
		save("delete from tbl_borrower where cardNo = ? ", new Object[] {brw.getCardNo()});		
		//System.out.println("here" + brw.getCardNo());
	}

	public List<Borrower> readAllBorrower() throws SQLException {
		return read("select * from tbl_borrower", null, false);
	}
	
	public Borrower readByCardNo(int cardNo) throws Exception {
		List<Borrower> borrowers = read("select * from tbl_borrower where cardNo=?", new Object[] {cardNo}, false);
		if (borrowers!=null) {
			return borrowers.get(0);
		}
		return null;
	}
	

	public boolean cardCheck(int cardNo) throws SQLException {
	List<Borrower> borrowers=read("select * from tbl_borrower where cardNo= ?", new Object[] {cardNo},true);
	
		if (!borrowers.isEmpty())
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public void bookLoan(Integer bookId, Integer branchId, Integer cardNo) throws Exception {
		try {
			save("insert into tbl_book_loans (bookID, branchId, cardNo, dateOut,dueDate, dateIn) "
					+ "values (?, ?, ?, curdate(), curdate()+ interval 7 day, null)", 
					new Object[] {bookId, branchId, cardNo});
		}
		catch (SQLException sqle){
			throw sqle;
		}
		
	}
	
	public void returnBook (Integer bookId, Integer branchId, Integer cardNo) throws Exception {
		try {
			save("insert into tbl_book_loans (bookID, branchId, cardNo, dateOut,dueDate, dateIn) "
					+ "values (?, ?, ?, null, null, curdate())", 
					new Object[] {bookId, branchId, cardNo});
		}
		catch (SQLException sqle){
			throw sqle;
		}
		
	}
	
	public List<Branch> readAllBranch(int pageNo) throws SQLException {
		setPageNo(pageNo);
		return read("select * from tbl_library_branch", null, true);
	} 
	
	private List<Book> viewByBranch(int branchId) throws Exception {
		List<Book> books =  read("select * from tbl_book_copies where branchId=?", new Object[] {branchId} , false);
		return books;
	}
	
	@Override
	public List<Borrower> extractData(ResultSet rs) {
		BookDAO bdao = new BookDAO(conn);
		List<Borrower> brw = new ArrayList<Borrower>();
		try {
			while (rs.next()){
				Borrower bo= new Borrower();
				bo.setCardNo(rs.getInt("cardNo"));
				bo.setName(rs.getString("name"));
				bo.setAddress(rs.getString("address"));
				bo.setPhone(rs.getString("phone"));
				bo.setBook(bdao.readFirstLevel("select * from tbl_book where bookId IN (select bookId from tbl_book_loans where cardNo= ?)", 
						new Object[] {bo.getCardNo()}));
				brw.add(bo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return brw;
	}
	
	@Override
	public  List<Borrower> extractDataFirstLevel(ResultSet rs) {
		List<Borrower> brw = new ArrayList<Borrower>();
		try {
			while (rs.next()){
				Borrower bo= new Borrower();
				bo.setCardNo(rs.getInt("cardNo"));
				bo.setName(rs.getString("name"));
				bo.setAddress(rs.getString("address"));
				bo.setPhone(rs.getString("phone"));
				brw.add(bo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return brw;
	}

}
