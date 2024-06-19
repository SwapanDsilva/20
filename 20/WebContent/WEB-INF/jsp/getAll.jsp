<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td>
			序号
		</td>
		<td>
			姓名
		</td>
		<td>
			年龄
		</td>
		<td>
			操作
		</td>
	</tr>
	<c:forEach items="${listUser}" var ="list">
		<tr>
			<td>
				${list.uId }
			</td>
			<td>
				${list.uName }
			</td>
			<td>
				${list.uAge }
			</td>
			<td>
				<input type="button" value="修改" onclick="toUpd(${list.uId})"/>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html> 
<script>
	function toUpd(id){
		
		location.href="getUserById?uId="+id;
	}
</script>