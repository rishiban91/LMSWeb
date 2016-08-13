<%@page import="javafx.scene.control.SplitPane.Divider"%>
<%@include file="include.html"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%
	AdminService service = new AdminService();
	Integer count = service.getAuthorCount();
	int pageNos = 0;
	Integer pageSize = Integer.valueOf(10);
	if(count%pageSize > 0){
		pageNos = count/10 + 1;
	} 
	else {
		pageNos = count/10;		
	}
	List<Book> book = new ArrayList<Book>();
	if(request.getAttribute("authors")!=null){
		book = (List<Book>)request.getAttribute("books");
	}
	else {
		book = service.viewBook(1);	
	}	
%>
<h2>Hello Admin!</h2>
<h3>Successfully updated</h3>
<h4>Below are the list of Book in LMS.</h4>

<nav aria-label="Page navigation">
  <ul class="pagination">
  	<%for(int i=1; i<=pageNos;i++){ %>
    <li><a href="pageBooks?pageNo=<%=i%>"><%=i%></a></li>
    <%} %>
  </ul>
</nav>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">Go!</span>
  <input type="text" class="form-control" placeholder="Search Book" aria-describedby="basic-addon1" onk>
</div>
<div class="row">
	<div class="col-md-6">
		<table class="table">
			<thead>
				<tr>
					<th>Book ID</th>
					<th>Book Name</th>
					<th>Edit Book</th>
					<th>Delete Book</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Book b : book) {
				%>

				<tr>
					<td><%=b.getBookId()%></td>
					<td><%=b.getTitle()%></td>
					<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal"
							href='editbook.jsp?bookId=<%=b.getBookId()%>'>Edit</button></td>
					<td><button name="Delete" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#myModal"
							href='deletebook.jsp?bookId=<%=b.getBookId()%>'>Delete</button></td>
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