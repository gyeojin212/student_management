<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" 
		uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>성적정보 등록</title>

<style>
	.error {
		color:#ff0000;
		font_style: italic;
		font_weight: bold
	}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="/resources/common/menu.jsp"></jsp:include>

	<springform:form action="score_input_process"	
			modelAttribute="scoreData" method="post">

			<table width="500" class="table table-hover">
				<tr>
					<td>학사번호</td>
					<td>
					 <springform:input path="student_no" 
						placeholder="학사번호 입력" />
					 <br/>
					 <springform:errors cssClass="error" path="student_no" />	
					</td>
				</tr>
				
				<tr>
					<td>국어</td>
					<td>
					 <springform:input path="guk" 
						placeholder="국어성적 입력" />
					 <br/>
					 <springform:errors cssClass="error" path="guk" />	
					</td>
				</tr>
				<tr>
					<td>산수</td>
					<td>
					 <springform:input cssClass="error" path="math" 
						placeholder="산수성적 입력" />
					 <br/>
					 <springform:errors path="math" />	
					</td>
				</tr>
				<tr>
					<td>사회</td>
					<td>
					 <springform:input cssClass="error" path="sahee" 
						placeholder="사회성적 입력" />
					 <br/>
					 <springform:errors path="sahee" />	
					</td>
				</tr>
				<tr>
					<td colpan="2" align="center"><input type="submit" value="등 록">
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

