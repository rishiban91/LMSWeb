<%@include file="include.html"%>
<%@page import="java.util.*"%>
<%@page import="com.gcit.lms.entity.*"%>

<%@page import="com.gcit.lms.service.BorrowerService"%>

<%
Integer branchId = Integer.parseInt(request.getParameter("branchId"));
Integer bookId = Integer.parseInt(request.getParameter("bookId"));
Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
BorrowerService service = new BorrowerService();
service.checkOutBook(bookId, branchId, cardNo);
%>

