<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <title>Prideti nauja</title>
        <jsp:include page="header.jsp"/>
        <jsp:include page="menu.jsp"/>
        <style>
            .error{color:red}
        </style>
    </head>
    <body class="container">
        <h2>Naujas</h2>

        <form:form method="post" action="/add-new-rank" modelAttribute="rank">
                    <span> Vardas: <form:input type="text" path="name"/>
                   <form:errors path="name" cssClass="error"/></span><p>
                   <br>
                 <span> Reitingas: <form:input type="text" path="rank"/>
                   <form:errors path="rank" cssClass="error"/></span>
                   <br>
                   <br>
               <input type="submit" value="Prideti" class="btn btn-info">
               <br>


        </form:form>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
