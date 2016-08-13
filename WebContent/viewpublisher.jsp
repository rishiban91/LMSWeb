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
	List<Publisher> pub= new ArrayList<Publisher>();
	if(request.getAttribute("publisher")!=null){
		pub = (List<Publisher>)request.getAttribute("publishers");
	}
	else {
		pub = service.viewPublisher();	
	}	
%>
<h2>Hello Admin!</h2>
<h3>Below are the list of Publishers in LMS.</h3>

<nav aria-label="Page navigation">
  <ul class="pagination">
  	<%for(int i=1; i<=pageNos;i++){ %>
    <li><a href="pagePublisher?pageNo=<%=i%>"><%=i%></a></li>
    <%} %>
  </ul>
</nav>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">Go!</span>
  <input type="text" class="form-control" placeholder="Search Publisher" aria-describedby="basic-addon1" onk>
</div>
<div class="row">
	<div class="col-md-6">
		<table class="table">
			<thead>
				<tr>
					<th>Publisher ID</th>
					<th>Publisher Name</th>
					<th>Publisher Address</th>
					<th>Edit </th>
					<th>Delete </th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Publisher p: pub) {
				%>

				<tr>
					<td><%=p.getPublisherId()%></td>
					<td><%=p.getPublisherName()%></td>
					<td><%=p.getPublisherAddress()%></td>
					<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal"
							href='editpublisher.jsp?publisherId=<%=p.getPublisherId()%>'>Edit</button></td>
					<td><button name="Delete" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#myModal"
							href='deletepublisher.jsp?publisherId=<%=p.getPublisherId()%>'>Delete</button></td>
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