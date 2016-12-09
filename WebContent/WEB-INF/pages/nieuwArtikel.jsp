<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<c:if test="${login == null}">
			<div class="container-fluid">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/Webwinkel/Login">Inloggen</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${login != null}">
			<div class="container-fluid">
				<ul class="nav navbar-nav navbar-right">
					<li><label>${login.gebruikersnaam}</label><a href="/Webwinkel/Logout">Uitloggen</a></li>
				</ul>
			</div>
		</c:if>
		<h1>Webwinkel Roellemans</h1>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/Webwinkel/Winkel">terug</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<form:form modelAttribute="artikel" name="nieuwArtikel" method="Post">
			<table class="table">
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Naam</td>
					<c:if test="${login == null || login.gebruikersnaam != 'Admin'}">
						<td style='text-align: left; vertical-align: middle'>${artikel.naam}</td>
					</c:if>
					<c:if test="${login.gebruikersnaam == 'Admin'}">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="naam" /></td>
					</c:if>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Prijs</td>
					<c:if test="${login == null || login.gebruikersnaam != 'Admin'}">
						<td style='text-align: left; vertical-align: middle'>${artikel.prijs}</td>
					</c:if>
					<c:if test="${login.gebruikersnaam == 'Admin'}">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="prijs" /></td>
					</c:if>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Aantal
						in voorraad</td>
					<c:if test="${login == null || login.gebruikersnaam != 'Admin'}">
						<c:if test="${artikel.aantal == 0 }">
							<td style='text-align: left; vertical-align: middle'>Niet op
								voorraad</td>
						</c:if>
						<c:if test="${artikel.aantal != 0}">
							<td style='text-align: left; vertical-align: middle'>Op
								voorraad</td>
						</c:if>
					</c:if>
					<c:if test="${login.gebruikersnaam == 'Admin'}">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="aantal" /></td>
					</c:if>
				</tr>
				<c:if test="${login.gebruikersnaam == 'Admin'}">
					<tr>
						<td
							style='text-align: left; vertical-align: middle; font-weight: bold'></td>
						<td style='text-align: left; vertical-align: middle'><input
							type="submit" value="Artikel toevoegen" /></td>
					</tr>
				</c:if>
			</table>
		</form:form>
	</div>

</body>
</html>