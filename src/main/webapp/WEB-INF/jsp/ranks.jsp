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
        <table class="table table-striped">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>rank</th>
                <th>Veiksmas</th>
            </tr>

            <!-- iteruoja per visą rank sarašą -->
            <c:forEach var="laikinaskintamasis" items="${ranks}">

                <!-- konstruoja įrašo atnaujinimo adresą su rank id -->
                <c:url var="atnaujinti" value="/atnaujinti">
                    <c:param name="id" value="${laikinaskintamasis.id}"/>
                </c:url>

                <!-- konstruoja įrašo trynimo adresą su rank id -->
                <c:url var="trinti" value="/trinti">
                    <c:param name="id" value="${laikinaskintamasis.id}"/>
                </c:url>

                <!-- konstruoja įrašo peržiūros adresą su rank id -->
                <c:url var="rodyti" value="/rodyti">
                    <c:param name="id" value="${laikinaskintamasis.id}"/>
                </c:url>

                <tr>
                    <td>${laikinaskintamasis.id}</td>
                    <td>${laikinaskintamasis.name}</td>
                    <td>${laikinaskintamasis.rank}</td>

                    <td>
                        <!-- atvaizduoti atnaujinimo adresą --> <a href="${atnaujinti}">Keisti</a>
                        | <a href="${trinti}"
                             onclick="if (!(confirm('Ar tikrai norite ištrinti šį įrašą?'))) return false">Trinti</a>
                        | <!-- atvaizduoti rodymo adresą --> <a href="${rodyti}">Rodyti</a>
                    </td>

                </tr>

            </c:forEach>

        </table>
    </div>
    <jsp:include page="footer.jsp"/>
</body>


<jsp:include page="footer.jsp"/>
</html>