<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>

<%@page import="com.gcit.lms.service.LibrarianService"%>
<%@include file="include.html"%>

<%
//System.out.println(request.getParameter("addCopies"));
Integer bookId = Integer.parseInt(request.getParameter("bookId"));
Integer branchId = Integer.parseInt(request.getParameter("branchId"));

Book book =new Book();
LibrarianService service= new LibrarianService();
//out.println(book.getBookId()+ " yo");
//service.addBookCopies(copies);ln()
%>

<div>
	<form action="addCopies" method="post">
		Enter no.of.copies: <input type="number" name="copies"
			><br /> <input
			type="hidden" name="bookId" value="<%=bookId%>">
			<input
			type="hidden" name="branchId" value="<%=branchId%>">
		<button type="submit">Add Copy!</button>
	</form>
</div>