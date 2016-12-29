<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Inlogpagina</title>
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
		<h1>Inlogpagina Webwinkel Roellemans</h1>
	</div>
	<form:form action="j_spring_security_check" name="submitForm"
		method="POST">
		<div align="center">
			<table>
				<tr>
					<td>Gebruikersnaam</td>
					<td><input type="text" name="j_username" /></td>
				</tr>
				<tr>
					<td>Wachtwoord</td>
					<td><input type="password" name="j_password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
				<tr>
					<td></td>
					<td><a href="/Webwinkel/Registreer">Registreren</a></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>
		</div>
	</form:form>
</body>
</html>
