
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>LMS Web- Admin page</title>
<link href="http://www.prepbootstrap.com/favicon.ico"
	rel="shortcut icon" type="image/x-icon">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="The layout uses the standard Bootstrap colors to apply to buttons. Additionally, there are ribbon effects applied to each button.">

<link rel="stylesheet" type="text/css"
	href="admintemplate_files/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="admintemplate_files/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="admintemplate_files/all.css">

<link rel="stylesheet" href="admintemplate_files/github.css">

<link rel="stylesheet" type="text/css"
	href="admintemplate_files/Site.css">

<script async="" src="admintemplate_files/analytics.js"></script>
<script type="text/javascript" src="admintemplate_files/jquery-1.js"></script>
</head>
<body>
	<div id="main_navbar_items" class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<p style="font-size: 20px">
			<li class="active"><a href="include.html"
				title="Lms- home page">Home</a></li>
			<li class="active"><a href="librarian.jsp"
				title="Lms- home page">Librarian</a></li>
			<li class="active"><a href="cardcheck.jsp"
				title="Lms- home page">Borrower</a></li>
			</p>
			<!-- 

                    <li class="dropdown ">
                        <a href="http://www.prepbootstrap.com/themes" class="dropdown-toggle" data-toggle="dropdown" title="BootStrap Themes Marketplace"><span class="fa fa-star"></span> PREMIUM THEMES <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="http://www.prepbootstrap.com/themes">All Categories</a></li>
                            <li class="divider"></li>
                                <li><a href="http://www.prepbootstrap.com/theme-category/business-corporate">Business &amp; Corporate</a></li>
                                <li><a href="http://www.prepbootstrap.com/theme-category/landing-page">Landing Page</a></li>
                                <li><a href="http://www.prepbootstrap.com/theme-category/portfolio">Portfolio</a></li>
                                <li><a href="http://www.prepbootstrap.com/theme-category/wordpress">WordPress</a></li>
                                <li><a href="http://www.prepbootstrap.com/theme-category/miscellaneous">Miscellaneous</a></li>
                        </ul>
                    </li>  -->
		</ul>
		<!-- <ul class="nav navbar-nav navbar-right">
                        <li class=""><a href="http://www.prepbootstrap.com/login?returnUrl=%2Faccount">LOGIN</a></li>
                        <li class=""><a href="http://www.prepbootstrap.com/registration">SIGN UP</a></li>
                    <li style="margin: 10px;">
                        <div style="display: inline-block; float: left;">
                            <input id="search_input" style="width: 200px;" placeholder="Search..." class="sui-input" type="text">
                        </div>
                        <div style="display: inline-block; float: left; margin-top: 3px; margin-left: 5px;">
                            <span class="glyphicon glyphicon-filter" style="font-size: 18px;"></span>
                        </div>
                    </li>
                </ul>  -->
	</div>
	</div>
	</div>


	<div class="clearfix" style="margin-top: 50px;">
		<div class="container">
			<div class="row">
				<p style="text-align: center; color: grey; font-size: 35px">
					<i>When one book close another one opens</i>
				</p>
				<h2 style = "color: grey"><i>Hi, Admin! Choose want you want to do</i></h2>


			</div>

			<div id="content1" class="row text-center">
				<div class="col-md-6"> <table> <tr>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='addauthor.jsp'">Add
						Author</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='viewauthorVs.jsp'">View
						Author</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href= 'addbook.jsp'">Add
						Book</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='viewbooks.jsp'">View
						Book</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='addbranch.jsp'">Add
						Branch</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='viewbranch.jsp'">View
						Branch</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='addpublisher.jsp'">Add
						Publisher</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='viewpublisher.jsp'">View
						Publisher</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='addborrower.jsp'">Add
						Borrower</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='viewborrower.jsp'">View
						Borrower</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='addgenre.jsp'">Add 
						Genre</button>
					<button type="button" class="btn btn-info ribbon"
						onclick="javascript:location.href='viewgenres.jsp'">View
						Genre</button> </tr> </table>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4"></div>
		</div>

		<hr>

		<footer>
			<p>© 2016 Company, Inc.</p>
		</footer>

	</div>

</body>
</html>