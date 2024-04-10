<%@page import="model.donhang"%>
<%@page import="database.donhangDao"%>
<%@page import="model.sanpham"%>
<%@page import="java.util.List"%>
<%@page import="database.sanphamDao"%>
<%@page import="model.khachhang"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  
</head>
<style>

    .kh{
        text-align: center;
        font-size: 50px;
        margin-top: 20px;
    }
    .kh2{

        margin-left: 50px;
        font-size: 15px;
    }
    .p1{
        text-align: center;
        font-size: 20px;
       color:  red ;
       font-weight: 600;
    }
    


.i1{
  height: 40px;
  
}
.i{
 font-size: 20px ;
 padding-top: 30px;
}
</style>
<body>


<div class="kh"> 
    <p> Thông Tin Đơn Hàng</p>
</div>

  <div class="kh3"> 
   <p class="p1"> Sản Phẩm Đã Đặt</p>

   <%   String url11 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
        		+ request.getContextPath();  
    	String thanhtoan = request.getAttribute("idd")+ "" ;
        		%>
        		<%   donhangDao dhd = new donhangDao() ;
        		List<donhang> dh = dhd.dodonhang() ; 
                 
%>
   <table class="table">
          <thead>
            <tr>
              <th scope="col">Mã Đơn Hàng</th>
              <th scope="col">Tên Khách Hàng</th>
              <th scope="col">Tên Sản Phẩm</th>
              <th scope="col">Số lương</th>
              <th scope="col">Thành Tiền</th>
            </tr>
          </thead>
          <tbody>
            <% if ( !dh.isEmpty()) {
            for(donhang p: dh ){%>
            <tr>
           
              <th scope="row"><%= p.getMadonhang() %></th>
              <td class="i"><%=p.getMakhachhang() %></td>
              <td class="i"><%=  p.getMsp()  %></td>
              <td class="i"><%= p.getSoluong() %></td>
              <td class="i"><%= p.getGiatien() %></td>
            </tr>
            <% }
            
            }%>
            
          </tbody>
        </table>
  </div>

</body>
</html>