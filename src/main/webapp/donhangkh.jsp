<%@page import="java.util.List"%>
<%@page import="model.donhang"%>
<%@page import="database.donhangDao"%>
<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn Hàng</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<style>
.giohang{
    margin-top: 50px;
    text-align: center;
}
.body{
    margin-top: 50px;
    margin-left: 100px;
    
}

</style>
<body>

<div class="giohang">
        <h1>Lịch Sử Đơn Hàng Của Tôi : </h1>
    </div>
<%
    Object obj = session.getAttribute("taikhoan") ; 
     khachhang kh = (khachhang)obj ;
     String makhachhang = kh.getMakhachhang();
   
     String url1= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();

%>
<% 
String xacnhan = request.getAttribute("xacnhan") + "" ;
 xacnhan = (xacnhan.equals("null")) ? "Đang Giao" : xacnhan ; 
%>

<% 
     donhangDao dhd = new donhangDao() ;
      List<donhang> dh = dhd.timkiemdh(makhachhang) ;
    
  
%>

    <div class="body">

        <table class="table">
            <thead>
              <tr>
                <th scope="col">Mã Đơn Hàng</th>
                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Số Lượng</th>
                <th scope="col">Giá Tiền</th>
                <th scope="col">Trạng Thái</th>
                 <th scope="col">Xác Nhận</th>
              </tr>
            </thead>
            <tbody>
            <% if ( !dh.isEmpty()) {
            for(donhang d: dh ){
            	%>
         
            	 <tr>
                <th scope="row" name = "id"><%= d.getMadonhang() %> </th>
                <td><%= d.getMakhachhang() %></td>
                <td><%= d.getSoluong() %></td>
                <td><%= d.getGiatien() %></td>
                <td><%= xacnhan %> </td>
                 <td><a type="submit" class="btn btn-primary btn-sm" href="xacnhan"> Đã Nhận Hàng</a></td>
             
              </tr>
              
              <%
            }
            }
            
              %>
              
          
            

</body>
</html>