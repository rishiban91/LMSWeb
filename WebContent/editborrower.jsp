<%@ page import="com.gcit.lms.entity.Borrower"%>
<%@ page import="com.gcit.lms.service.AdminService"%>

<%
	Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
	Borrower brw = null;
	AdminService service = new AdminService();
	brw = service.viewByCardNo(cardNo);
%>
<div>
	<h2>Hello Librarian!</h2>
	<h3>Enter Borrower Details to Edit</h3>
	<form action="editBorrower" method="post">
		Enter Name: <input type="text" name="Name"
			value="<%=brw.getName()%>"><br /> 
			Enter Address: <input type="text" name="Address"
			value="<%=brw.getAddress() %>"><br /> 
			Enter Phone number: <input type="text" name="Phone"
			value="<%=brw.getPhone() %>"><br/> 
			<input type="hidden" name="cardNo" value="<%=brw.getCardNo()%>">
		<button type="submit">Edit </button>
	</form>
</div>