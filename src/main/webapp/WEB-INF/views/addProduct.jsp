<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>

<h2>Your Pragmatic Catalog</h2>

<form:form method="post" action="add" commandName="product">
    <%@include file="productTable.jsp" %>
    <input type="submit" value="<spring:message code="label.add"/>"/>
</form:form>
</body>
</html>