<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset class="col-xs-12">

    <legend>Products</legend>
        <c:if  test="${!empty productList}">
            <c:forEach items="${productList}" var="prod">
            <div class="row">
                <div class="col-xs-2">
                    <img src="<c:url value="/resources/images/${prod.imageUrl}" />" />
                </div>
                <div class="col-xs-10 form-group">
                <fieldset><legend></legend>
                    <table class="table table-condensed">
                        <tr>
                            <td class="col-xs-2 pull-left"><b>Title:</b></td>
                            <td class="col-xs-10 pull-right">${prod.title}</td>
                        </tr>
                        <tr>
                            <td class="col-xs-2 pull-left"><b>Description:</b></td>
                            <td class="col-xs-10 pull-right">${prod.description}</td>
                        </tr>
                        <tr>
                            <td class="col-xs-2 pull-left"><b>Price:</b></td>
                            <td class="col-xs-10 pull-right">
                            <fmt:formatNumber value="${prod.price}" type="currency" />
                            </td>
                        </tr>
                        <tr>
                            <td class="col-xs-2 pull-left"></td>
                            <td class="col-xs-10 pull-right">
                                <button type="submit" class="btn btn-primary"><spring:message code="label.addToCard"/></button>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-xs-2 pull-left"></td>
                            <td class="col-xs-10 pull-right"><a href="delete/${prod.id}">delete</a></td>
                        </tr>
                        <tr>
                            <td class="col-xs-2 pull-left"></td>
                            <td class="col-xs-10 pull-right"><a href="edit/${prod.id}">edit</a></td>
                        </tr>
                    </table>
                    </fieldset>
                </div>
            </div>
            </c:forEach>
        </c:if>
        <a href="new">New Product</a>
</fieldset>
