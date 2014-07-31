<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title><tiles:getAsString name="pageTitle"/></title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/master.css" />" rel="stylesheet">
</head>
<body>
    <div id="banner">Pragmatic Bookshelf</div>
    <div id="columns">
        <div id="side" >
              <ul>
                <li><a href=""><spring:message code="side.home"/></a></li>
                <li><a href=""><spring:message code="side.questions"/></a></li>
                <li><a href=""><spring:message code="side.news"/>   </a></li>
                <li><a href=""><spring:message code="side.contact"/></a></li>

                <security:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value="/login" />"><spring:message code="side.login"/></a></li>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <li><a href="<c:url value="/logout" />"><spring:message code="side.logout"/></a></li>
                </security:authorize>

                <li><a href=""><spring:message code="side.register"/></a></li>
              </ul>
        </div>
        <div id="main">
            <main class="container-fluid">
                <tiles:insertAttribute name="body" />
            </main>
        </div>
    </div>
</body>
</html>