<!DOCTYPE html>
<%@page import="com.hemant.hr.JobData"%>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <title>HP SOFT | APPLY JOB</title>
  <!-- loader-->
  <link href="assets/css/pace.min.css" rel="stylesheet"/>
  <script src="assets/js/pace.min.js"></script>
  <!--favicon-->
  <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
  <!-- simplebar CSS-->
  <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
  <!-- Bootstrap core CSS-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="assets/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="assets/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Sidebar CSS-->
  <link href="assets/css/sidebar-menu.css" rel="stylesheet"/>
  <!-- Custom Style-->
  <link href="assets/css/app-style.css" rel="stylesheet"/>
  
  
</head>

<body class="bg-theme bg-theme1">

<!-- start loader -->
   <div id="pageloader-overlay" class="visible incoming"><div class="loader-wrapper-outer"><div class="loader-wrapper-inner" ><div class="loader"></div></div></div></div>
   <!-- end loader -->

<!-- Start wrapper-->
 <div id="wrapper">

 <!--Start sidebar-wrapper-->
   <div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
     <div class="brand-logo">
      <a href="index.jsp">
       <img src="assets/images/logo-icon.png" class="logo-icon" alt="logo icon">
       <h5 class="logo-text">HP Soft Private Ltd.</h5>
     </a>
   </div>
   
   <ul class="sidebar-menu do-nicescrol">
      <li class="sidebar-header">Apply for Job</li>
      <li>
        <a href="#">
          <i class="zmdi zmdi-view-dashboard"></i> <span>Job Registration Form</span>
        </a>
      </li>
	  <hr>
      <li>
        <a href="#">
          <i class="zmdi zmdi-invert-colors"></i> <span>Instructions</span>
        </a>
      </li>

      <li>
        <a href="#">
          <i class="zmdi zmdi-format-list-bulleted"></i> <span>Fill all the Details carefully</span>
        </a>
      </li>

      </ul>
   
   </div>
   <!--End sidebar-wrapper-->

<!--Start topbar header-->
<header class="topbar-nav">
 <nav class="navbar navbar-expand fixed-top">
  <ul class="navbar-nav mr-auto align-items-center">
    <li class="nav-item">
      <a class="nav-link toggle-menu" href="javascript:void();">
       <i class="icon-menu menu-icon"></i>
     </a>
    </li>
    <li class="nav-item">
      <form class="search-bar">
        <h5>Registration Form</h5>
      </form>
    </li>
  </ul>
     
  <ul class="navbar-nav align-items-center right-nav-link">
    <li class="nav-item dropdown-lg">
      <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
      <i class="fa fa-envelope-open-o"></i></a>
    </li>
    <li class="nav-item dropdown-lg">
      <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();">
      <i class="fa fa-bell-o"></i></a>
    </li>
    <li class="nav-item language">
      <a class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect" data-toggle="dropdown" href="javascript:void();"><i class="fa fa-flag"></i></a>
      <ul class="dropdown-menu dropdown-menu-right">
          <li class="dropdown-item"> <i class="flag-icon flag-icon-gb mr-2"></i> English</li>
          <li class="dropdown-item"> <i class="flag-icon flag-icon-fr mr-2"></i> French</li>
          <li class="dropdown-item"> <i class="flag-icon flag-icon-cn mr-2"></i> Chinese</li>
          <li class="dropdown-item"> <i class="flag-icon flag-icon-de mr-2"></i> German</li>
        </ul>
    </li>
    
  </ul>
</nav>
</header>
<!--End topbar header-->

<div class="clearfix"></div>
	
  <div class="content-wrapper">
    <div class="container-fluid">
		<%
			JobData.setJobid(Integer.parseInt(request.getParameter("id")));
			JobData.setHrid(Integer.parseInt(request.getParameter("hrid")));
		%>
      <div class="col-lg-6">
        <div class="card">
           <div class="card-body">
           <div class="card-title">Registration Form for Job</div>
           <hr>
         <form action="RegisterCand" method="post">
           
           <input type="hidden" name="id"  value="<%=JobData.getJobid() %>" >
           <input type="hidden" name="hrid"  value="<%=JobData.getHrid() %>" >
    
           <div class="form-group">
            <label for="input-6">Name</label>
            <input type="text" name="name" class="form-control form-control-rounded" id="input-6" placeholder="Enter Your Name" required>
           </div>
           <div class="form-group">
            <label for="input-7">Email</label>
            <input type="email" name="email" class="form-control form-control-rounded" id="input-7" placeholder="Enter Your Email Address" required>
           </div>
           <div class="form-group">
            <label for="input-8">Mobile</label>
            <input type="number" name="mobile" class="form-control form-control-rounded" id="input-8" placeholder="Enter Your Mobile Number" required>
           </div>
           <div class="form-group">  
          <label for="input-9">Date Of Birth</label>
            <input type="date" name="dob" class="form-control form-control-rounded" id="input-9" required>
           </div>
           <div class="form-group">
            <label for="input-7">Highest Qualification</label>
            <input type="text" name="quali" class="form-control form-control-rounded" id="input-7" placeholder="Enter Your Highest Qualification" required>
           </div>
           <div class="form-group">  
          <label for="input-9">Graduation Year</label>
            <input type="text" name="year" class="form-control form-control-rounded" id="input-9" placeholder="Enter Your Graduation Year" required>
           </div>
           
           <div class="form-group py-2">
             <div class="icheck-material-white">
            <input type="checkbox" id="user-checkbox2" required/>
            <label for="user-checkbox2"><a><u>I Agree Terms & Conditions</u></a></label>
            </div>
           </div>
           <div class="form-group">
            <button type="submit" class="btn btn-light btn-round px-5"><i class="zmdi zmdi-account-add"></i> Register </button>
          </div>
          </form>
         </div>
         </div>
      </div>
    </div><!--End Row-->
	

	<!--start overlay-->
		  <div class="overlay toggle-menu"></div>
		<!--end overlay-->

    </div>
    <!-- End container-fluid-->
    
   </div><!--End content-wrapper-->
   <!--Start Back To Top Button-->
   
	
	<!--start color switcher-->
   <div class="right-sidebar">
    <div class="switcher-icon">
      <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
    </div>
    <div class="right-sidebar-content">

      <p class="mb-0">Gaussion Texture</p>
      <hr>
      
      <ul class="switcher">
        <li id="theme1"></li>
        <li id="theme2"></li>
        <li id="theme3"></li>
        <li id="theme4"></li>
        <li id="theme5"></li>
        <li id="theme6"></li>
      </ul>

      <p class="mb-0">Gradient Background</p>
      <hr>
      
      <ul class="switcher">
        <li id="theme7"></li>
        <li id="theme8"></li>
        <li id="theme9"></li>
        <li id="theme10"></li>
        <li id="theme11"></li>
        <li id="theme12"></li>
		<li id="theme13"></li>
        <li id="theme14"></li>
        <li id="theme15"></li>
      </ul>
      
     </div>
   </div>
  <!--end color switcher-->
   
  </div><!--End wrapper-->


  <!-- Bootstrap core JavaScript-->
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/popper.min.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
	
 <!-- simplebar js -->
  <script src="assets/plugins/simplebar/js/simplebar.js"></script>
  <!-- sidebar-menu js -->
  <script src="assets/js/sidebar-menu.js"></script>
  
  <!-- Custom scripts -->
  <script src="assets/js/app-script.js"></script>
	
</body>
</html>
