<%@include file="include.html" %>
	<h2>Hello Admin!</h2>
	<h3>Enter Borrower details</h3>
	<form action="addBorrower" method="post">		
	<div align="center">
		<p style = "font-size: 129%">
			Enter Borrower Name: <input type="text" name="name"><br />
			Enter Borrower Address: <input type="text" name="address"><br />
			Enter Borrower Phone: <input type="text" name="phone"><br />
			<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal"> 
			                                                 Add Borrower </button></td>
		</p>
	</div>
	</form>