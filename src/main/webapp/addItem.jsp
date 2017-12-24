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
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/sweetalert.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function submitForm() {
		$.ajax({
			async : "false",//同步请求
			type : "post",
			dateType : "json",
			data : $('#addForm').serialize(),
			url : "item_add.action",
			success : function(data) {
				if (data.result == "success") {
					swal({
						title : "提交成功",
						icon : "success"
					});
				} else {
					alert("错误");
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<div class="col-xs-7 col-md-offset-2"
			style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<h3 align="center">新增商品</h3>

			<form class="form-horizontal" style="align: center" action=""
				method="post" id="addForm">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="name">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品品牌</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="brand">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品类型</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="type">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品价格</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="price">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品数量</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username"
							name="number">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">商品描述</label>
					<div class="col-sm-10">
						<textarea name="description" class="form-control" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-6" align="center"
						style="font-size: 30px;">
						<button onclick="submitForm()" type="button"
							class="btn btn-primary">确定</button>
					</div>

				</div>

			</form>

		</div>
	</div>
</body>
</html>