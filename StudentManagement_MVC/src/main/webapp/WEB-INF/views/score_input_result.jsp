<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>성적정보 결과</title>

<style>
.error {
	color: #ff0000;
	font_style: italic;
	font_weight: bold
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="/resources/common/menu.jsp"></jsp:include>

		<table width="500" class="table table-hover">
			<tr>
				<td>학사번호</td>
				<td>${scoreData.student_no}
				</td>
			</tr>

			<tr>
				<td>국어</td>
				<td>${scoreData.guk}
				</td>
			</tr>
			<tr>
				<td>산수</td>
				<td>${scoreData.math}
				</td>
			</tr>
			<tr>
				<td>사회</td>
				<td>${scoreData.sahee}
				</td>
			</tr>
			
		</table>

		<jsp:include page="/resources/common/footer.jsp"></jsp:include>
	</div>

	<jsp:include page="/resources/common/bootstrap.jsp"></jsp:include>
</body>
</body>
</html>

