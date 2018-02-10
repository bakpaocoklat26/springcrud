<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mahasiswa</title>
</head>
<body>
	<div align="center">
		<h1>List Mahasiswa</h1>
		
		<table border="1">

			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="mahasiswa" items="${listMhs}">
				<tr>

					<td>${mahasiswa.name}</td>
					<td>${mahasiswa.email}</td>
					<td>${mahasiswa.address}</td>
					<td>${mahasiswa.telephone}</td>
					<td><a href="editMhs?id=${mahasiswa.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteMhs?id=${mahasiswa.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			Mahasiswa Baru? <a href="tambah">here</a>
		</h4>
	</div>
</body>
</html>