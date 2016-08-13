<%@page import="javafx.scene.control.SplitPane.Divider"%>
<%@include file="include.html"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%
	AdminService service = new AdminService();
	List<Borrower> brw= new ArrayList<Borrower>();
	brw = service.viewBorrower();	
%>
<h2>Hello Admin!</h2>
<h3>Below are the list of Borrowers in LMS.</h3>

<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">Go!</span>
  <input type="text" class="form-control" placeholder="Search Borrower" aria-describedby="basic-addon1" onk>
</div>
<div class="row">
	<div class="col-md-6">
		<table class="table">
			<thead>
				<tr>
					<th>Card No.</th>
					<th>Name</th>
					<th>Address</th>
					<th>Edit </th>
					<th>Delete </th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Borrower b: brw) {
				%>

				<tr>
					<td><%=b.getCardNo()%></td>
					<td><%=b.getName()%></td>
					<td><%=b.getAddress()%></td>
					<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal"
							href='editborrower.jsp?cardNo=<%=b.getCardNo()%>'>Edit</button></td>
					<td><button name="Delete" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#myModal"
							href='deleteborrower.jsp?cardNo=<%=b.getCardNo()%>'>Delete</button></td>
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