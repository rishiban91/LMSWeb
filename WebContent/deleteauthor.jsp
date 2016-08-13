<%@include file="include.html"%>
<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>

<%@page import="com.gcit.lms.service.AdminService"%>

<%
Integer branchId = Integer.parseInt(request.getParameter("branchId"));
Integer bookId = Integer.parseInt(request.getParameter("bookId"));
Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
AdminService service = new AdminService();
//service.checkOutBook(bookId, branchId, cardNo);
%>
