<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

.error {
	color: #ff0000;
	font_style: italic;
	font_weight: bold
}

</head>
<body>
	<div class="container">
		<jsp:include page="/resources/common/menu.jsp"></jsp:include>

	<div class="card border-primary col-md-8">
      
      <div class="card-body">
        <h4 class="card-title">로그인</h4>
        <springform:form class="form-horizontal" action="login_process" 
        	modelAttribute="login"     
        	method="post">
            <div class="form-group">
             
	<c:forEach var="error" items="${errors.allErrors}">
		<b><springform:form message="${error}" /></b>
		<br />
	</c:forEach>
    
              <springform:errors path="*" class="has-error"></springform:errors>
              <label for="user_id" class="col-sm-3 control-label">이메일</label>
              <div class="col-sm-9">
                <springform:input type="email" class="form-control" 
                     path="user_id" placeholder="이메일 입력" 
                />
                <br />
                <springform:errors path="user_id" cssClass="error" ></springform:errors>
              </div>
            </div>
            <div class="form-group">
              <label for="password" class="col-sm-3 control-label">비밀번호</label>
              <div class="col-sm-9">
                <springform:input type="password" class="form-control" 
                	path="password" placeholder="비밀번호 입력" />
                <br />
                <springform:errors path="password" cssClass="error" ></springform:errors>	
              </div>
            </div>
            
            <div class="form-group">
              <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-default">로그인</button>
              </div>
            </div>
          </springform:form>

      </div>		
		

		<jsp:include page="/resources/common/footer.jsp"></jsp:include>
	</div>

	<jsp:include page="/resources/common/bootstrap.jsp"></jsp:include>

</body>
</html>