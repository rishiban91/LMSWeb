<%@include file="include.html"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.service.LibrarianService"%>
<%@ page import="com.gcit.lms.entity.Branch"%>
<%
	LibrarianService service = new LibrarianService();
	Integer count = service.getBranchCount();
	int pageNos = 0;
	Integer pageSize = Integer.valueOf(10);
	if (count % pageSize > 0) {
		pageNos = count / 10 + 1;
	} else {
		pageNos = count / 10;
	}
	List<Branch> branch = new ArrayList<Branch>();
	if (request.getAttribute("branch") != null) {
		branch = (List<Branch>) request.getAttribute("branch");
	} else {
		branch = service.getBranchName(1);
	}
%>

<h2>Hello Librarian!</h2>
<h3>Below are a list of Branches in LMS.</h3>

<div class="input-group">
	<span class="input-group-addon" id="basic-addon1">Go!</span> <input
		type="text" class="form-control" placeholder="Search Library"
		aria-describedby="basic-addon1" >
</div>
<div >
	
		<table class="table">
			<thead>
				<tr>
					<th align="center">Branch Name</th>			
				</tr>
			</thead>
			<tbody>
				<%
					for (Branch b : branch) {
				%>
				<tr>
					<td align="center"><a href="branchDetails.jsp?branchId=<%= b.getBranchId() %>"><%=b.getBranchName() %>
					</a></td>
				</tr>
				<%
					}
				%>
			</tbody>

		</table>
	</div>

<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1"
	role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content"></div>
	</div>
</div>