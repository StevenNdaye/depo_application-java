<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="postLoginUrl" value="/j_spring_security_check" />

<c:if test="${not empty error}">
    <div>Your login attempt failed. Please try again.</div>
</c:if>

<h1>Please log in</h1>

<form:form class="main" action="${postLoginUrl}" method="post">
    Username: <input type="text" name="j_username" /><br />
    Password: <input type="password" name="j_password" /><br />
    <input type="checkbox" name="_spring_security_remember_me" />
    Remember me<br />
    <input type="submit" value="Log in" />
</form:form>