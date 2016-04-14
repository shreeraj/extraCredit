<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Artist Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<spring:url value="/resources/custom.js" var="mainJS" />
<script src="${mainJS}"></script>
</head>
<body>
<c:if test="${empty artistForm.name}">
		<h1>Add Artist</h1>
	</c:if>
	<c:if test="${not empty artistForm.name}">
		<h1>Update Artist</h1>
	</c:if>
	
<%-- 	<c:if test="${empty artistForm.name}"> --%>
<%-- 		<spring:url value="add" var="actionUrl" /> --%>
<%-- 	</c:if> --%>
<%-- 	<c:if test="${not empty artistForm.name}"> --%>
<%-- 		<spring:url value="edit/${ artistForm.artist_id}" var="actionUrl" /> --%>
<%-- 	</c:if> --%>
	<form:form method="post" modelAttribute="artistForm" action="../edit/${ artistForm.id}">
	
		
		<table>
			
						<tr>
							<td><label>Name</label></td>
							<td><form:input path="name" type="text" /></td>
						</tr>
						<tr>
							<td><label>Date Of Birth</label></td>
							<td><form:input path="DOB" type="text" /></td>
						</tr>
						<tr>
							<td><label>Birth Place</label></td>
							<td><form:input path="POB" type="text" /></td>
						</tr>
						<tr>
							<td><label>About</label></td>
							<td><form:input path="biography" type="text" /></td>
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