<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<fieldset>
    <legend>Please contact us</legend>
    <p class="<c:out value="${class}"/>">
        <strong><c:out value="${message}"/></strong>
    </p>
    <form:form class="form-horizontal" role="form" method="post" action="submitContactForm" modelAttribute="feedback">
      <div class="form-group">
        <label for="full_name" class="col-sm-2 control-label">Full Name</label>
        <div class="col-sm-10">
          <form:input type="text" class="form-control" id="full_name" placeholder="Full Name" autofocus="autofocus"
                      required="required"  path="fullName"/>
        </div>
      </div>
      <div class="form-group has_error">
        <label for="user_email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
          <form:input type="email" class="form-control" id="user_email" placeholder="Email" required="required"
                      path="email"/>
        </div>
      </div>
      <div class="form-group has_error">
        <label for="user_comment" class="col-sm-2 control-label">Comments</label>
        <div class="col-sm-10">
          <form:textarea class="form-control" rows="3" id="user_comment" placeholder="Comments, questions or anything"
                         required="required" path="comments"/>
          </textarea>
        </div>
      </div>
        <div class="form-group">
            <label class="col-sm-2 control-label"></label>
            <div class="col-sm-10">
                <tags:captcha privateKey="6Lem2vcSAAAAAFdeDYaqpcv-KC6XhJsFDh1hxvyy"
                              publicKey="6Lem2vcSAAAAAGuhNrFXaudIFM5oBaGlZONJoHqe">
                </tags:captcha>
            </div>
        </div>
      <div class="form-group has_error">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">Send</button>
        </div>
      </div>

    </form:form>
</fieldset>