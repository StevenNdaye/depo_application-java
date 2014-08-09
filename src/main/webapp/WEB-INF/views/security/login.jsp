<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:url var="postLoginUrl" value="${request.contextPath}/j_spring_security_check" />

<form class="form-horizontal" role="form" action="${postLoginUrl}" method="post">
    <c:if test="${not empty error}">
        <p class="bg-danger">Your login attempt failed. Please try again.</p>
    </c:if>
  <h2 class="page-header">Please log in</h2>
  <div class="form-group" style="height: 30px;">
    <label for="username" class="col-sm-2 control-label">Username</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="username" placeholder="Username" name="j_username" autofocus>
    </div>
  </div>
  <div class="form-group" style="height: 30px;">
    <label for="password" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" placeholder="Password" name="j_password">
    </div>
  </div>
  <div class="form-group" style="height: 30px;">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="_spring_security_remember_me"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group" style="height: 30px;">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Log in</button>
    </div>
  </div>
</form>