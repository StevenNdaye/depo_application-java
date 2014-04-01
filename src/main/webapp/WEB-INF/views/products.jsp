<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Products</h3>
<c:if  test="${!empty productList}">
<table class="data table table-hover">
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
        <td><a href="edit/${prod.id}">edit</a></td>
    </tr>
</c:forEach>
</table>
<a href="new">New Product</a>
</c:if>
