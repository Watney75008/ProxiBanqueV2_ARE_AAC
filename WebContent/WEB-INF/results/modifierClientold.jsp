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
	<form method="get" action="ServletModifierClient">
		<table>
			<tr>
				<td colspan="2"><h3>Mise à jour des informations du client</h3></td>
			</tr>
			<tr>
				<td>Nom : </td>
				<td><input type="text" placeholder="${sClient.nom}" name="fnom" /></td>
			</tr>
			<tr>
				<td>Prenom : </td>
				<td><input type="text" placeholder="${sClient.prenom}" name="fprenom" /></td>
			</tr>
			<tr>
				<td>Adresse : </td>
				<td><input type="text" placeholder="${sClient.adresse}" name="fadresse" /></td>
				
			</tr>
			<tr>
				<td>Ville : </td>
				<td><input type="text" placeholder="${sClient.ville}" name="fville" /></td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input type="text" placeholder="${sClient.email}" name="femail" /></td>
			</tr>
			<tr>
				<td colspan="2" align=center><button type="submit"/>Valider<button type="reset"/>Annuler</td>
			</tr>
		</table>
	</form>
</body>
</html>