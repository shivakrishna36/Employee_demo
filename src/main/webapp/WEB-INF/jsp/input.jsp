<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="mvc"
	uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Insert title here</title>
				<style type="text/css">
					.error 
					{
						color: threedshadow;
					}
				</style>
	</head>
	<body>
		<spring:form action="save" method="post" modelAttribute="employee">
			<mvc:message code="message.id"></mvc:message>
			<spring:input path="id" /><spring:errors path="id" cssClass="error" />
			<br> 
			<mvc:message code="message.name"></mvc:message>
			<spring:input path="name" /><spring:errors path="name" cssClass="error" />
			<br>
			<mvc:message code="message.salary"></mvc:message>
		 	<spring:input path="salary" /><spring:errors path="salary" cssClass="error" />
			<br>
			<input type="submit" value="submit">
		</spring:form>
	</body>
</html>