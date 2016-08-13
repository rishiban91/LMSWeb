<%@page import="javafx.scene.control.SplitPane.Divider"%>
<%@include file="include.html"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%
	AdminService service = new AdminService();
	
	List<Genre> gen = new ArrayList<Genre>();
		gen = service.viewGenre();	
%>
<h2>Hello Admin!</h2>
<h3>Below are the list of Genres in LMS.</h3>


<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">Go!</span>
  <input type="text" class="form-control" placeholder="Search Genre" aria-describedby="basic-addon1" onk>
</div>
<div class="row">
	<div class="col-md-6">
		<table class="table">
			<thead>
				<tr>
					<th>Genre ID</th>
					<th>genre Name</th>
					<th>Edit </th>
					<th>Delete </th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Genre g: gen) {
				%>

				<tr>
					<td><%=g.getGenreId()%></td>
					<td><%=g.getGenreName()%></td>
					<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal"
							href='editgenre.jsp?genreId=<%=g.getGenreId()%>'>Edit</button></td>
					<td><button name="Delete" class="btn btn-sm btn-danger"
							onclick="javascript:location.href='deletegenre.jsp?genreId=<%=g.getGenreId()%>'">Delete</button></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>

<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">

    </div>
  </div>
</div>