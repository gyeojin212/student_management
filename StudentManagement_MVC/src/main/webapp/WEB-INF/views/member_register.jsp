<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>


</head>
<body>
	<div class="container">
		<jsp:include page="/resources/common/menu.jsp"></jsp:include>

	<div class="card border-primary col-md-8">
      
      <div class="card-body">
        <h4 class="card-title">회원 가입</h4>
        <form class="form-horizontal" action="member_register_process" method="post">
            <div class="form-group">
              <label for="user_id" class="col-sm-3 control-label">이메일</label>
              <div class="col-sm-9">
                <input type="email" class="form-control" name="user_id" id="user_id" placeholder="이메일 입력">
              </div>
            </div>
            <div class="form-group">
              <label for="password" class="col-sm-3 control-label">비밀번호</label>
              <div class="col-sm-9">
                <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호 입력">
              </div>
            </div>
            
            <div class="form-group">
              <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-default">회원 가입</button>
              </div>
            </div>
          </form>

      </div>		
		

		<jsp:include page="/resources/common/footer.jsp"></jsp:include>
	</div>

	<jsp:include page="/resources/common/bootstrap.jsp"></jsp:include>

</body>
</html>