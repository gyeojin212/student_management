<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" 
		uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>학사정보 등록</title>

<style>
	.error {
		color:red;
		font_style: italic;
		font_weight: bold
	}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="/resources/common/menu.jsp"></jsp:include>

	<springform:form action="info_input_process" 
		modelAttribute="infoDataView"	
			method="post" 
			enctype="multipart/form-data">

			<table width="500" class="table table-hover">
				<tr>
					<td>주민번호</td>
					<td>
					 <springform:input path="jumin_no" 
						placeholder="주민번호 입력" />
						<br />
						<springform:errors cssClass="error" path="jumin_no" />	
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
					 <springform:input path="name" 
						placeholder="이름 입력" />
						<br />
						<springform:errors cssClass="error" path="name" />	
					</td>
				</tr>
				<tr>
					<td>사진</td>
					<td>
					 <input type="file" name="picture" >
					</td>
				</tr>
				<tr>
					<td>핸드폰 번호</td>
					<td>
					 <springform:input path="tel" 
						placeholder="123-456-7890" />
						<br />
						<springform:errors cssClass="error" path="tel" />	
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="등 록">
					</td>
				</tr>
			</table>
		</springform:form>
		<jsp:include page="/resources/common/footer.jsp"></jsp:include>
	</div>

	<jsp:include page="/resources/common/bootstrap.jsp"></jsp:include>
</body>
</body>
</html>

