
<html>
<head>
<!-- 引入样式 -->
<link href="${ctx}/plugins/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet"  type="text/css"/>
<link href="${ctx}/plugins/Font-Awesome-3.2.1/css/font-awesome.min.css" rel="stylesheet"  type="text/css"/>
<!-- 引入组件库 -->
<script src="${ctx}/plugins/jquery.min.js"></script>
<link href="${ctx}/css/main.css" rel="stylesheet" />
<title>统一认证::田丰</title>
</head>
<body>
	<#include "/include/header.ftl">
		<div id="banner">
<div class="container">
        <h1>确认登录</h1>
        <p>认证、授权田丰平台相关业务。只需一处登录，即可在相关业务系统中无缝操作</p>
        
      </div>
</div>

	
	<div id="main">
	

	<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body" style="padding:50px;text-align:center">
    确认登录至客户端
    <form id="confirmationForm" name="confirmationForm"
			action="../oauth/authorize" method="post" style="width:100px;display: inline;">
			<input name="user_oauth_approval" value="true" type="hidden" />
			<button class="btn btn-primary" type="submit">同意</button>
		</form>
    <form id="denyForm" name="confirmationForm"
			action="../oauth/authorize" method="post" style="width:100px;display: inline;">
			<input name="user_oauth_approval" value="false" type="hidden" />
			<button class="btn btn-danger" type="submit">拒绝</button>
		</form>
  </div>
  
</div>
		
	</div>
	
	<#include "/include/footer.ftl">
	<style>
#banner{
	text-align:center;
	padding:45px;
	background: #482020;
    color: #fff;
}
#banner .logo span{
	display:block;
	margin-top:10px;
	font-size:13px;
	font-weight:bold;
}	

</style>

<!--
<h2>确认登录</h2>
		
		<p>
			Do you authorize "${authorizationRequest.clientId}" at "${authorizationRequest.redirectUri}" to access your protected resources
			with scope ${authorizationRequest.scope?join(", ")}.
		</p>
		<form id="confirmationForm" name="confirmationForm"
			action="../oauth/authorize" method="post">
			<input name="user_oauth_approval" value="true" type="hidden" />
			<button class="btn btn-primary" type="submit">Approve</button>
		</form>
		<form id="denyForm" name="confirmationForm"
			action="../oauth/authorize" method="post">
			<input name="user_oauth_approval" value="false" type="hidden" />
			<button class="btn btn-primary" type="submit">Deny</button>
		</form>
		-->
</body>
</html>