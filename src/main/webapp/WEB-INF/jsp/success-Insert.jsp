<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script language="javascript">
	var times = 3;
	clock();
	function clock() {
		window.setTimeout('clock()', 1000);
		times = times - 1;
		time.innerHTML = times;
	}
</script>

<head>
<meta http-equiv= "Refresh" content= "2;url=/itemList.action"><title>Insert title here</title>
<style type="text/css">
.STYLE1 {
	color: #FF0000
}
</style>
</head>
<body>
	<h2>商品添加成功</h2>
	<table>
		<tr>
			<td class="FontBlack STYLE1">该页面将在</td>
			<td class="FontBlack">
				<div class="STYLE1" id="time">2</div>
			</td>
			<td class="FontBlack STYLE1">秒后自动跳转至首页</td>
		</tr>
	</table>
</body>
</html>
