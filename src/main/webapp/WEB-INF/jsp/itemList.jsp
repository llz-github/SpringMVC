<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
<form
		action="${pageContext.request.contextPath }/queryItem.action"
		method="post">
		查询条件（空则显示全部商品）：
		<table width="100%" border=1>
			<tr>
				<!-- 
<td><input type="text" name="queryStr"></td>
 -->
				<td>商品名称<input type="text" name="item.name">
				</td>
				<td>商品Id<input type="text" name="item.id">
				</td>
				<td>商品详情<input type="text" name="item.detail">
				</td>
				<td><input type="submit" value="查询" /></td>
			</tr>
		</table>
	</form>
	<form
		action="${pageContext.request.contextPath }/deleteItems.action">
		商品列表：<br>
		<td><a href="${pageContext.request.contextPath }/itemInsert.action">添加商品</a>
		<table width="100%" border=1>
			<tr>
				<td>选择</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${ItemList }" var="item" varStatus="s">
				<tr>
					<td><input type="checkbox" name="ids" value="${item.id}" /></td>
					<td><input type="hidden" name="ItemList[${s.index}].id"
						value="${item.id }" /> <input name="ItemList[${s.index}].name"
						value="${item.name }" /></td>
					<td><input name="ItemList[${s.index}].price"
						value="${item.price }" /></td>
					<td><input type="text" name="ItemList[${s.index}].createtime"
						value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
					</td>
					<td><input type="text" name="ItemList[${s.index}].detail"
						value="${item.detail }" /></td>
					<td><a
						href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a>
					</td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="6"><input type="submit" value="删除"></td>
			</tr>
		</table>
	</form>
</body>

</html>