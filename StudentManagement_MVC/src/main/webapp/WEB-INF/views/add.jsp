<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<table>
		<tr>
			<td>값1</td>
			<td>${value1}</td>
		</tr>
		<td>값2</td>
		<td>${value2}</td>
		</tr>

		<tr>
			<td>합:</td>
			<td>${value1+value2}</td>
		</tr>
	</table>
	<c:forEach items="${s}" var="value">
    ${value}
    </c:forEach>
</body>
</html>
