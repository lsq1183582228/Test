<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<center>
	<h1>商品添加界面</h1>
	<form action="add" method="post">
		产品标题：<input type="text" name="name"><br>
		产品描述：<input type="text" name="dis"><br>
		商品分类：
		<select name="tid">
			<option>请点击选择按钮选择商品分类</option>
			<c:forEach items="${type}" var="t">
				<option value="${t.tid}">${t.tname}</option>
			</c:forEach>
		</select>
		<br>
		产品展示价格：<input type="text" name="price" value="请输入正确金额" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"><br>
		库存数量：<input type="text" name="num" value="0-99999" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"><br>
		购买限制数量：<input type="text" name="num1" value="0-9999" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"><br>
		创建日期：<input type="text" name="time1"><br>
		更新日期：<input type="text" name="time2"><br>
		<input type="submit" value="提交">
		<input type="reset" value="重置">
	</form>
</center>
</body>
</html>