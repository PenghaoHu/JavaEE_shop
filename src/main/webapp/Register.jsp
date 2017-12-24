<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.js"></script>
<script src="<%=basePath%>/js/bootstrap.min.js"></script>

<script type="text/javascript"></script>
<style>
.css_top {
	margin-top: 120px
}
</style>

<script type="text/javascript">
	function register() {
		$.ajax({
			async:"false",//同步请求
			type:"post",
			dateType:"json",
			data:$('#form_register').serialize(),
			url:"user_register.action",
			success:function(data){
					if(data.result == "success"){
						window.location.href="<%=basePath%>index.jsp";
				} else {
					alert("错误");
				}
			}
		});
	}
</script>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">提示</h4>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

</head>

<body>
	<form class="form-horizontal" role="form" id="form_register"
		action="RegisterServlet" method="post">
		<div class="container">

			<div class="form-group css_top">
				<div style="display: none;" id="warn_username">
					<div class="alert alert-danger">请输入账号！</div>
				</div>
				<div style="display: none;" id="warn_password">
					<div class="alert alert-danger">请输入密码！</div>
				</div>
				<div style="display: none;" id="warn_passwordsame">
					<div class="alert alert-danger">两次输入的密码不一致！</div>
				</div>
				<label for="username" class="col-sm-4 control-label">账号</label>
				<div class="col-sm-4">
					<input class="col-sm-2 form-control" type="text" id="username"
						placeholder="请输入账号" name="username">
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="password" class="col-sm-4 control-label">密码</label>
					<div class="col-sm-4">
						<input class="col-sm-2 form-control" type="password" id="password"
							placeholder="请输入密码" name="password">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="password" class="col-sm-4 control-label">确认密码</label>
					<div class="col-sm-4">
						<input class="col-sm-2 form-control" type="password"
							id="password_again" placeholder="请输入密码">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<div class="col-sm-5"></div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary" onclick="register()" id="register_btn">注册</button>
					</div>
					<div class="col-sm-6">
						<button type="button" class="btn btn-default" id="back_btn">返回</button>
					</div>
				</div>
			</div>
		</div>

	</form>
</body>
</html>