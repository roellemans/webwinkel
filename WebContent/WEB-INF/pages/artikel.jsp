<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form name="bewerkArtikel" method="Post">
			<table class="table">

				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>ID</td>
					<td style='text-align: left; vertical-align: middle'>${artikel.id}</td>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Naam</td>
					<c:if test="${login == null}">
						<td style='text-align: left; vertical-align: middle'>${artikel.naam}</td>
					</c:if>
					<c:if test="${login != null}">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="naam" value="${artikel.naam}" /></td>
					</c:if>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Prijs</td>
					<c:if test="${login == null}">
						<td style='text-align: left; vertical-align: middle'>${artikel.prijs}</td>
					</c:if>
					<c:if test="${login != null}">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="prijs" value="${artikel.prijs}" /></td>
					</c:if>
				</tr>
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'>Aantal
						in voorraad</td>
					<c:if test="${login == null}">
						<c:if test="${artikel.aantal == 0 }">
							<td style='text-align: left; vertical-align: middle'>Niet op
								voorraad</td>
						</c:if>
						<c:if test="${artikel.aantal != 0}">
							<td style='text-align: left; vertical-align: middle'>Op
								voorraad</td>
						</c:if>
					</c:if>
					<c:if test="${login != null}">
						<td style='text-align: left; vertical-align: middle'><input
							type="text" name="aantal" value="${artikel.aantal}" /></td>
					</c:if>
				</tr>
				<c:if test="${login != null}">
				<tr>
					<td
						style='text-align: left; vertical-align: middle; font-weight: bold'></td>
					<td style='text-align: left; vertical-align: middle'><input
						type="submit" value="Artikel bewerken" /></td>
				</tr>
				</c:if>
			</table>
		</form>
	</div>

</body>
</html>