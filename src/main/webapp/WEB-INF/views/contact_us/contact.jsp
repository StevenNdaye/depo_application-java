<fieldset>
    <legend>Please contact us</legend>

    <form class="form-horizontal" role="form">
      <div class="form-group">
        <label for="full_name" class="col-sm-2 control-label">Full Name</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="full_name" placeholder="Full Name" required>
        </div>
      </div>
      <div class="form-group has_error">
        <label for="user_email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
          <input type="email" class="form-control" id="user_email" placeholder="Email" required>
        </div>
      </div>
      <div class="form-group has_error">
        <label for="user_comment" class="col-sm-2 control-label">Comments</label>
        <div class="col-sm-10">
          <textarea class="form-control" rows="3" id="user_comment" placeholder="Comments, questions or anything" required>
          </textarea>
        </div>
      </div>
      <div class="form-group has_error">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">Send</button>
        </div>
      </div>
    </form>
</fieldset>