<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer bookID = Integer.parseInt(request.getParameter("bookId"));
	Book book = null;
	AdminService service = new AdminService();
	book = service.viewBookById(bookID);
%>
<div align="center">
	<h2>Hello Admin!</h2>
	<h3>Are you sure you want to delete?</h3>
	<form action="deleteBook" method="post">
		Enter Book Name: <input type="text" name="bookName"
			value="<%=book.getTitle()%>"><br />

		<script>
    function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          return true;
      else
        return false;
    }
</script>
		<button Onclick="return ConfirmDelete();" type="submit" name="bookId"
			value="<%=book.getBookId()%>">Delete</button>
	</form>
</div>