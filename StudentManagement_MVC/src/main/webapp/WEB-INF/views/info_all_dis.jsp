<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>학사정보 전체 조회</title>
</head>
<body>
<div class="container">
	<jsp:include page="/resources/common/menu.jsp"></jsp:include>
	
<table width="500" class="table table-hover">
	<tr>
		<th>
			주민번호
		</th>
		<th>
			학사번호
		</th>
		<th>
			이름
		</th>
		<th>
			사진
		</th>
		<th>
			Tel
		</th>
		<th>
<a href="info_all_dis?sort_column=created_date&cuurent_sort=desc">
	작성일자&nbsp;<i class="fas fa-caret-up"></i>
</a>
			
		</th>
	</tr>	
	<c:forEach items="${al_sub_infoData}" var="infoData">
		<tr>
			<td>
			${infoData.getJumin_no()}
			</td>
			<td>
			${infoData.getStudent_no()}
			</td>
			<td>
			${infoData.getName()}
			</td>
			<td>
				<img src="show_image/${infoData.getJumin_no()}" 
					class="img-thumbnail" width="200" height="100" />
			</td>
			<td>
			${infoData.getTel()}
			</td>
			<td>
			<fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" 
         value = "${infoData.getCreated_date()}" />
			
			</td>
		</tr>	
	</c:forEach>
</table>

<table align="center">
	<tr>
		<td>
			<a href="info_all_dis?paging_gubun=first">
			<button type="button" class="btn btn-outline-secondary btn-sm">처음</button>
			</a>
			<a href="info_all_dis?paging_gubun=previous">
			<button type="button" class="btn btn-outline-secondary btn-sm">이전</button>
			</a>
			
			&nbsp;
			<span class="badge">${current_page}</span>
			/
			<span class="badge">${total_page}</span>
			&nbsp;
			
			<a href="info_all_dis?paging_gubun=next">
			<button type="button" class="btn btn-outline-secondary btn-sm">다음</button>
			</a>
			<a href="info_all_dis?paging_gubun=last">
			<button type="button" class="btn btn-outline-secondary btn-sm">마지막</button>
			</a>
		</td>
		<td>
		 &nbsp;&nbsp;&nbsp;표시건수
		</td>
		<td>
			<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    ${records_per_page}
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="info_all_dis?records_per_page=5">5</a>
    <a class="dropdown-item" href="info_all_dis?records_per_page=6">6</a>
    <a class="dropdown-item" href="info_all_dis?records_per_page=7">7</a>
    <a class="dropdown-item" href="info_all_dis?records_per_page=8">8</a>
    <a class="dropdown-item" href="info_all_dis?records_per_page=9">9</a>
    <a class="dropdown-item" href="info_all_dis?records_per_page=10">10</a>
  </div>
</div>
		</td>
	</tr>
</table>

<jsp:include page="/resources/common/footer.jsp"></jsp:include>
	</div>
	
	<jsp:include page="/resources/common/bootstrap.jsp"></jsp:include>
</body>
</body>
</html>

