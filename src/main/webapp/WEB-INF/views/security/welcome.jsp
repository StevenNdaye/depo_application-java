<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

Hi, <security:authentication property="principal.fullName" />.