<%@page import="model.sanpham"%>
<%@page import="java.util.List"%>
<%@page import="database.sanphamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ Admin</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<style>
.a1{
  margin-top: 50px;
  padding-left: 50px ;
  padding-right: 50px ;
  margin-left: 20px
}

.a2{
  font-size: 25px;
  margin-top: 50px;
  text-align: center;
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

  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="admin2.jsp">Trang Chủ </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="admin.jsp">Thêm sản phẩm</a>
          </li>
            <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="donhang.jsp">Đơn Hàng</a>
          </li>
        
          <li class="nav-item dropdown">
            
          </li>
          
        </ul>
      
      </div>
    </div>
  </nav>

  <div class="a2">
  <p> Thông Tin Sản Phẩm</p>  
  </div>
  <div class="a1"> 
   



    <div class="body">
<%   String url1= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
        		+ request.getContextPath();  
    	
        		%>
        		
        		<%   sanphamDao spd = new sanphamDao() ;
        		List<sanpham> sp = spd.selectAll() ; 
                 
%>
      <table class="table">
          <thead>
            <tr>
              <th scope="col">Mã Sản Phẩm</th>
              <th scope="col">Tên Sản Phẩm</th>
              <th scope="col">Số Lượng</th>
              <th scope="col">Giá Tiền</th>
              <th scope="col" >Hình Ảnh</th>
            </tr>
          </thead>
          <tbody>
            <% if ( !sp.isEmpty()) {
            for(sanpham p: sp ){%>
            <tr>
           
              <th scope="row"><%= p.getMasanpham() %></th>
              <td class="i"><%= p.getTensanpham() %></td>
              <td class="i"><%= p.getSoluong() %></td>
              <td class="i"><%= p.getGiatien() %></td>
              <td> <img class="i1" src="<%= url1 %>/anh/<%=p.getAnhsanpham()%>" alt=""></td>
              <td><a type="submit" class="btn btn-primary btn-sm" href="thaydoisp.jsp?msp=<%= p.getMasanpham() %> &tensp=<%= p.getTensanpham() %>&sl=<%= p.getSoluong()%>&gt=<%= p.getGiatien() %>"> Chỉnh Sửa</a> </td>
              <td><a type="submit" class="btn btn-sm btn-danger" href="xoasanpham?id=<%= p.getMasanpham() %>"> Xóa Sản Phẩm</a> </td>
        
            </tr>
             <% } 
            
            }%>
          </tbody>
        </table>
  </div>


  </div>

 


</body>
</html>