<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bids4Job</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Custom Style -->
    <link rel="stylesheet" href="css/main.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Login Modal style -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>


  <!--Navbar start-->

   <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
            <a href="index">
              <img alt="Brand" src="images/logo.png"><!--Brand logo image-->
            </a>
      </div>
    </nav>
 <!--Navbar end-->





<div class="container signup-top">

<div class="tabbable full-width-tabs col-lg-8 col-md-6 col-sm-6 col-xs-8 col-lg-offset-2 col-md-offset-3 col-sm-offset-3 col-xs-offset-2">
        <ul class="nav nav-tabs nav-justified login-tab-clr">
          <li class="active"><a data-toggle="tab" href="#Individual">Individual</a></li>
          <li><a data-toggle="tab" href="#Professional">Professional</a></li>
        </ul>

      <div class="tab-content">
        <div id="Individual" class="tab-pane fade in active">
        <h2 class="form-signin-heading login-or-signup">Sign Up</h2>
          <form class="form-horizontal" method="POST" action="register_simple" class="form-signup">

        <div class="form-group">
        <label for="username" class="col-sm-2 control-label">User Name</label>
        <div class="col-sm-6">
          <input type="text" name="uname" ng-model="uname" class="form-control" id="username" placeholder="Your user name" required>
        </div>
        </div>

        <div class="form-group">
        <label for="userpass" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-6">
          <input type="password" name="upass" class="form-control" id="userpass" placeholder="Your password" required>
        </div>
        </div>

        <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-6">
          <input type="email" name="email" class="form-control" id="fname" placeholder="Your email" required>
        </div>
        </div>

        <div class="form-group">
        <label for="fname" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-6">
          <input type="text" name="firstname" class="form-control" id="fname" placeholder="Your first name" required>
        </div>
        </div>

        <div class="form-group">
        <label for="sname" class="col-sm-2 control-label">Surname</label>
        <div class="col-sm-6">
          <input type="text" name="surname" class="form-control" id="sname" placeholder="Your surname" required>
        </div>
        </div>

        <div class="form-group">
        <label for="location" class="col-sm-2 control-label">Location</label>
        <div class="col-sm-6">
         <!-- <input list="location" name="location" class="form-control" placeholder="Your location">
          -->
          <select id="locations" name="location" required>
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
        <div class="col-sm-offset-2 col-sm-6">
          <button type="submit" class="btn btn-info">Sign Up</button>
          <input type="reset" class="btn btn-info">
        </div>
        </div>

    </form>
        </div><!-- End of #Individual -->
        <div id="Professional" class="tab-pane fade">
          <h2 class="form-signin-heading login-or-signup">Sign Up</h2>
          <form class="form-horizontal" method="POST" action="register_professional" class="form-signup">

        <div class="form-group">
        <label for="username" class="col-sm-2 control-label">User Name</label>
        <div class="col-sm-6">
          <input type="text" name="uname" class="form-control" id="username" placeholder="Your user name" required>
        </div>
        </div>

        <div class="form-group">
        <label for="userpass" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-6">
          <input type="password" name="upass" class="form-control" id="userpass" placeholder="Your password" required>
        </div>
        </div>

        <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-6">
          <input type="email" name="email" class="form-control" id="fname" placeholder="Your email" required>
        </div>
        </div>

        <div class="form-group">
        <label for="fname" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-6">
          <input type="text" name="firstname" class="form-control" id="fname" placeholder="Your first name" required>
        </div>
        </div>

        <div class="form-group">
        <label for="sname" class="col-sm-2 control-label">Surname</label>
        <div class="col-sm-6">
          <input type="text" name="surname" class="form-control" id="sname" placeholder="Your surname" required>
        </div>
        </div>

        <div class="form-group">
        <label for="location" class="col-sm-2 control-label">Location</label>
        <div class="col-sm-6">
          <!-- <input list="location" name="location" class="form-control" placeholder="Your location">
          -->
          <select id="locations" name="location" required>
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
          <!-- <input list="location" name="location" class="form-control" placeholder="Your location">
          -->
          <select id="professions" name="profession" required>
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
          <button type="submit" class="btn btn-info">Sign Up</button>
          <input type="reset" class="btn btn-info">
        </div>
        </div>
      </form>
        </div><!-- End of #Professional -->
      </div><!-- End of .tab-content -->
    </div>


    </div> <!-- End of .container -->


      <!-- Start Footer -->
<div class="container">
<hr>
      <footer>
        <p>&copy; 2016 Bids4Job S.A. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
      <!-- End of Footer -->
</div>
    <!-- End of .container -->




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script>window.jQuery || document.write('<script src="js/vendor/jquery.min.js"><\/script>')</script>
    <!-- Just to make placeholder images work-->
    <script src="js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>