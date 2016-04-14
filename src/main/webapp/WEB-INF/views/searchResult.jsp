<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Extra Credit</title>
</head>
<body>

	<h4>Search Result</h4>
	<table border="1">
		<thead>
			<tr>
				<td>Title</td>
				<td>Year</td>
				<td>Action</td>
			</tr>
		</thead>
		<c:forEach items="${movies}" var="movie">

			<tr>
				<td>${movie.title}</td>
				<td>${movie.year}</td>
				<td><a href="../movie/edit/${movie.id}">Edit</a> <a
					href="../movie/delete/${movie.id} ">Delete</a></td>

			</tr>
		</c:forEach>
	</table>

	<a href="../movie/add">Add Movie</a>
	<a href="../movie/search">Search Movie</a>
	
</body>
</html>