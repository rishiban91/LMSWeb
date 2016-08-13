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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.LibrarianService;
/**
 * Servlet implementation class LibrarianServlet
 */
@WebServlet({"/editBranch", "/display_branches", "/addCopies"})
public class LibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrarianService service = new LibrarianService();

		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "display_branches.jsp";

		switch (reqUrl) {
			
		case "/addCopies":
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
			Integer branchId = Integer.parseInt(request.getParameter("branchId"));
			Integer copies = Integer.parseInt(request.getParameter("copies"));
			System.out.println("y");
			Book book = new Book();
			//book.setAddCopies(copies);
			Integer addCopies = 0;
			try {
				//service. addBookCopies(copies);
				service.addBookCopies(copies,bookId,branchId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("addCopies", addCopies);
			//forwardPage = "editbranch.jsp";
			break;
		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}

	private void editBranch(HttpServletRequest request, LibrarianService service) {
		Integer branchID = Integer.parseInt(request.getParameter("branchId"));
		String branchName = request.getParameter("branchName");
		String branchAddress = request.getParameter("branchAddress");
		Branch b = new Branch();
		b.setBranchId(branchID);
		b.setBranchName(branchName);
		b.setBranchAddress(branchAddress);

		List<Branch> branch = new ArrayList<>();

		try {
			service.editBranch(b);
			branch = service.getBranchName(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("branch", branch);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibrarianService service = new LibrarianService();

		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "librarian.jsp";

		switch (reqUrl) {
		
		case "/editBranch":
			editBranch(request, service);
			break;
		
		case "/addCopies":
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
			Integer branchId = Integer.parseInt(request.getParameter("branchId"));
			Integer copies = Integer.parseInt(request.getParameter("copies"));			
			Book book = new Book();		
			Integer addCopies = 0;
			
			try {
				service.addBookCopies(copies,bookId,branchId);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}
	}


