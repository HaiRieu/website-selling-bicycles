<%@page import="database.donhangDao"%>
<%@page import="model.binhluan"%>
<%@page import="java.util.List"%>
<%@page import="database.binhluanDao"%>
<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>giới thiệu</title>
   <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="themify-icons/themify-icons.css" >
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/gioithieu.css">
</head>
<body>
    <div id="app">

      <div id="header">
        <div class="header-icon">
        
         <ul class="ul-icon">
           <li><a href="">
            <i class="ti-user"></i>
            <span class="span1">Quan Hệ Cổ Đông</span>
           </a></li>
           <li><a href=""> 
            <i class="ti-map-alt"></i>
            <span>Cửa Hàng</span>
           </a></li>
            <li> <a href=""  class="a-icon">
                <i class="ti-headphone"></i>
                <span class="sp1">1800 54 54 57</span>
            </a></li>
           
         </ul>
         <div class="img-icon"> <img src="img/01HpIkbEsT7s2.png" alt=""> </div>
          <%  
                              Object obj = session.getAttribute("taikhoan") ; 
                        khachhang kh = null ;
                        if(obj != null ) 
                          kh = (khachhang)obj ; 
                        if(kh == null ) {
                          
                          
                     
                              %>
            <div class="shope">
            <a href="dangnhap.jsp" class="a1">
            <span class="sp1a" >Đăng Nhập</span></a>
            </div>
                              
                              <% }  else { %>
         <div class="shope">
            <a href="giohang.jsp" class="a1"><i class="ti-shopping-cart"></i></a>
            <span class="sp1a" >Giỏ Hàng</span>
         </div>
         
        
        <div class = "sua1">
           <div class="dropdown">
             
              <ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
                 <li class="nav-item dropdown dropstart"><a
                    class="nav-link dropdown-toggle" href="#" role="button"
                    data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
                    <ul class="dropdown-menu">
                       <li><a class="dropdown-item" href="thaydoianh.jsp">Thay đổi ảnh</a></li>
                       <li><a class="dropdown-item" href="thongtincanhan.jsp"> Thông Tin Cá Nhân </a></li>
                       <li><a class="dropdown-item" href="thaydoithongtin.jsp">Thay đổi thông tin</a></li>
                       <li><a class="dropdown-item" href="doimatkhau.jsp">Đổi mật khẩu</a></li>
                       <li><hr class="dropdown-divider"></li>
                       <li><a class="dropdown-item" href="dangxuat">Thoát tài khoản</a></li>
                    </ul></li>
              </ul>
            </div>
            </div>
             <% } %>
        
        </div> 
        <hr class="ngang1"  width="90%" align="center" size="0.5px" />
        
        <div class="header-icon1">
          <ul class="ul-icon1">
            <li class="l-icon"> <a href="trangchu">Trang Chủ</a></li>
            <li><a  href="xedapnu"> Xe Đạp Nữ</a></li>
            <li><a href="xedapgap" > Xe Đạp Gấp</a></li>
            <li><a href="xedapdua"> Xe Đạp Đua</a></li>
            <li><a href="xetroluc"> Xe Đạp Trẻ Em</a></li>
            <li><a href=""> Phụ Kiện</a></li>
            <li><a href="" class="a-kuyen"> Khuyến Mãi</a></li>
          </ul>
        
          <div class="timkiem">
          <form class="d-flex"  action = "noidungtimkiem" method = "post">
            <input type="text" name="txt" id="" class="tk-icon" placeholder="Tìm Kiếm Nhanh" aria-label="Search" >
            <button class="ti-search" type="submit" > </button>
            </form>
        </div>
        <%   String url1= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
        		+ request.getContextPath();  
    	
        		%>
        </div>
        </div>
         <div class="body1">
           <div class="body-left">
          <div class="body-left1">
            <div class="tatcaanh">
              <a href=""> <img id="imgchinh" src="<%= url1 %>/anh/${id.anhsanpham}" alt=""> </a>
            </div> 
          </div>
          </div> 
        <div class="body-right">
          <div class="tensp">
            <p>${id.tensanpham}</p>
          </div>
          <div class="sanpham2" >
            <p >${id.giatien} đ</p>
          </div>
          <div class="sanpham3">
            <p>(Sắp hết hàng)</p>
          </div>
          
          <div class="sanpham4">
           <%  
                      Object obj2 = session.getAttribute("taikhoan") ; 
					      khachhang kh2 = null ;
					      if(obj2 != null ) 
					    	  kh2 = (khachhang)obj ; 
					      if(kh2 == null ) {
					    	  
					    	  
						 
                      %>
                          <a href="dangnhap.jsp"> 
              <p class="p1"> MUA NGAY</p>
              <p class="p2"> Miễn phí giao hàng tận nhà hoặc mua tại cửa hàng</p>
            </a>
                      
                      
                      <% 
					      }else {
                      %>
            <a href="thanhtoan?id=${id.masanpham}&gia=${id.giatien}"> 
              <p class="p1"> MUA NGAY</p>
              <p class="p2"> Miễn phí giao hàng tận nhà hoặc mua tại cửa hàng</p>
            </a>
            <% } %>
          </div>
          <div class="sanpham5">
            <div class="sanpham5a">
            <% if(kh == null) {
            	 
            	%> 
            	
            	<p class="p1"> <a href = "dangnhap.jsp">Thêm Vào Giỏ Hàng</a> </p>
            <%
            }else {
            	
            
            %>
            
              <p class="p1"> <a href = "themvaogiohang2?id=${id.masanpham}&gia=${id.giatien}">Thêm Vào Giỏ Hàng</a> </p>
              
              <% } %>
            <p class="p2"> Chỉ từ 304.167 đ/tháng</p>
            </div>
            <div class="sanpham5b">
              <p class="p1"> CỬA HÀNG CÓ HÀNG</p>
              <p class="p2"> GỌI NGAY giữ hàng & nhận ưu đãi</p>
            </div>
            
          </div>
          <div class="sanpham6">
             <p><ti class="ti-check"></ti> Miễn phí giao nhanh Toàn Quốc 1-7 ngày, xem thêm Chính sách giao hàng</p>
          </div>
        </div>
      
      </div>

     
        <div class="combo1">
     <% 
     binhluanDao bld = new binhluanDao();
       List<binhluan> bl = bld.noidung() ; 
       
     %>
     
   <form action="binhluannd" method="GET">
        
         <p class="p1"> Bình Luận </p>
         <hr  width="98%" size="2px" align="center" />
         
         <% if ( !bl.isEmpty()) {
            for(binhluan p: bl ){
            	%>
            
         <p class="p2"> <%= p.getMakhachhang() %> : <%= p.getNoidung() %></p> 
         
         <% } 
         }
         %>
        
         <%  
       
      
        
     if(kh != null ) {
     
     
        donhangDao dhd = new donhangDao() ;
        String mkh = kh.getMakhachhang();
         if(!dhd.kiemtradonhang(mkh)) {
       
         %>
         
      
	   <%} else { %>  
	    <div class="binhluanhoa">
           <input type="text" class="p3"  id="binhluan" name="binhluan" required="required" value = "" >
         </div>
	     <div class="binhluan">
      <input class="btn btn-primary form-control" type="submit"
						value="Bình Luận" name="submit" id="submit"  />
	   </div>  
	   <%  } }%> 
      </form>
        </div>
      

       
         <div class="combo3">
          <hr  width="96%" size="2px" align="center" />
         </div>
      </div>
        
        
    </div>

 

    </div>
  
</body>
</html>