<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Liste des clients pour un conseiller</title>
	<link type="text/css" rel="stylesheet" href="./style.css" />
</head>
<body>
	<form method="post" action="ServletDetailClient">
		<table>
			<tr>
				<td colspan="2"><h3>Liste des clients pour ce conseiller !</h3></td>
			</tr>

			<c:forEach items="${sListClients}" var="clientEnCours">
					<tr>
						<td><a href="">${clientEnCours.nom}</a></td>
						<td><a href="">${clientEnCours.prenom}</a></td>
						<td><a href="">${clientEnCours.email}</a></td>
					</tr>
			</c:forEach>




			
		</table>
	</form>

</body>
</html>