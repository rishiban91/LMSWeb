<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer pubId = Integer.parseInt(request.getParameter("publisherId"));
	Publisher pub = null;
	AdminService service = new AdminService();
	pub=service.viewById(pubId);
	
%>
<div align="center">
	<h2>Hello Admin!</h2>
	<h3>Enter Book Publisher to Edit</h3>
	<form action="editPublisher" method="post">
		Enter Publisher Name: <input type="text" name="publisherName"
			value="<%=pub.getPublisherName()%>"><br /> 
		Enter Publisher Address: <input type="text" name="publisherAddress"
			value="<%=pub.getPublisherAddress()%>"><br /> 
		<input type="hidden" name="publisherId" value="<%=pub.getPublisherId()%>">
		<button type="submit">Edit Publisher</button>
	</form>
</div>
