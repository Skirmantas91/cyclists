<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rank Page</title>
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
		<div class="table-responsive">
			<caption>Skaičiaus informacija</caption>
			<table class="table table-striped">
				<tr>
					<td><b>Id:</b></td>
					<td>${rank.id}</td>
				</tr>
				<tr>
					<td><b>Vardas:</b></td>
					<td>${rank.name}</td>
				</tr>
				<tr>
					<td><b>Reitingas:</b></td>
					<td>${rank.rank}</td>
				</tr>

			</table>
		</div>
		<br>
		<a type="button" href="/ranks" class="button">Atgal</a>
	</body>


<jsp:include page="footer.jsp"/>
</html>