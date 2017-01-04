<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Artikel Webwinkel Roellemans</title>
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
				<form:form action="${logoutUrl}" method="post">
					<input type="submit" value="Uitloggen" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>
			</ul>
		</div>
		<h1 align="center">Webwinkel Roellemans</h1>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/Webwinkel/Winkel">terug</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<form:form name="bewerkArtikel" method="POST"
			commandName="artikelForm">
			<table class="table">

				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>ID</td>
					<td style='text-align: left; vertical-align: middle'>${artikel.id}</td>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Naam</td>
					<sec:authorize access="hasRole('ROLE_USER')">
						<td style='text-align: left; vertical-align: middle'><label id="${artikel.naam}">${artikel.naam}</label></td>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="naam" value="${artikel.naam}" /></td>
					</sec:authorize>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Prijs</td>
					<sec:authorize access="hasRole('ROLE_USER')">
						<td style='text-align: left; vertical-align: middle'>${artikel.prijs}</td>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="prijs" value="${artikel.prijs}" /></td>
					</sec:authorize>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Aantal
						in voorraad</td>
					<sec:authorize access="hasRole('ROLE_USER')">
						<c:if test="${artikel.aantal == 0 }">
							<td style='text-align: left; vertical-align: middle'>Niet op
								voorraad</td>
						</c:if>
						<c:if test="${artikel.aantal != 0}">
							<td style='text-align: left; vertical-align: middle'>Op
								voorraad</td>
						</c:if>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="aantal" value="${artikel.aantal}" /></td>
					</sec:authorize>
				</tr>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<td
							style='text-align: left; vertical-align: middle; font-weight: bold'></td>
						<td style='text-align: left; vertical-align: middle'><input
							type="submit" value="Artikel bewerken" /></td>
					</tr>
				</sec:authorize>

				<tr>
					<td></td>
					<td><div style="color: red">${bewerking}</div></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>