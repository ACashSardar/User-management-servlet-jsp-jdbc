<%@page import="java.io.PrintWriter"%>
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
		<form action="Login" method="post">
			<table border="1" cellpadding="5">
				<caption>
					<h3>Login Page</h3>
				</caption>
				<tr>
					<td>Enter your email</td>
					<td><input type="text" name="email" placeholder="e.g xyz@gmail.com" required="required"
						style="padding: 5px"></td>
				</tr>
				<tr>
					<td>Enter your password</td>
					<td><input type="text" name="password" placeholder="password" required="required"
						style="padding: 5px"></td>
				</tr>
				<tr>
					<td><label>Don't have an account ? </label><a
						href="Register.jsp">SignUp</a></td>
					<td><input type="submit"
						style="background: green; border: 2px solid green; color: white; width: 100%; padding: 5px 10px"
						value="LOGIN"></td>
				</tr>
			</table>
		</form>
		<%
		if (request.getParameter("logout") != null && request.getParameter("logout").equals("true")) {
		%>
		<h5 style="color: blue">You've been logged out.</h5>
		<%
		}
		%>

		<%
		if (request.getParameter("signup") != null && request.getParameter("signup").equals("true")) {
		%>
		<h5 style="color: green">You've been registered successfully.
			Please Login.</h5>
		<%
		}
		%>

		<%
		if (request.getParameter("error") != null && request.getParameter("error").equals("true")) {
		%>
		<h5 style="color: red">Invalid credentials. Please check email
			and password.</h5>
		<%
		}
		%>
	</div>

</body>
</html>