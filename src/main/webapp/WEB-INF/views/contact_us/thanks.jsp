<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

WHat is this?
<div>
    <p class="<c:out value="${class}"/>">
        <strong><c:out value="${message}"/></strong>
    </p>
</div>
