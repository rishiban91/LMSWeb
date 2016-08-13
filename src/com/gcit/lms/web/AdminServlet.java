package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.service.AdminService;
import com.gcit.lms.service.BorrowerService;
import com.sun.beans.editors.IntegerEditor;

import java.lang.Object;
import java.nio.channels.ScatteringByteChannel;
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet({ "/addAuthor", "/viewAuthors", "/addBook", "/editAuthor", "/deleteAuthor", "/pageAuthors", 
	"/addPublisher", "/addBranch", "/addBorrower", "/pageBooks", "/editBook", "/deleteBook", "/editPublisher", "/deleteBranch",
	"/editBorrower", "/deleteBorrower", "/addGenre", "/editGenre", "/deleteGenre"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "viewauthors.jsp";
		AdminService service = new AdminService();
		switch (reqUrl) {
		case "/editAuthor":
			Integer authorID = Integer.parseInt(request.getParameter("authorId"));
			Author author = null;
			try {
				author = service.viewAuthorByID(authorID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("author", author);
			forwardPage = "editauthor.jsp";
			break;
		case "/pageAuthors":
			Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
			List<Author> authors = new ArrayList<Author>();
			try {
				authors = service.viewAuthors(pageNo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("authors", authors);
			break;
		case "/pageBooks": 
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			List<Book> b = new ArrayList<Book>();
			try {
				b = service.viewBook(pageNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("books", b);
			break;
		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "";
		AdminService service = new AdminService();
		String bookName = null;
		Integer pubId = null;
		Book book  = new Book();
		Publisher pub = new Publisher();
		Author author = new Author();
		List <Author> listAuthor = new ArrayList<Author>();
		List<Book> listBook = new ArrayList<Book>();
		Publisher publisher = new Publisher();
		String publisherName = null;
		String publisherAddress= null;
		Branch branch = new Branch();
		String branchName = null;
		String name = request.getParameter("name");
		String address= request.getParameter("address");
		String phone = request.getParameter("phone");
		Borrower borrower = new Borrower();
		Genre genre = new Genre();
		Integer genre_id = null;
		String genre_name = null;
		switch (reqUrl) {
		case "/addAuthor":

			String authorName = request.getParameter("authorName");
			String[] bookid = request.getParameterValues("bookId");
			System.out.println("check");
			for (String s:bookid)
			{
				book=new Book();
				book.setBookId(Integer.parseInt(s));
				listBook.add(book);
				System.out.println(listBook);
			}
			author = new Author();
			author.setBooks(listBook);
			author.setAuthorName(authorName);
			System.out.println(authorName);
			try {
				service.addAuthor(author);
				forwardPage = "viewauthors.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/editAuthor":
			authorName = request.getParameter("authorName");
			Integer authorID = Integer.parseInt(request.getParameter("authorId"));
			author = new Author();
			author.setAuthorName(authorName);
			author.setAuthorID(authorID);
			try {
				service.editAuthor(author);
				forwardPage = "viewauthors.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/addBook":
			bookName = request.getParameter("title");
			pubId = Integer.parseInt(request.getParameter("pubId"));
			String[] authorID2 = request.getParameterValues("authId");
			for (String s:authorID2)
			{
				Author author2= new Author();
				author2.setAuthorID(Integer.parseInt(s));
				listAuthor.add(author2);
			}
			book.setAuthors(listAuthor);
			pub.setPublisherId(pubId);
			book.setTitle(bookName);
			book.setPublisher(pub);
			try {
				service.addBook(book);
				forwardPage = "admin.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/editBook":
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
			pubId = Integer.parseInt(request.getParameter("pubId"));
			bookName = request.getParameter("bookName");
			book.setBookId(bookId);
			book.setTitle(bookName);
			pub.setPublisherId(pubId);
			book.setPublisher(pub);
			try {
				service.editBook(book);
				forwardPage = "viewbooks2.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleteBook":
			bookId = Integer.parseInt(request.getParameter("bookId"));
			bookName = request.getParameter("bookName");
			book.setBookId(bookId);
			book.setTitle(bookName);
			try {
				service.deleteBook(book);
				forwardPage = "viewbooks.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request.setAttribute("book", book);
			break;
		case "/addPublisher":
			publisherName = request.getParameter("publisherName");
			publisherAddress= request.getParameter("publisherAddress");
			String publisherPhone = request.getParameter("publisherPhone");
			Publisher pub1 = new Publisher();
			pub1.setPublisherName(publisherName);
			pub1.setPublisherAddress(publisherAddress);
			pub1.setPublisherPhone(publisherPhone);
			try {
				service.addPublisher(pub1);
				forwardPage = "viewpublisher.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;	
		case "/editPublisher":
			pubId = Integer.parseInt(request.getParameter("publisherId"));
			publisherName = request.getParameter("publisherName");
			publisherAddress = request.getParameter("publisherAddress");
			publisher = new Publisher();
			publisher.setPublisherId(pubId);
			publisher.setPublisherName(publisherName);
			publisher.setPublisherAddress(publisherAddress);
			try {
				service.editPublisher(publisher);
				forwardPage = "viewbooks2.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request.setAttribute("publisher", publisher);
			break;
		case "/addBranch":
			branchName = request.getParameter("branchName");
			String branchAddress= request.getParameter("branchAddress");
			branch = new Branch();
			branch.setBranchName(branchName);
			branch.setBranchAddress(branchAddress);
			try {
				service.addBranch(branch);
				forwardPage = "admin.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;			
		case "/deleteBranch":
			Integer branchId = Integer.parseInt(request.getParameter("branchId"));
			branchName = request.getParameter("branchName");
			branch = new Branch();
			branch.setBranchId(branchId);
			branch.setBranchName(branchName);
			try {
				service.deleteBranch(branch);
				System.out.println(branch);
				forwardPage = "viewbranch.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request.setAttribute("book", book);
			break;
		case "/addBorrower":
			name = request.getParameter("name");
			address= request.getParameter("address");
			phone = request.getParameter("phone");
			borrower = new Borrower();
			borrower.setName(name);
			borrower.setAddress(address);
			borrower.setPhone(phone);
			try {
				service.addBorrower(borrower);
				forwardPage = "admin.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;	
		default:
			break;
		case "/editBorrower":
			Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
			name = request.getParameter("Name");
			address = request.getParameter("Address");
			phone = request.getParameter("Phone");
			borrower = new Borrower();
			borrower.setCardNo(cardNo);
			borrower.setName(name);
			borrower.setAddress(address);
			borrower.setPhone(phone);
			try {
				service.editBorrower(borrower);

				forwardPage = "viewborrower.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request.setAttribute("publisher", publisher);
			break;
		case "/deleteBorrower": 
			cardNo = Integer.parseInt(request.getParameter("cardNo"));
			name = request.getParameter("Name");
			borrower = new Borrower();
			borrower.setCardNo(cardNo);
			borrower.setName(name);
			try {
				service.deleteBorrower(borrower);
				System.out.println(borrower);
				forwardPage = "viewborrower.jsp";
			} catch (Exception e) {
				System.out.println("in catch");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/addGenre":			
			genre_name = request.getParameter("genreName");
			genre = new Genre();
			genre.setGenreName(genre_name);
			try {
				service.addGenre(genre);
				forwardPage = "admin.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/editGenre":
			genre_name= request.getParameter("genreName");
			genre_id= Integer.parseInt(request.getParameter("genreId"));
			genre = new Genre();
			genre.setGenreId(genre_id);
			genre.setGenreName(genre_name);				
			try {
				service.editGenre(genre);
				forwardPage = "viewgenres.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleteGenre":			
			genre_id = Integer.parseInt(request.getParameter("genreId"));
			genre_name = request.getParameter("genreName");
			genre = new Genre();
			genre.setGenreId(genre_id);
			genre.setGenreName(genre_name);
			try {
				service.deleteGenre(genre);
				forwardPage = "viewgenres.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);

	}

}
