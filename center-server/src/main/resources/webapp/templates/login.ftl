<html>
<head>
<#include "/include/resources.ftl">

<title>统一认证</title>
<style type="text/css">
.loginBar{
    color: red;
    font-weight: bold;
    padding: 10px 50px;
    }
#banner{
	text-align:center;
	padding:45px;
	  //  background: #482020;
	  background:#2a79bd;
    color: #fff;
	transition-duration:5s;
	/* Safari */
	-webkit-transition-duration:5s;
}
#banner:hover{
	background: #482020;
	opacity:0.8;
	filter:Alpha(opacity=80);
}
#banner .logo span{
	display:block;
	margin-top:10px;
	font-size:13px;
	font-weight:bold;
}

.main-box {
	margin: auto;
	position: relative;
	margin-top:20px;
	
    background: #fafafa;
    border: 1px solid #dbe5ef;
}	

</style>
</head>
<body>

<!--
	<div class="container">
		<form role="form" action="login" method="post">
		  <div class="form-group">
		    <label for="username">Username:到底</label>
		    <input type="text" class="form-control" id="username" name="username"/>
		  </div>
		  <div class="form-group">
		    <label for="password">Password:</label>
		    <input type="password" class="form-control" id="password" name="password"/>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>-->
	<#include "/include/header.ftl">
	<div id="banner">
		<div class="container">
        <h1>统一认证授权中心</h1>
        <p>认证、授权平台相关业务。只需一处登录，即可在相关业务系统中无缝操作</p>
        
      </div>
</div>

	<div  id="main">
	
	<div class="main-box mask-loading-container">
		<div class="box-header g-clear">
			<a class="pull-left " href="#" style="margin-right:20px">
				<i class="icon-user-md icon-4x"></i>
			</a>
			<div class="pull-left title">用户登陆</div>
			<div class="pull-right loginBar" >
  				<#if SPRING_SECURITY_LAST_EXCEPTION??>
  				
					<#if "Bad credentials"==SPRING_SECURITY_LAST_EXCEPTION.message!''>
					   	用户名或密码错!
					   	<#else>  
    						登录异常！
					</#if>
				</#if>
  			</div>
			
		</div>
		<form class="form-horizontal" role="form" action="login" method="post" onSubmit="return checkForm()">
			<div class="form-group">
				<label class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-9">
					<input id="username" name="username" type="text" class="form-control"
						maxlength="32" placeholder="用户名" value=""  >
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">密码</label>
				<div class="col-sm-9">
					<input id="password" name="password" type="password" class="form-control"
						maxlength="64" placeholder="密码" value="">
				</div>
			</div>


			<div class="form-group" style="margin-top: 35px;">
				<div class="col-sm-offset-2 col-sm-9">
					<button type="submit" class="btn btn-primary ok"
						style="width: 100%">登陆</button>


				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-9">
					<div class="checkbox">
						<label>
						</label>
					</div>
				</div>
			</div>
		</form>
	</div>
	</div>
	<#include "/include/footer.ftl">
<script type="text/javascript">
function checkForm(){
	//App.alert('sfdsf','ddd');
	return true;
}
</script>

</body>
</html>