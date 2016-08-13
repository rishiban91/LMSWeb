<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>

<%@page import="com.gcit.lms.service.LibrarianService"%>
<%@include file="include.html"%>
<%
Integer branchId = Integer.parseInt(request.getParameter("branchId"));
LibrarianService service = new LibrarianService();
Branch branch = service.viewBranchByID(branchId);

 List<BookCopies> bc= new ArrayList<BookCopies>();		 
				bc= service.viewBook( branchId);
List<Book> books = service.getBookCopiesPerBranch(branchId);
%>

<div>

	<table class="table">
		<thead>
			<tr>
				<th style="text-align: center">Branch Name</th>
				<th style="text-align: center">Branch Address</th>
				<th style="text-align: center">Edit</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td align="center"><%= branch.getBranchName() %></td>
				<td align="center"><%= branch.getBranchAddress() %></td>
				<td align="center"><a
					href="editbranch.jsp?branchId=<%= branch.getBranchId() %>">Edit</a></td>
			</tr>

		</tbody>

	</table>

</div>

<div>

	<table class="table">
		<thead>
			<tr>
				<th style="text-align: center">Book Title</th>
				<th style="text-align: center">Existing copies</th>
				<th style="text-align: center">Add Copies</th>
			</tr>
		</thead>
		<tbody>
			<% for (Book b: books) 
			{ 
				%>

			<tr>
				<td align="center"><%= b.getTitle() %></td>
				<td align="center"><%= b.getCopiesPerBranch() %></td>
				<td align="center"><a
					href="bookcopies.jsp?bookId=<%= b.getBookId() %>&branchId=<%=branch.getBranchId() %>">Edit</a></td>

			</tr>
			<% } %>
		</tbody>

	</table>

</div>

