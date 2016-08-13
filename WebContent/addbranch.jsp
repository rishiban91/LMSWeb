<%@include file="include.html" %>
	<h2>Hello Admin!</h2>
	<h3>Enter Branch details</h3>
	<form action="addBranch" method="post">		
	<div align="center">
	<p style = "font-size: 129%">
		Enter Branch Name: <input type="text" name="branchName"><br />
		Enter Branch Address: <input type="text" name="branchAddress"><br />
		<td><button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal">
				Add Branch </button></td>
	</p>
		 </div>
	</form>
	