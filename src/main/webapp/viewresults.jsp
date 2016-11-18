<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bids4Job Search Results</title>
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
            <a href="index">
              <img alt="Brand" src="images/logo.png"><!--Brand logo image-->
            </a>
            <ul class="nav navbar-nav">
            <li class="active">
            <a href="prouserprofile.html">My Profile</a></li>
            </ul>
          	<div class="navbar-form navbar-right">
            <a href="logout.html" class="btn btn-info" role="button">Log out</a>
          </div>
      </div>
    </nav>
   

   <div class="container-fluid">
   	
    <div class="row">
      <div class="col-lg-12 results-img"><img class="img-responsive" src="images/results.jpg">
      </div>
    </div><!-- End of .row-->
  </div>

<div class="container">    
<div class="row toppad">
<div class="panel panel-info">
    <div class="panel-heading">
        <h2 class="panel-title">Search Results</h2>
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
	     <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
	       <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Task #2 by simple_user2
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Task #3 by simple_user3
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFour">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          Task #4 by simple_user4
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFive">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
          Task #5 by simple_user5
        </a>
      </h4>
    </div>
    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingSix">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
          Task #6 by simple_user6
        </a>
      </h4>
    </div>
    <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingSeven">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
          Task #7 by simple_user7
        </a>
      </h4>
    </div>
    <div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingEight">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
          Task #8 by simple_user8
        </a>
      </h4>
    </div>
    <div id="collapseEight" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEight">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingNine">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseNine" aria-expanded="false" aria-controls="collapseNine">
          Task #9 by simple_user9
        </a>
      </h4>
    </div>
    <div id="collapseNine" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingNine">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTen">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTen" aria-expanded="false" aria-controls="collapseTen">
          Task #10 by simple_user10
        </a>
      </h4>
    </div>
    <div id="collapseTen" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTen">
      <div class="panel-body">
      <table class="table">
	         <tbody>
	          	<tr class="active">
	               <th>Task Description</th>
	               <th>Field of Work</th>
	               <th>Task Location</th>
	               <th>Deadline</th>
	            </tr>
	            <tr>
	               <td>This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues... This is a test task for bidding. Electrician needed for various issues...</td>
	               <td>Electrician</td>
	               <td>myLocation</td>
	               <td>30/11/2016 23:59:59</td>
	             </tr>         
	          </tbody>            
	        </table>       
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Bidder</th>
              <th>Rating</th>
              <th>Amount &euro;</th>
              <th>Bid Date</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>pro_user1</td>
              <td>4.5</td>
              <td>500</td>
              <td>12/10/2016 15:05:00</td>
            </tr>
            <tr>
              <td>pro_user2</td>
              <td>4.1</td>
              <td>570</td>
              <td>12/10/2016 13:15:00</td>
            </tr>
            <tr>
              <td>pro_user3</td>
              <td>4.7</td>
              <td>580</td>
              <td>12/10/2016 10:10:00</td>
            </tr>
          </tbody>
        </table>
        <div class="panel-footer"><h5>Make a new bid 
        <a href="#" data-toggle="modal" data-target="#bid-modal" data-placement="bottom" title="Make new bid" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-plus"></i></a></h5>
        </div>
      </div>
    </div>
  </div><!-- End .panel -->
</div><!-- End .accordion-->
</div>
</div><!-- End of .row-->

<!-- Start #bid-modal -->
<div class="modal fade" id="bid-modal" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header modal-header-primary">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">New Bid</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
          <label for="bid">Bid Amount &euro;:</label>
          <input type="text" class="form-control" id="bid">
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Submit</button>
      </div>
    </div><!-- End .modal-content -->
  </div><!-- End .modal-dialog -->
</div><!-- End #bid-modal -->

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