<%@page import="model.giohang1"%>
<%@page import="database.giohangDao"%>
<%@page import="model.khachhang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.giohang"%>
<%@page import="database.sanphamDao"%>
<%@page import="model.sanpham"%>
<%@page import="java.util.List"%>
<%@page import="database.khachhangDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">


   
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
.hihi{
magin-top:100px ; 
text-align: center;
}
</style>
<body>

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
     giohangDao ghd = new giohangDao() ;
      List<giohang1> gh = ghd.timkiemdh(makhachhang) ;
    
  
%>
    <div class="giohang"> 
        <h1>Giỏ hàng của tôi : </h1>
    </div>


    <div class="body">

        <table class="table">
            <thead>
              <tr>
                <th scope="col">Mã Giỏ Hàng</th>
                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Số Lượng</th>
                <th scope="col">Giá Tiền</th>
                <th scope="col">Mua Hàng</th>
              </tr>
            </thead>
            <tbody>
             <%
             long tong = 0 ; 
           
             if ( !gh.isEmpty()) {
            for(giohang1 p : gh){	
            	
            	tong += p.getGiatien() ; 
           	 
            	%>
            	 <tr>
                <th scope="row" name = "id"> <%= p.getMagiohang() %></th>
                <td> <%= p.getMakhachang() %></td>
              
                  <td>  <div class="form-group d-flex justify-content-between">
                <a  class="btn btn-sm btn-decre"  href = "giamsl?id=<%= makhachhang %>&mgh=<%= p.getMagiohang() %>&msp=<%= p.getMasanpham() %>"><i class="fas fa-minus-square"></i></a>				
				<input type="text"name="soluong" id="soluong" class="form-control"  value="<%= p.getSoluong() %>" > 
				<a  class="btn bnt-sm btn-incre"  href ="tangsl?id=<%= makhachhang %>&mgh=<%= p.getMagiohang() %>&msp=<%= p.getMasanpham() %>" ><i class="fas fa-plus-square"></i></a> 			
				</div > </td>
				
				
                 <td><input id="giatien" value="<%=  p.getGiatien() %>" readonly></td>
             <td><a type="submit" class="btn btn-primary btn-sm" href="thanhtoangiohang?id=<%= p.getMasanpham()%>&gia=<%= p.getGiatien() %>&soluong=<%= p.getSoluong() %>&magiohang=<%= p.getMagiohang()%>"> Buy  </a> </td>
              <td><a type="submit" class="btn btn-sm btn-danger" href="xoagiohang?id=<%= p.getMagiohang()%>"> Delete</a> </td>
              </tr>
              
              <% 
             
        	}
            }
            %>
              
                 
            </tbody>
          </table>
    </div>
   
    <div class = "hihi"> 
    <p>Tổng Tiền : <%= tong  %> VNĐ </p>
    <a type="submit" class="btn btn-primary btn-sm"href= "thanhtoangiohanghihi"> Thanh Toán  </a>
  
 
 
  
    </div>
      



</body>

</html>