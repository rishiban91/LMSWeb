<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>

<%@page import="com.gcit.lms.service.BorrowerService"%>
<%@include file="include.html"%>
<%
Integer branchId = Integer.parseInt(request.getParameter("branchId"));
Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
BorrowerService service= new BorrowerService();
Book bk = new Book();
List<Book> book = new ArrayList<Book>();
book = service.listALLBookInBranch(branchId);

%>

<div>
	<table class="table">
		<thead>
			<tr>
				<th style="text-align: center">Book Name</th>
					<th style="text-align: center">Check Out</th>					
					<th style="text-align: center">Return Book</th>
			</tr>
		</thead>
		<tbody>
				<% for (Book b: book) 
			{ 
				%>
			<tr>
				<td align="center"><%= b.getTitle() %></td>
				<td align="center"><a href="checkout.jsp?branchId=<%= branchId %>&cardNo=<%= cardNo %>&bookId=<%= b.getBookId() %>"><button type="submit">Check Out</button></a> </td>
				<td align="center"><a href="returnbook.jsp?branchId=<%= branchId %>&cardNo=<%= cardNo %>&bookId=<%= b.getBookId() %>"><button type="submit">Return Book</button></a> </td>
			</tr>
	<% } %>
		</tbody>

	</table>

</div>

