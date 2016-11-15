<%@ page language="java" contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>

<%@ include file="professional_user_header.html" %>
		
      <div class="container"  align="center" id="create">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          <section>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>Create a professional user</h4>
                </div>
                <div class="panel-body">
                  <form action = "ProfessionalUserCreate" method= "POST">
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon1">First Name: </span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon1" name="firstName">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon2">Last Name: </span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon2" name="lastName">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon3"> &nbsp Location: &nbsp</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon3" name="location">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Profession:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon4" name="profession">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Username:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon5" name="username">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Password:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon6" name="password">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Email:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon7" name="email">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Active:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon4" name="active">
                    </div>
                    <br>
                    <input type="submit" class="btn btn-primary btn-md" value="create" id="SubmitButton" name="submit">
                  </form>
                </div>
              </div>
          </section>
        </div>
      </div>
      <hr>
      <div class="container"  align="center" id="update">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          <section>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>Update a professional user</h4>
                </div>
                <div class="panel-body">
                <p>Please type the professional user id and any of the fields you want to update.</p>
                  <form action = "ProfessionalUserUpdate" method= "POST">
                  	<div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon1">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspID:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </span>
                      <input type="number" class="form-control" placeholder="type here" aria-describedby="basic-addon1" name="proUserId">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon1">First Name: </span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon1" name="firstName">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon2">Last Name: </span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon2" name="lastName">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon3">&nbsp Location: &nbsp</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon3" name="location">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Profession:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon4" name="profession">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Username:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon5" name="username">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Password:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon6" name="password">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Email:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon7" name="email">
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon4">Active:</span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon4" name="active">
                    </div>
                    <br>
                    <input type="submit" class="btn btn-primary btn-md" value="update" id="SubmitButton" name="submit">
                  </form>
                </div>
              </div>
          </section>
        </div>
      </div>
      <hr>
      <div class="container"  align="center" id="remove">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          <section>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>Remove a professional user</h4>
                </div>
                <div class="panel-body">
                  <p>Please type the professional user id who want to remove.</p>
                  <form action = "ProfessionalUserRemove" method= "POST">
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon1">Professional User id: </span>
                      <input type="number" class="form-control" placeholder="type here" aria-describedby="basic-addon1" name="proUserId">
                    </div>
                    <br>
                    <input type="submit" class="btn btn-primary btn-md" value="remove" id="SubmitButton" name="submit">
                  </form>
                  <p>Note: Professional User Id's: 1-4,6,10-18 cannot remove. See <a href="documentation.html">documentation</a> at the bottom.</p>
                </div>
              </div>
          </section>
        </div>
      </div>
      <hr>
      <div class="container"  align="center" id="findOne">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          <section>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>Find a professional user</h4>
                </div>
                <div class="panel-body">
                  <p>Please type the professional user id who want to find.</p>
                  <form action = "ProfessionalUserFindOne" method= "GET">
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon1">Professional User id: </span>
                      <input type="number" class="form-control" placeholder="type here" aria-describedby="basic-addon1" name="proUserId">
                    </div>
                    <br>
                    <input type="submit" class="btn btn-primary btn-md" value="findOne" id="SubmitButton" name="submit">
                  </form>
                </div>
              </div>
          </section>
        </div>
      </div>
      <hr>
      <div class="container"  align="center" id="findActive">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          <section>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>Find Active professional users</h4>
                </div>
                <div class="panel-body">
                  <p>Please type the professional user id who want to find.</p>
                  <form action = "ProfessionalUserFindActive" method= "GET">
                    <br>
                    <input type="submit" class="btn btn-primary btn-md" value="findOne" id="SubmitButton" name="submit">
                  </form>
                </div>
              </div>
          </section>
        </div>
      </div>
      <hr>
      <hr>
      <div class="container"  align="center" id="findFromLocation">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          <section>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>Find a professional user by location</h4>
                </div>
                <div class="panel-body">
                  <p>Please type the location of the professional user who want to remove</p>
                  <form action = "ProfessionalUserFindFromLocation" method= "GET">
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon" id="basic-addon1">Professional User Location: </span>
                      <input type="text" class="form-control" placeholder="type here" aria-describedby="basic-addon1" name="location">
                    </div>
                    <br>
                    <input type="submit" class="btn btn-primary btn-md" value="findFromLocation" id="SubmitButton" name="submit">
                  </form>
                </div>
              </div>
          </section>
        </div>
      </div>
      <hr>
      <div class="container"  align="center" id="findAll">
        <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3" >
          <section>
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4>Find all professional users</h4>
                </div>
                <div class="panel-body">
                  <form action = "ProfessionalUserFindAll" method= "GET">
                    <br>
                    <input type="submit" class="btn btn-primary btn-md" value="findAll" id="SubmitButton" name="submit">
                  </form>
                </div>
              </div>
          </section>
        </div>
      </div>
      <hr>
      <%@ include file="professional_user_footer.html" %>