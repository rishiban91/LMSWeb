<%@include file="include.html" %>
	<h2>Hello Admin!</h2>
	<h3>Enter Publisher Details</h3>
	<form action="addPublisher" method="post">		
	<div align="center">
		Enter Publisher Name: <input type="text" name="publisherName"><br />
		Enter Publisher Address: <input type="text" name="publisherAddress"><br />
		Enter Publisher Phone: <input type="text" name="publisherPhone"><br/><br/>
		<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal">
				Add Publisher </button></td>
		 </div>
	</form>
	
	
