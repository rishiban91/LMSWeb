<%@include file="include.html"%>
<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>

<%@page import="com.gcit.lms.service.BorrowerService"%>

<%
Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
BorrowerService service = new BorrowerService();
List<Branch> branch = new ArrayList<Branch>();
branch = service.readAllBranch();

Book b= new Book();
 	
				//b= service.getBookName();
//List<Book> books = service.getBookCopiesPerBranch(branchId);
%>

<div>

	<table class="table">
		<thead>
			<tr>
				<th style="text-align: center">Branch Name</th>
				<th style="text-align: center">Branch Address</th>
				<th style="text-align: center">Select</th>
			</tr>
		</thead>
		<tbody>
					<% for (Branch br: branch) 
			{ 
				%>
			<tr>
				<td align="center"><%= br.getBranchName() %></td>
				<td align="center"><%= br.getBranchAddress() %></td>
				<td align="center"><a
					href="allbooksinbranch.jsp?branchId=<%= br.getBranchId() %>&cardNo=<%= cardNo %>">Select</a></td>
			</tr>
			<%} %>
		</tbody>

	</table>

</div>



