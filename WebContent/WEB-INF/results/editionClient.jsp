<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="./style.css" />
	<title>Mise à jour des informations d'un client</title>
</head>
<body>
	<form method="get" action="ServletDetailClient">
		<table>
			<tr>
				<td colspan="2"><h3>Affichage du détail d'un client</h3></td>
			</tr>
			<tr>
				<td>Nom : </td>
				<td>${sClient.nom}</td>
			</tr>
			<tr>
				<td>Prenom : </td>
				<td>${sClient.prenom}</td>
			</tr>
			<tr>
				<td>Adresse : </td>
				<td>${sClient.adresse}</td>
				
			</tr>
			<tr>
				<td>Ville : </td>
				<td>${sClient.ville}</td>
			</tr>
			<tr>
				<td>Email : </td>
				<td>${sClient.email}</td>
			</tr>
		</table>
	</form>
</body>
</html>