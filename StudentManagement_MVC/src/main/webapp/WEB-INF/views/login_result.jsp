<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 결과</title>


</head>
<body>
	<div class="container">
		<jsp:include page="/resources/common/menu.jsp"></jsp:include>

		<div class="card border-primary col-md-8">

			<div class="card-body">
				<h4 class="card-title">로그인</h4>
				<div class="form-group">
					<label for="user_id" class="col-sm-3 control-label">이메일</label>
					<div class="col-sm-9">
						로그인 되었습니다.
					</div>
				</div>
				
			</div>

			<jsp:include page="/resources/common/footer.jsp"></jsp:include>
		</div>

		<jsp:include page="/resources/common/bootstrap.jsp"></jsp:include>
</body>
</html>