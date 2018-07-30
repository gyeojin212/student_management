<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <title>Home</title>
  
    <style>
      #map {
        height: 400px;
        width: 60%;
       }
    </style>
  </head>
  
  <body>
   <div class="container">
    
    <jsp:include page="/resources/common/menu.jsp"></jsp:include>
    
    <h3 >맵</h3>
    <div id="map"></div>
    
    <jsp:include page="/resources/common/footer.jsp"></jsp:include>
    
    <script>
      function initMap() {
        var url이젠컴퓨터학원 = {lat: 36.361942, lng: 127.378980};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 18,
          center: url이젠컴퓨터학원
        });
        var marker = new google.maps.Marker({
          position: url이젠컴퓨터학원,
          map: map
        });
      }     
    </script>
    </div>
    
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCe2vHW19340kgaUW19_KgnTSJWdmtXov4&callback=initMap">
    </script>

	<jsp:include page="/resources/common/bootstrap.jsp"></jsp:include>
      
  </body>
</html>