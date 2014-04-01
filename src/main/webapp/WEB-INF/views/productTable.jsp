<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="form-group">
    <form:label path="title" class="col-sm-2 control-label pull-left"><spring:message code="label.title"/></form:label>
    <div class="col-sm-10">
      <form:input path="title" class="form-control" placeholder="Title" required="required" autofocus="autofocus"/>
    </div>
</div>

<div class="form-group">
    <form:label path="description" class="col-sm-2 control-label pull-left">
    <spring:message code="label.description"/></form:label>
    <div class="col-sm-10">
      <form:input path="description" class="form-control" placeholder="Description" required="required"/>
    </div>
</div>

<div class="form-group">
    <form:label path="imageUrl" class="col-sm-2 control-label pull-left">
    <spring:message code="label.image_url"/></form:label>
    <div class="col-sm-10">
      <form:input path="imageUrl" class="form-control" placeholder="Image url" required="required"/>
    </div>
</div>

<div class="form-group">
    <form:label path="price" class="col-sm-2 control-label pull-left">
    <spring:message code="label.price"/></form:label>
    <div class="col-sm-10">
      <form:input path="price" class="form-control" placeholder="Price" required="required"/>
    </div>
</div>
