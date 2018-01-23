<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//全选与反选
function choice(){
	//取到对象数组
	var ck = document.getElementsByName("ck");
	
	
	for(var i=0;i<ck.length;i++){
		if(ck[i].checked==true){
			ck[i].checked=false;
		}else{
			ck[i].checked=true;
		} 
	}
}

//批量删除
function deleteall(){
	var ids="";
	//取到对象数组
	var ck = document.getElementsByName("ck");
	
	
	for(var i=0;i<ck.length;i++){
		if(ck[i].checked==true){
			ids += ","+ck[i].value;
		}
	}
	ids=ids.substring(1);
	alert(ids);
	alert("批删成功！");
	location.href="<%=request.getContextPath()%>/deleteall?ids="+ids;
}
</script>
</head>
<body>
<center>
	<h1>电商管理平台-商品管理功能</h1>
	<form action="list" method="post">
		<input type="text" name="name">
		<input type="submit" value="搜商品">
	</form>
	<form action="riqi" method="post">
		<input type="text" name="dis">
		<input type="submit" value="搜描述">
	</form>
	<form action="riqi1" method="post">
		<input type="text" name="time1">
		<input type="submit" value="日期查询">
	</form>
	<a href="<%=request.getContextPath()%>/toAdd">添加商品</a>
	<input type="button" value="批量删除" onclick="deleteall()">
	<table>
		<tr>
			<td><input type="checkbox" onclick="choice()">全选/反选 </td>
			<td>ID</td>
			<td>商品名称</td>
			<td>描述</td>
			<td>单价</td>
			<td>创建日期</td>
			<td>更新日期</td>
			<td>发布状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="c">
			<tr>
				<td><input type="checkbox" name="ck" value="${c.id}"></td>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td>${c.dis}</td>
				<td>${c.price}</td>
				<td>${c.time1}</td>
				<td>${c.time2}</td>
				<td>${c.status}</td>
				<td>
					<a href="#">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
				${page}
			</td>
		</tr>
	</table>
</center>
</body>
</html>