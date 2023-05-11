<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User homepage</title>
<style type="text/css">
	body {
		font-family: Monaco;
		background: lavender;
	}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("email") == null) {
		response.sendRedirect("Login.jsp");
	}
	%>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h5>Welcome🙂, ${user.name}</h5>
			</caption>
			<tr>
				<td>Name</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>${user.password}</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>${user.role}</td>
			</tr>
			<tr>
				<td>Action</td>
				<td align="justify"><a href="Edit?id=${user.id}"
					style="text-decoration: none;">
						<button style="background: blue; color: white; padding: 5px 10px">Edit</button>
				</a> <a href="Delete?id=${user.id}" style="text-decoration: none;">
						<button style="background: red; color: white; padding: 5px 10px">Delete
							Account</button>
				</a></td>

			</tr>
			<tr>
				<td></td>
				<td>
					<form action="Logout">
						<input
							style="background: deeppink; color: white; width: 100%; padding: 5px 10px"
							type="submit" value="Logout" />
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>