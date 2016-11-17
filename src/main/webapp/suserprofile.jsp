<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bids4Job Simple User Profile</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Custom Style -->
	<link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="css/profiles.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
            <a href="index.jsp">
              <img alt="Brand" src="images/logo.png"><!--Brand logo image-->
            </a>
            <ul class="nav navbar-nav">
            <li class="active">
            <a href="suserprofile.jsp" class="active">My Profile</a></li>
            </ul>
          	<div class="navbar-form navbar-right">
            <a href="logout.jsp" class="btn btn-info" role="button">Log out</a>
          </div>
      </div>
    </nav>
   

   <div class="container">
   	
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">User Profile</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="images/user_avatar.png" class="img-circle img-responsive"> </div>
                
                
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Username:</td>
                        <td>simpleuser1</td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td>email@example.com</td>
                      </tr>
                      <tr>
                        <td>Name:</td>
                        <td>myName</td>
                      </tr>
                      <tr>
                        <td>Surname:</td>
                        <td>mySurname</td>
                      </tr>
                      <tr>
                        <td>Location:</td>
                        <td>Athens Center</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          <div class="panel-footer">
            <a href="#" data-toggle="modal" data-target="#task-modal" data-placement="bottom" title="Create new task" type="button" class="btn btn-primary">Create new task</a>
        </div>
          </div><!-- End of .panel-->
        </div>
      </div><!-- End of .row-->
      
<div class="row">
<div class="panel panel-info">
    <div class="panel-heading">
        <h2 class="panel-title">My Tasks</h2>
    </div>
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Task #1 by simple_user1
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
              <th>Accept Bid</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
              <td><a href="#" class="btn btn-info" role="button">Accept Bid</a></td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
              <td><a href="#" class="btn btn-info" role="button">Accept Bid</a></td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
              <td><a href="#" class="btn btn-info" role="button">Accept Bid</a></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Task #2 by simple_user1
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
              <th>Accept Bid</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
              <td><a href="#" class="btn btn-info" role="button">Accept Bid</a></td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
              <td><a href="#" class="btn btn-info" role="button">Accept Bid</a></td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
              <td><a href="#" class="btn btn-info" role="button">Accept Bid</a></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div><!-- End .panel -->
</div>
</div>
</div><!-- End of .row-->

<!-- Start #task-modal -->
<div class="modal fade" id="task-modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header modal-header-primary">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">New Task</h4>
      </div>
      <div class="modal-body">
      <form class="form-horizontal" method="POST" action="register" class="form-signup">

        <div class="form-group">
        <label for="task-title" class="col-sm-2 control-label">Title</label>
        <div class="col-sm-6">
          <input type="text" name="task-title" ng-model="task-title" class="form-control" id="task-title" placeholder="Task Title" required>
        </div>
        </div>

        <div class="form-group">
        <label for="task-description" class="col-sm-2 control-label">Task Description</label>
        <div class="col-sm-6">
          <textarea type="text" rows="4" name="task-description" class="form-control" id="task-description" placeholder="Task Description..." maxlength="1000" required></textarea>
        </div>
        </div>

        <div class="form-group">
        <label for="deadline" class="col-sm-2 control-label">Deadline</label>
        <div class="col-sm-6">
          <input type="date" name="deadline" class="form-control" id="deadline" placeholder="Task Deadline" required>
        </div>
        </div>

        <div class="form-group">
        <label for="location" class="col-sm-2 control-label">Location</label>
        <div class="col-sm-6">
          <select id="locations" required>
              <option value=""></option>
              <option value="Athens Center">Athens Center</option>
              <option value="Athens North Sector">Athens North Sector</option>
              <option value="Athens South Sector">Athens South Sector</option>
              <option value="Athens East Sector">Athens East Sector</option>
              <option value="Athens West Sector">Athens West Sector</option>
              <option value="Thessaloniki">Thessaloniki</option>
              <option value="Patra">Patra</option>
          </select>
        </div>
        </div>

        <div class="form-group">
        <label for="location" class="col-sm-2 control-label">Profession</label>
        <div class="col-sm-6">
          
          <select id="professions" required>
              <option value=""></option>
              <option value="Electrician">Electrician</option>
              <option value="Plumber">Plumber</option>
              <option value="Painter">Painter</option>
              <option value="Hair Dresser">Hair Dresser</option>
              <option value="Developer">Developer</option>
              <option value="Designer">Designer</option>
              <option value="Dancer">Dancer</option>
              <option value="Banker">Banker</option>
              <option value="Logistics">Logistics</option>
              <option value="Personal Trainer">Personal Trainer</option>
              <option value="Teacher">Teacher</option>
          </select>
        </div>
        </div>

        <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
          <button type="submit" class="btn btn-success">Create</button>
          <input type="reset" class="btn btn-warning">
        </div>
        </div>

    </form>
  
</div><!-- End .modal-body -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        
      </div>
    </div><!-- End .modal-content -->
  </div><!-- End .modal-dialog -->
</div><!-- End #task-modal -->

<hr>
      <footer>
        <p>&copy; 2016 Bids4Job S.A. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
      <!-- End of Footer -->


</div><!-- End of .container-->
		

    


    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>