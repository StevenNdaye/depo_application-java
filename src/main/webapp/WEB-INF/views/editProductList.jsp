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

    <table>
    <tr>
        <td><form:label path="title"><spring:message code="label.title"/></form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="description"><spring:message code="label.description"/></form:label></td>
        <td><form:input path="description" /></td>
    </tr>
    <tr>
        <td><form:label path="imageUrl"><spring:message code="label.image_url"/></form:label></td>
        <td><form:input path="imageUrl" /></td>
    </tr>
    <tr>
        <td><form:label path="price"><spring:message code="label.price"/></form:label></td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table>
</form:form>
</body>
</html>