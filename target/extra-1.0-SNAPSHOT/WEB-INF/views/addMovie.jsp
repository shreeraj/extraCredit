<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Movie</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<spring:url value="/resources/custom.js" var="mainJS" />
<script src="${mainJS}"></script>
</head>
<body>
	<h1>Add Movie</h1>
	<form:form method="post" modelAttribute="movieForm" action="add">
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" type="text" /></td>
				<td><form:errors path="title" /></td>
			</tr>
			<tr>
				<td>Year</td>
				<td><form:input path="year" type="text" /></td>
				<td><form:errors path="year" /></td>
			</tr>
			<tr>
				<td>Summary</td>
				<td><form:textarea path="summary" rows="5" cols="30" /></td>
				<td><form:errors path="summary" /></td>
			</tr>

			<tr>
				<td>Genre</td>
				<td><form:select path="genere">
						<form:option value="">Select Movie Genere:</form:option>
						<c:forEach items="${genere}" var="genere">
							<form:option value="${genere}">${genere}</form:option>
						</c:forEach>
					</form:select></td>
				<td><form:errors path="genere" /></td>
			</tr>

			<tr>
				<td>Rating</td>
				<td><form:select path="rating">
						<option value="BAD">BAD</option>
						<option value="OK">OK</option>
						<option value="GOOD">GOOD</option>


					</form:select></td>
				<td><form:errors path="rating" /></td>
			</tr>

		</table>
		<table>
			<h3>Directors</h3>
			<div id="direcotrDiv">
				<c:forEach items="movieForm.director" var="director"
					varStatus="status">
					<td><label>Name</label></td>
					<td><form:input path="director[0].name" type="text" /></td>
					<div id="moreDirector"></div>
				</c:forEach>
			</div>

			<a href="javascript:void(0);" onclick="more_director()">+Add More</a>

		</table>
		<h3>Artists</h3>
		<table>
			<c:forEach items="movieForm.artist" var="artist" varStatus="status">
				
				<tr>
					<td><label>Name</label></td>
					<td><form:input path="artist[0].name" type="text" /></td>
				</tr>
				<tr>
					<td><label>Date Of Birth</label></td>
					<td><form:input path="artist[0].DOB" type="text" /></td>
				</tr>
				<tr>
					<td><label>Birth Place</label></td>
					<td><form:input path="artist[0].POB" type="text" /></td>
				</tr>
				<tr>
					<td><label>About</label></td>
					<td><form:input path="artist[0].biography" type="text" /></td>
				</tr>
				
				<div id="moreArtist"></div>
			</c:forEach>
			<tr>
				<td><a href="javascript:void(0);" onclick="more_artist()">+Add
						More</a></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>