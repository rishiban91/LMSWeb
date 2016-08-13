<%@page import="javafx.scene.control.SplitPane.Divider"%>
<%@include file="include.html"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.service.*"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%
	AdminService service = new AdminService();
	List<Branch> branch = new ArrayList<Branch>();
	branch = service.viewBranch();
%>
<h2>Hello Admin!</h2>
<h3>Below are the list of Branch in LMS.</h3>

</nav>
<div class="input-group">
	<span class="input-group-addon" id="basic-addon1">Go!</span> <input
		type="text" class="form-control" placeholder="Search Branch"
		aria-describedby="basic-addon1" onk>
</div>
<div class="row">
	<div class="col-md-6">
		<table class="table">
			<thead>
				<tr>
					<th>Branch ID</th>
					<th>Branch Name</th>
					<th>Branch Address
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Branch br : branch) {
				%>

				<tr>
					<td><%=br.getBranchId()%></td>
					<td><%=br.getBranchName()%></td>
					<td><%=br.getBranchAddress()%></td>
					<td><button name="Delete" class="btn btn-sm btn-danger"
							data-toggle="modal" data-target="#myModal"
							href='deletebranch.jsp?branchId=<%=br.getBranchId()%>'>Delete</button></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>

<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1"
	role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content"></div>
	</div>
</div>