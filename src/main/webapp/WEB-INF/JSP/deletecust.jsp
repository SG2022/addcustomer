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


<h1>Deleted customer with </h1>
<table align="center" border="2">
<tr> 
<th>ID</th>

</tr>


<tr>
<td><c:out value="${customer.id}"></c:out></td>
<c:out value="hello">  </c:out>
</tr>
</table>


</body>
</html>