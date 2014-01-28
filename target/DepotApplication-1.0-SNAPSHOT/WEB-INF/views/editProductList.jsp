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
        <td><form:label path="created"><spring:message code="label.created"/></form:label></td>
        <td><form:input path="created" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table>
</form:form>


<h3>Products</h3>
<c:if  test="${!empty productList}">
<table class="data">
<tr>
    <th>Title</th>
    <th>Description</th>
    <th>Image URL</th>
    <th>Price</th>
    <th>Created</th>
    <th>&amp;amp;amp;amp;amp;amp;nbsp;</th>
</tr>
<c:forEach items="${productList}" var="prod">
    <tr>
        <td>${prod.title} </td>
        <td>${prod.description}</td>
        <td>${prod.imageUrl}</td>
        <td>${prod.price}</td>
        <td>${prod.created}</td>
        <td><a href="delete/${prod.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>