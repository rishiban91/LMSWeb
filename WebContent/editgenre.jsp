<%@ page import="com.gcit.lms.entity.Genre"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer genreId = Integer.parseInt(request.getParameter("genreId"));
	Genre gen = null;
	AdminService service = new AdminService();
	gen = service.viewGenreById(genreId);
%>
<div>
	<h2>Hello Admin!</h2>
	<h3>Enter Genre Details to Edit</h3>
	<form action="editGenre" method="post">
		Enter Genre Name: <input type="text" name="genreName"
			value="<%=gen.getGenreName()%>"><br /> <input
			type="hidden" name="genreId" value="<%=gen.getGenreId()%>">
		<button type="submit">Edit!</button>
	</form>
</div>