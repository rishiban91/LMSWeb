<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer bookID = Integer.parseInt(request.getParameter("bookId"));
	Book book = null;
	AdminService service = new AdminService();
	List<Publisher> pub= service.viewAllPublisher();
	book = service.viewBookById(bookID);
%>
<div align="center">
	<h2>Hello Admin!</h2>
	<h3>Enter Book Details to Edit</h3>
	<form action="editBook" method="post">
		Enter Book Name: <input type="text" name="bookName"
			value="<%=book.getTitle()%>"><br /> 
			Select Publisher 
			<select	name="pubId">
			<%
				for (Publisher p : pub) {
			%>
			<option value="<%=p.getPublisherId()%>"><%=p.getPublisherName()%>
			</option>
			<%
				}
			%>
		</select></br> </br> 
		<input type="hidden" name="bookId" value="<%=book.getBookId()%>">
		<button type="submit">Edit Book!</button>
	</form>
</div>
