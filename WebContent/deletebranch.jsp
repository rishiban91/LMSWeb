<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gcit.lms.service.*"%>
<%
	Integer branchID = Integer.parseInt(request.getParameter("branchId"));
	Branch branch = null;
	LibrarianService  service = new LibrarianService();
	branch = service.viewBranchByID(branchID);
%>
<div align="center">
	<h2>Hello Admin!</h2>
	<h3>Are you sure you want to delete?</h3>
	<form action="deleteBranch" method="post">
		Enter Branch Name: <input type="text" name="branchName"
			value="<%=branch.getBranchName()%>"><br />

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
		<button Onclick="return ConfirmDelete();" type="submit" name="branchId"
			value="<%=branch.getBranchId()%>">Delete</button>
	</form>
</div>