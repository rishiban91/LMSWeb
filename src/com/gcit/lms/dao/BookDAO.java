package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

@SuppressWarnings("unchecked")
public class BookDAO extends BaseDAO {

	public BookDAO(Connection conn) {
		super(conn);
	}

	public void addBook(Book book) throws SQLException {
		save("insert into tbl_book (title, pubId) values (?, ?)", new Object[] {book.getTitle(), book.getPublisher().getPublisherId()});
	}

	public void updateBook(Book book) throws SQLException {
		save("update tbl_book set title = ?, pubId=? where bookId = ?", new Object[] {book.getTitle(), 
				book.getPublisher().getPublisherId(), book.getBookId()});
	}

	public void deleteBook(Book book) throws SQLException{
		save("delete from tbl_book where bookId = ?", new Object[] {book.getBookId()});
	}

	public List<Book> readAllBooks(int pageNo) throws SQLException{
		return read("select * from tbl_book", null, true);
	}

	public List<Book> readAllBooks1() throws SQLException {
		return read("select * from tbl_book", null, false);
	}
	
	public Integer addBookWithId(Book book) throws SQLException {
		return saveWithID("insert into tbl_book (title, pubId) values (?, ?)", new Object[] {book.getTitle(), book.getPublisher().getPublisherId()});
	}
	
	public void addBookAuthor(Book book) throws SQLException {
		
		Integer bookId = addBookWithId(book);
		for(Author a: book.getAuthors()) {
			save("insert into tbl_book_authors (bookId, authorId) values (?, ?)", new Object[] { bookId, a.getAuthorID()});
		}
	}
	
	public Book readById (int bookId) throws Exception {
		List<Book> book= read("select * from tbl_book where bookId=?", new Object[] {bookId}, false);
		if (book!=null) {
			return book.get(0);
		}
		return null;
	}
	
	public List<Book> allBooksInBranch(int branchId) throws SQLException {
		return read("select * from tbl_book where tbl_book.bookId IN (select bookId from tbl_book_copies where branchId=?)"
				, new Object[]{branchId}, false);
	}

	public Integer getBookCount() throws Exception {
		return getCount("select count(*) from tbl_book", null);
	}
	
	@Override
	public List<Book> extractData(ResultSet rs){
		AuthorDAO adao = new AuthorDAO(conn);
		List<Book> books = new ArrayList<Book>();
		try {
			while(rs.next()){
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setTitle(rs.getString("title"));
				b.setAuthors(adao.readFirstLevel(
						"select * from tbl_author where authorId IN (select authorId from tbl_book_authors where bookId = ?)",
						new Object[] { b.getBookId()}));
				//add genres & publisher
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	private List<Book> readAllBooks() throws Exception{
		List<Book> books =  read("select * from tbl_book", null, false);
		return books;
	}

	public List<Book> getBookCopiesPerBranch(Integer branchId) throws Exception {
		List<Book> books = readAllBooks1();
		BranchDAO bdao = new BranchDAO(conn);
		for (Book book : books) {
			book.setCopiesPerBranch(bdao.existingCopies(book.getBookId(), branchId));
		}

		return books;
	}
	

	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) {
		List<Book> books = new ArrayList<Book>();
		try {
			while(rs.next()){
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setTitle(rs.getString("title"));
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

}
