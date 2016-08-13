<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
	Borrower brw = null;
	AdminService service = new AdminService();
	brw = service.viewByCardNo(cardNo);
%>
<div align="center">
	<h2>Hello Admin!</h2>
	<h3>Are you sure you want to delete?</h3>
	<form action="deleteBorrower" method="post">
		Enter Name: <input type="text" name="Name" value="<%=brw.getName()%>"><br />
		<script>
			function ConfirmDelete() {
				var x = confirm("Are you sure you want to delete?");
				if (x)
					return true;
				else
					return false;
			}
		</script>
		<button Onclick="return ConfirmDelete();" type="submit" name="cardNo"
			value="<%=brw.getCardNo()%>">Delete</button>
	</form>
</div>