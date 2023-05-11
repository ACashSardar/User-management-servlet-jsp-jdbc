<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
		font-family: Monaco;
		background: lavender;
	}
</style>
</head>
<body>
	<div align="center">
		<form action="Register" method="post">
			<table border="1" cellpadding="5">
				<caption>
					<h3>Registration Page</h3>
				</caption>
				<tr>
					<td>Enter your name</td>
					<td><input type="text" name="name" required="required" style="padding: 5px"></td>
				</tr>
				<tr>
					<td>Enter your email</td>
					<td><input type="text" name="email" required="required" style="padding: 5px"></td>
				</tr>
				<tr>
					<td>Enter your password</td>
					<td><input type="text" name="password" required="required" style="padding: 5px"></td>
				</tr>
				<tr>
					<td>Enter your role</td>
					<td><select name="role" style="width: 100%; padding: 5px">
							<option value="user">User</option>
							<option value="admin">Admin</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Already have an account ? </label><a
						href="Login.jsp">Login</a></td>
					<td><input type="submit"
						style="background: blueviolet; border: 2px solid blueviolet; color: white; width: 100%; padding: 5px 10px"
						value="SIGN UP"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>