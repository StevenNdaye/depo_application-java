<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset class="col-xs-6">

    <legend>Products</legend>
        <c:if  test="${!empty productList}">
            <c:forEach items="${productList}" var="prod">
            <div class="row">
                <div class="col-xs-5">
                    <img src="<c:url value="/resources/images/${prod.imageUrl}" />" />
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
        </c:if>
        <a href="new">New Product</a>
</fieldset>
