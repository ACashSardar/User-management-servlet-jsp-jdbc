<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit page</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("email") == null) {
		response.sendRedirect("Login.jsp");
	}
	%>

	<div align="center">
		<form action="Edit?id=${user.id}" method="post">
			<table border="1" cellpadding="5">
				<caption>
					<h5>Welcome🙂, ${user.name}</h5>
				</caption>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" required="required"
						value="${user.name}" style="padding: 5px"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" required="required"
						value="${user.email}" style="padding: 5px"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" required="required"
						value="${user.password}" style="padding: 5px"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><select name="role" style="width: 100%; padding: 5px">
							<option value="${user.role}">${user.role}</option>
					</select></td>
				</tr>
				<tr>
					<td>Action</td>
					<td align="justify"><input value="Update" type="submit"
						style="background: green; color: white; padding: 5px 10px" />
						<button style="background: red; color: white; padding: 5px 10px">Delete
							Account</button></td>
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
		</form>
	</div>
</body>
</html>