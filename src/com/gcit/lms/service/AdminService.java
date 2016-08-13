package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.gcit.lms.entity.*;
import com.gcit.lms.dao.*;

public class AdminService {

	public void addAuthor(Author author) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			adao.addBookAuthor(author);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public List<Author> viewAuthors(int pageNo) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAllAuthors(pageNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}

	public List<Author> viewAuthors() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAllAuthors();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}

	public Author viewAuthorByID(Integer authorID) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readByID(authorID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}

	public void editAuthor(Author author) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			adao.updateAuthor(author);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}

	public Integer getAuthorCount() throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.getAuthorCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();

		}
		return null;
	}

	public void addBook(Book book) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			bdao.addBookAuthor(book);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public List <Book> viewBook(int pageNo) throws Exception{

		Connection conn = ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			return bdao.readAllBooks(pageNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public List <Book> viewBook() throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			return bdao.readAllBooks1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}

	public Book viewBookById(Integer bookId) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			return bdao.readById(bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;

	}

	public Book editBook(Book book) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			bdao.updateBook(book);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public Book deleteBook(Book book) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			bdao.deleteBook(book);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}

	public Integer getBookCount() throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			return bdao.getBookCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}

	public void addPublisher(Publisher pub) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			PublisherDAO pdao = new PublisherDAO(conn);
			pdao.addPublisher(pub);;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public Publisher editPublisher(Publisher pub) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			PublisherDAO pdao = new PublisherDAO(conn);
			pdao.updatePublisher(pub);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public Publisher viewById(Integer pubId) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			PublisherDAO pDao = new PublisherDAO(conn);
			return pDao.viewById(pubId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;

	}
	
	public List <Publisher> viewPublisher() throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			PublisherDAO pDao = new PublisherDAO(conn);
			return pDao.readAllPublisher();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}

	
	public List<Publisher> viewAllPublisher() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			PublisherDAO pdao = new PublisherDAO(conn);
			return pdao.readAllPublisher();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	public void addBranch(Branch br) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			bdao.addBranch(br);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	public List <Branch> viewBranch() throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BranchDAO bDao = new BranchDAO(conn);
			return bDao.readAllBranch(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public void addBorrower(Borrower brw) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			bdao.addBorrower(brw);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public List <Borrower> viewBorrower() throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			return bdao.readAllBorrower();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public Borrower viewByCardNo(Integer cardNo) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO borrowerDAO = new BorrowerDAO(conn);
			return borrowerDAO.readByCardNo(cardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public Borrower editBorrower(Borrower borrower) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			bdao.updateBorrower(borrower);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public void deleteBorrower(Borrower brw) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BorrowerDAO borrowerDAO = new BorrowerDAO(conn);
			borrowerDAO.deleteBorrower(brw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
	

	}
	
	public Branch deleteBranch(Branch branch) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			bdao.deleteBranch(branch);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return null;
	}
	
	public void addGenre(Genre gen) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			GenreDAO gdao = new GenreDAO(conn);
			gdao.addGenre(gen);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public List<Genre> viewAllGenre() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			GenreDAO gdao = new GenreDAO(conn);
			return gdao.readAllGenre();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	public List<Genre> viewGenre() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			GenreDAO gdao = new GenreDAO(conn);
			return gdao.readAllGenre();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	public Genre viewGenreById(Integer genreId) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			GenreDAO gdao = new GenreDAO(conn);
			return gdao.readById(genreId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	public void editGenre(Genre gen) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			GenreDAO gdao = new GenreDAO(conn);
			gdao.updateGenre(gen);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void deleteGenre(Genre gen) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			GenreDAO gdao = new GenreDAO(conn);
			gdao.deleteGenre(gen);
			System.out.println("service "+ gen);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}



}
