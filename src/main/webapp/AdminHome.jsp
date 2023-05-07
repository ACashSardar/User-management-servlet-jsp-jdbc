<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
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
				</a><a href="Delete?id=${user.id}" style="text-decoration: none;">
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


	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h5>List of users</h5>
			</caption>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Role</th>
				<th>Action</th>
			</tr>
			<c:forEach var="u" items="${userlist}">
				<tr>
					<td><c:out value="${u.id}" /></td>
					<td><c:out value="${u.name}" /></td>
					<td><c:out value="${u.email}" /></td>
					<td><c:out value="********" /></td>
					<td><c:out value="${u.role}" /></td>
					<c:choose>
						<c:when test='${u.role.equals("user")}'>
							<td><button style="background: red; color: white">Delete</button></td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>