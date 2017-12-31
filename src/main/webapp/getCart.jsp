<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/sweetalert.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var html;
	$.ajax({
		async : "true",//同步请求
		type : "post",
		dateType : "json",
		url : "cart_getAllCart.action",
		success : function(data) {
			$.each(data.data,function(i,item){
				var name = item.item_name;
				var number = item.number;
				var id = item.id;
				html += '<tr><td>'+name+'</td><td>'+number+'</td><td><button onclick="del('+id+')" type="button"class="btn btn-default">移除</button><button onclick="checkout('+id+')" type="button"class="btn btn-success">付款</button></td></tr>';
			});
			$('#loadBody').html(html);
	}
});
	
	function del(id){
		$.ajax({
			async:"false",//同步请求
			type:"post",
			dateType:"json",
			data:"id="+id,
			url:"cart_delete.action",
			success:function(data){
					if(data.result == "success"){
						swal({
							title : "移除成功",
							icon : "success"
						});
				} else {
					alert("错误");
				}
			}
		});
	}
	function checkout(id){
		$.ajax({
			async:"false",//同步请求
			type:"post",
			dateType:"json",
			data:"id="+id,
			url:"cart_checkOut.action",
			success:function(data){
					if(data.result == "success"){
						swal({
							title : "付款成功",
							icon : "success"
						});
				} else {
					swal({
						title : "商品库存不足",
						icon : "success"
					});
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">购物车列表</div>


		<!-- Table -->
		<table class="table">
			<thead>
				<tr>
					<th>商品名称
					<th>商品数量
					<th>操作
				</tr>
			</thead>
			<tbody id="loadBody"></tbody>
		</table>
	</div>
</body>
</html>