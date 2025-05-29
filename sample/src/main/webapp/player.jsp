<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>プレイヤー一覧</title>
	<link href="css/bootstrap.min" rel="stylesheet">
</head>
<body class="container mt-4">
	<div class="d-flex justify-content-between align-items-center mb-3">
		<h2>プレイヤー一覧</h2>
		<a href="PlayerAddServlet" class="btn btn-success">新規追加</a>
	</div>

	<div class="table-responsive">
	<table class="table table-bordered table-striped table-hover">
		<thead class="table-light">
			<tr>
				<th>#</th>
				<th>名前</th>
				<th>ポジション</th>		
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${players}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${item.name}</td>
					<td>${item.position}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

</body>
</html>

