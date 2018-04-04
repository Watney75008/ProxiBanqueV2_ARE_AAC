<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Liste des clients pour un conseiller</title>
	<link type="text/css" rel="stylesheet" href="./style.css" />
</head>
<body>
	<table>
		<tr>
			<td colspan="2"><h3>Liste des clients pour ce conseiller</h3></td>
		</tr>

		<c:forEach items="${sListClients}" var="clientEnCours">
				<tr>
					<td>${clientEnCours.nom}</td>
					<td>${clientEnCours.prenom}</td>
					<td>${clientEnCours.email}</td>
					<td><a href="ServletDetailClient?idClient=${clientEnCours.idClient}">Consulter</a></td>
	   				<td><a href="modifierClient.html">Modifier</a></td>
					<td><a href="ServletVirementClient?idClient=${clientEnCours.idClient}">Virement(TODO)</a></td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>