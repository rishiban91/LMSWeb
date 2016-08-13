package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.BookCopies;

public class BookCopiesDAO extends BaseDAO {

	public BookCopiesDAO(Connection conn) {
		super(conn);
	}

	public List<BookCopies> readAllBooks( int branchId) throws SQLException {
		return read("select * from tbl_book, tbl_book_copies where tbl_book.bookId = tbl_book_copies.bookId and "
				+ "tbl_book_copies.branchId=?", new Object[]{branchId}, false);
	}
		
	@Override
	public List<BookCopies> extractData(ResultSet rs) {
		List<BookCopies> bc = new ArrayList<BookCopies>();
		try {
			while (rs.next()) {
				BookCopies a = new BookCopies();
				a.setBookId(rs.getInt("bookId"));
				a.setTitle(rs.getString("title"));
				a.setCopies(rs.getInt("noOfCopies"));
				System.out.println(rs.getInt("bookId")+" "+rs.getString("title")+ " " + rs.getInt("noOfCopies")  );
				bc.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bc;
	}

	@Override
	public <T> List<T> extractDataFirstLevel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
}
