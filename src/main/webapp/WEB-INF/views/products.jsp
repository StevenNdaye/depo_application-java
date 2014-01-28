<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<h3>Products</h3>
<c:if  test="${!empty productList}">
<table class="data">
<tr>
    <th>Title</th>
    <th>Description</th>
    <th>Image URL</th>
    <th>Price</th>
    <th></th>
</tr>
<c:forEach items="${productList}" var="prod">
    <tr>
        <td>${prod.title} </td>
        <td>${prod.description}</td>
        <td>${prod.imageUrl}</td>
        <td>${prod.price}</td>
        <td><a href="delete/${prod.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
<a href="new">New Product</a>
</c:if>
</body>
</html>