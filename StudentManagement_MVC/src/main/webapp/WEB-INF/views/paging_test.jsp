<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징 테스트</title>
</head>
<body>
	<table>
		<tr>
			<td>
				주민번호
			</td>
			<td>
				이름
			</td>
		</tr>
		<c:forEach var="infoData" items="${al_sub_infoData}">
			<tr>
				<td>
				${infoData.getJumin_no()}
				</td>
				<td>
				${infoData.getName()}
				</td>
			</tr>
		</c:forEach>
		
	</table>

	<table>
		<tr>
			<td>
			    <a href="paging_test?paging_gubun=first">
					<button type="button">처음</button>
			    </a>
			    <a href="paging_test?paging_gubun=previous">
					<button type="button">이전</button>
			    </a>
			    
			    &nbsp;
			    ${paging_info.nCurrentPage}/${paging_info.nTotalPage}
			    &nbsp;
			    <a href="paging_test?paging_gubun=next">
					<button type="button">다음</button>
			    </a>
			    <a href="paging_test?paging_gubun=last">
					<button type="button">마지막</button>
			    </a>
			</td>
			<td>
				페이지당 표시건수
				<select name="display_count_per_page" 
				onchange="on_change(this.value);">
				  	<option value="5" 
				  		<c:if test="${paging_info.nRecordsPerPage eq 5}">
				  			selected
						</c:if>				  	
				  		>5
			  		</option>
				  	<option value="6" 
				  		<c:if test="${paging_info.nRecordsPerPage eq 6}">
				  			selected
						</c:if>
				  		>6
			  		</option>
		  		  <option value="7" 
				  	<c:if test="${paging_info.nRecordsPerPage eq 7}">
				  		selected
					</c:if>
				  >7</option>
				  <option value="8" 
				  	<c:if test="${paging_info.nRecordsPerPage eq 8}">
				  		selected
					</c:if>
				  >8</option>
				</select>
			</td>
		</tr>
		
	</table>
</body>
</html>
<script>
	function on_change(selected_value) {
		//alert(selected_value);
		window.location.href = 
'paging_test?display_count_per_page=' + selected_value;
	}

</script>