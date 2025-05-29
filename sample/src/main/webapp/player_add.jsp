<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>新規追加</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
	<h2 class="mb-4">新規追加</h2>

	<form action="PlayerAddServlet" method="POST">
		<div class="mb-3 row">
			<label for="name" class="col-sm-2 col-form-label">名前</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" name="name" required>
			</div>
		</div>

		<div class="mb-4 row">
			<label for="position" class="col-sm-2 col-form-label">ポジション</label>
			<div class="col-sm-4">
				<select class="form-select" id="position" name="position" required>
					<option value="">選択してください</option>
					<option value="GK">GK</option>
					<option value="DF">DF</option>
					<option value="MF">MF</option>
					<option value="FW">FW</option>
				</select>
			</div>
		</div>

		<div class="text-end">
			<button type="submit" class="btn btn-primary">OK</button>
		</div>
	</form>

</body>
</html>
