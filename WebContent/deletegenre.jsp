<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer genreId = Integer.parseInt(request.getParameter("genreId"));
	Genre gen = null;
	AdminService service = new AdminService();
	gen = service.viewGenreById(genreId);
%>
<div align="center">
	<h2>Hello Admin!</h2>
	<h3>Are you sure you want to delete?</h3>
	<form action="deleteGenre" method="post">
		Enter Name: <input type="text" name="genreName"
			value="<%=gen.getGenreName()%>"><br />

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
		<button Onclick="return ConfirmDelete();" type="submit" name="genreId"
			value="<%=gen.getGenreId()%>">Delete</button>
	</form>
</div>