<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String item_id = request.getParameter("id").toString();
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/sweetalert.min.js"></script>
<script type="text/javascript">
$.ajax({
	async : "false",//同步请求
	type : "post",
	dateType : "json",
	url : "item_getDetail.action?id="+<%=item_id%>,
	success : function(data) {
		if (data.result == "success") {
			var item = data.itemDetail;
			$('#id').val(item.id);
			$('#name').val(item.name);
			$('#brand').val(item.brand);
			$('#type').val(item.type);
			$('#price').val(item.price);
			$('#number').val(item.number);
			$('#itemUser').val(data.itemUsername);
			$('#description').val(item.description);
		} else {
			alert("错误");
		}
	}
});

	function update(){
		$.ajax({
			async:"false",//同步请求
			type:"post",
			dateType:"json",
			data:$('#addForm').serialize(),
			url:"item_update.action",
			success:function(data){
					if(data.result == "success"){
						swal({
							title : "修改成功",
							icon : "success"
						});
				} else {
					alert("错误");
				}
			}
		});
	}
	function del(){
		$.ajax({
			async:"false",//同步请求
			type:"post",
			dateType:"json",
			data:"id="+<%=item_id%>,
			url:"item_delete.action",
			success:function(data){
					if(data.result == "success"){
						swal({
							title : "删除成功",
							icon : "success"
						});
				} else {
					alert("错误");
				}
			}
		});
	}
</script>
<script type="text/javascript">
function toAll(){
	window.location.href="<%=basePath%>getMy.jsp";
}


</script>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<div class="col-xs-7 col-md-offset-2"
			style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<h3 align="center">商品详情</h3>

			<form class="form-horizontal" style="align: center" action=""
				method="post" id="addForm">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="id" name="id" style="display: none;">
						<input type="text" class="form-control" id="name" name="name">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品品牌</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="brand" name="brand">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品类型</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="type" name="type">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品价格</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="price" name="price">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品数量</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="number"
							name="number">
					</div>
				</div>
				<fieldset disabled>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">商品卖家</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="itemUser"
							name="itemUser">
					</div>
				</div>
				</fieldset>

				<div class="form-group">
					<label class="col-sm-2 control-label">商品描述</label>
					<div class="col-sm-10">
						<textarea name="description" id="description" class="form-control" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-6" align="center"
						style="font-size: 30px;">
							<button type="button" class="btn btn-primary" onclick="update()">修改</button>
							<button type="button" onclick="del()" class="btn btn-warning">下架</button>
							<button type="button" onclick="toAll()" class="btn btn-default">返回</button>
					</div>
					
				</div>
				
			</form>

		</div>
	</div>
</body>
</html>