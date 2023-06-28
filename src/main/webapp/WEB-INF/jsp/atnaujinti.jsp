<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Skaičiaus atnaujinimas</title>
		<jsp:include page="header.jsp"/>
		<jsp:include page="menu.jsp"/>
	</head>
	<body class="container">
		<form:form name="rank" action="/atnaujintiRank" method="post">
			<!-- id būtina pateikti formoje, kitaip į back-end nueis null. Todėl darome hidden, kad neredaguotų -->
			<input type="hidden"	name="id"  			value="${rank.id}"><p>
			Vardas:<br>
			<input type="text"   	name="name"  		value="${rank.name}"><p>
			Reitingas:<br>
			<input type="number" 		name="rank"  	value="${rank.rank}"><p>
			<input type="submit" value="Atnaujinti">
		</form:form>
	</body>
	<jsp:include page="footer.jsp"/>
</html>
