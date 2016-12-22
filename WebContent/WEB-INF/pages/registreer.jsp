<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registreren</title>
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
	<div class="jumbotron text-center">
		<h1 align="center">Registreren bij Webwinkel Roellemans</h1>
	</div>

	<form:form name="registreerForm" method="POST" commandName="userForm">
		<div align="center">
			<table>
				<tr>
					<td>Gebruikersnaam</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Wachtwoord</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Registreer" onclick="controleer(registreerForm)"/></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>
		</div>
	</form:form>
</body>
</html>
