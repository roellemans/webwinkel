<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
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
		<h1 align="center">Webwinkel Roellemans voor al uw sportartikelen</h1>
	</div>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/Webwinkel/Winkelwagen">Winkelwagen</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>ID</td>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Naam</td>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Prijs</td>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Naar
						winkelwagen</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="voorraad" items="${magazijn.voorraad}">
					<form name="artikelRij" method="Post">
					<tr>
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="id" value="${voorraad.id}" /></td>
						<td style='text-align: left; vertical-align: middle'>${voorraad.naam}</td>
						<td style='text-align: left; vertical-align: middle'>${voorraad.prijs}</td>
						<c:if test="${voorraad.aantal > 0}">
							<td style='text-align: left; vertical-align: middle'><input
								type="submit" value="+" /></td>
						</c:if>
						<c:if test="${voorraad.aantal < 1}">
							<td style='text-align: left; vertical-align: middle'>Niet op
								voorraad</td>
						</c:if>
					</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>