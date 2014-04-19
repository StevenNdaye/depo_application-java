<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2 class="page-header">Your Pragmatic Catalog</h2>

<form:form method="post" action="add" commandName="product"
            class="form-horizontal" role="form">
    <%@include file="productTable.jsp" %>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary"><spring:message code="label.add"/></button>
        </div>
    </div>
</form:form>
