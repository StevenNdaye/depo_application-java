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

<fieldset class="col-xs-6">

    <legend>Products</legend>
        <c:if  test="${!empty productList}">
            <c:forEach items="${productList}" var="prod">
            <div class="row">
                <div class="col-xs-5">
                    <img src="/resources/images/${prod.imageUrl}"/>
                </div>
                <div class="col-xs-7>
                    <table class="table">
                        <tr>
                            <td class="col-xs-5 pull-left">Title:</td>
                            <td class="col-xs-7 pull-right">${prod.title}</td>
                        </tr>
                        <tr>
                            <td class="col-xs-5 pull-left">Description:</td>
                            <td class="col-xs-7 pull-right">${prod.description}</td>
                        </tr>
                        <tr>
                            <td class="col-xs-5 pull-left">Price:</td>
                            <td class="col-xs-7 pull-right">${prod.price}</td>
                        </tr>
                        <tr>
                            <td class="col-xs-5 pull-left"></td>
                            <td class="col-xs-7 pull-right"><a href="delete/${prod.id}">delete</a></td>
                        </tr>
                        <tr>
                            <td class="col-xs-5 pull-left"></td>
                            <td class="col-xs-7 pull-right"><a href="edit/${prod.id}">edit</a></td>
                        </tr>
                    </table>
                </div>
            </div>
            </c:forEach>
            <a href="new">New Product</a>
        </c:if>
</fieldset>
