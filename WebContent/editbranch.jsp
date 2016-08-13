<%@ page import="com.gcit.lms.entity.Branch"%>
<%@ page import="com.gcit.lms.service.LibrarianService"%>

<%
	Integer branchID = Integer.parseInt(request.getParameter("branchId"));
	Branch branch = null;
	LibrarianService service = new LibrarianService();
	branch = service.viewBranchByID(branchID);
%>
<div>
	<h2>Hello Librarian!</h2>
	<h3>Enter Branch Details to Edit</h3>
	<form action="editBranch" method="post">
		Enter Branch Name: <input type="text" name="branchName"
			value="<%=branch.getBranchName()%>"><br /> 
			Enter Branch Address: <input type="text" name="branchAddress"
			value="<%=branch.getBranchAddress() %>"><br /> <input
			type="hidden" name="branchId" value="<%=branch.getBranchId()%>">
		<button type="submit">Edit Branch!</button>
	</form>
</div>