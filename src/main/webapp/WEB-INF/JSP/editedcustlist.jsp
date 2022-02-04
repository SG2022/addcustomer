<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form name="myform" action="/save.html" method="post">
<c:if test="${!empty customer}">
<table align="center" border="2">
<tr> 
<th>ID</th>
<th>Name</th>
<th>Address</th>
</tr>

<c:forEach items="${customer}" var="customers">
<tr>
<td><c:out value="${customers.id}"></c:out></td>
<td><c:out value="${customers.name}"></c:out></td>
<td><c:out value="${customers.address}"></c:out></td>
<td><a href="edit.html?id=${customers.id}">EDITTTTTTTT</a>|| <a href="delete.html?id=${customers.id}">DELETE</a></td>

</tr>
</c:forEach>
</table>
</c:if>
</form:form>
</body>
</html>