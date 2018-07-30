<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>구구단</title>
</head>
<body>
	<c:forEach items="${gugudan}" var="gugu">
		${gugu}<br/> 
	</c:forEach>
	
</body>
</html>
