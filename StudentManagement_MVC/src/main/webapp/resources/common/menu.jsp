<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="index.jsp">학사관리시스템</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link " href="index.jsp">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>

	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        성적 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="score_add.jsp">등록</a>
        <a class="dropdown-item" href="acore_all_dis.jsp">전체 조회</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
    
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        정보 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="info_add.jsp">등록</a>
        <a class="dropdown-item" href="info_all_dis">전체 조회</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
    
    <li class="nav-item 
    	<c:if test="${current_menu eq 'my_map'}">
    		active
    	</c:if>
    
    "> 
    	
      <a class="nav-link" href="my_map">찾아 오시는 길</a>
    </li>
      
   
	
  </ul>
</nav>

<br /><br />