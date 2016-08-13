<%@include file="include.html"%>
<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>
<%@page import="com.gcit.lms.service.AdminService"%>

<%
	AdminService service = new AdminService();
	List<Author> author = service.viewAuthors();
	List<Publisher> pub= service.viewAllPublisher();
	List<Genre> gen = service.viewAllGenre();
%>

	<h2>&nbsp;&nbsp;Hello Admin!</h2>
	<h3>&nbsp;&nbsp;Enter Book Details</h3>
	<form action="addBook" method="post">
		&nbsp;&nbsp;Enter Book Name: <input type="text" name="title"><br/><br/>
		
		 <div align="center"> Select Genre  			
		<select name="genId" MULTIPLE>
		<%
		for(Genre g : gen) {
		%>		
		<option><%= g.getGenreName() %> </option>
		<%} %>		
		</select></br></br>		
							Select Publisher 
		<select name= "pubId" >
		<%
		for(Publisher p : pub) {
		%>		
		<option value="<%=p.getPublisherId()%>"><%= p.getPublisherName() %> </option>
		<%} %>		
		</select></br></br>
							Select Authors
		<select  name ="authId" MULTIPLE>
		<%
		for(Author a : author) {
		%>		
		<option value ="<%= a.getAuthorID()%>"> <%= a.getAuthorName() %> </option>
		<%} %>		
		</select>
		</div></br></br>
		
		<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal"
							href='admin.jsp'> &nbsp;&nbsp;Add Book </button></td>

  </form>