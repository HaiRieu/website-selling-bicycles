<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  
</head>
<body>

<%
    Object obj = session.getAttribute("taikhoan") ; 
     khachhang kh = (khachhang)obj ;
     String ten = kh.getTenkhachhang() ; 
     String gioitinh = kh.getGioitinh() ; 
     String sodienthoai  = kh.getSodienthoai() ; 
     String diachi = kh.getDiachi() ; 
     String email = kh.getEmail() ; 
     String duongdananh = kh.getDuongdananh() ; 
     
     String url1= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();


%>
<div class="mb-3 mg-3">
<div class="mb-3">
  <label for="" style = "font-weight: bold;" >Họ tên :  </label> <span> <%= ten %> </span>
</div>
<div class="mb-3">
  <label for=""  style = "font-weight: bold;">Giới Tính : </label> <span><%= gioitinh %>  </span>
</div>
<div class="mb-3">
  <label for=""  style = "font-weight: bold;">Số Điện Thoại :</label> <span> <%= sodienthoai %> </span>
</div>
<div class="mb-3">
  <label for=""  style = "font-weight: bold;">Địa chỉ :</label><span> <%= diachi %></span>
</div>
<div class="mb-3">
  <label for=""  style = "font-weight: bold;">Email :</label><span><%= email %> </span>
</div>
<div class="mb-3">
  <image src = "<%= url1 %>/anh/<%= duongdananh %>" alt="Ảnh Avatar"   width = "400" hegiht = "400"> 
</div>

<div class="mb-3">
 <a href ="thaydoithongtin.jsp"> Thay đổi thông tin</a>
</div>
</div>
</body>
</html>