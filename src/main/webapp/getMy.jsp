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
	var html;
	$.ajax({
	async : "true",//同步请求
	type : "post",
	dateType : "json",
	url : "item_getMy.action",
	success : function(data) {
		$.each(data.data,function(i,item){
			var name = item.name;
			var type = item.type;
			var number = item.number;
			var price = item.price;
			var id = item.id;
			html += '<tr><td>'+name+'</td><td>'+type+'</td><td>'+number+'</td><td>'+price+'</td><td><button onclick="todetail('+id+')" type="button"class="btn btn-default">查看</button></td></tr>';
		});
		$('#loadBody').html(html);
	}
});	
</script>
</head>
<body>
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">商品列表</div>


		<!-- Table -->
		<table class="table">
			<thead>
				<tr>
					<th>商品名称
					<th>商品类型
					<th>商品数量
					<th>商品价格
					<th>操作
				</tr>
			</thead>
			<tbody id="loadBody"></tbody>
		</table>
	</div>
</body>
</html>