<%@include file="include.html" %>
<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>
<%@page import="com.gcit.lms.service.AdminService"%>

<%
	AdminService service = new AdminService();
	List<Book> book = service.viewBook();
%>

	<h2>Hello Admin!</h2>
	<h3>Enter Author Details</h3>
	<form action="addAuthor" method="post">
		Enter Author Name: <input type="text" name="authorName"><br />
		<div align="center"> Select Book  			
		<select  name ="bookId" MULTIPLE>
		<%
		for(Book b : book) {
		%>		
		<option value ="<%= b.getBookId()%>"> <%= b.getTitle() %> </option>
		<%} %>		
		</select></br></br>		
		</div>
		<button type="submit">Add Author!</button>
	</form>
