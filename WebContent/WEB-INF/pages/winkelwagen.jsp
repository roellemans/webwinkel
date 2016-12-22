<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="nl.centric.webwinkel.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Webwinkel Roellemans</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="page-header">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<sec:authentication property="name" />
				<br />
				<c:url var="logoutUrl" value="/logout" />
				<form action="${logoutUrl}" method="post">
					<input type="submit" value="Uitloggen" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</ul>
		</div>
		<h1 align="center">Webwinkel Roellemans, uw winkelwagen</h1>
	</div>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/Webwinkel/Winkel">terug naar winkel</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Aantal
						stuks</td>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>ID</td>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Naam</td>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Prijs</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="artikelen" items="${winkelwagen.artikelen}">
					<tr>
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="aantalStuks" value="1" /></td>
						<td style='text-align: left; vertical-align: middle'>${artikelen.id}</td>
						<td style='text-align: left; vertical-align: middle'>${artikelen.naam}</td>
						<td style='text-align: left; vertical-align: middle'>${artikelen.prijs}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>