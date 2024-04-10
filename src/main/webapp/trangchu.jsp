
<%@page import="model.sanpham"%>
<%@page import="java.util.List"%>
<%@page import="model.khachhang"%>
<%@page import="database.sanphamDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ </title>
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="themify-icons/themify-icons.css" >
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
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
               <li><a class="dropdown-item" href="donhangkh.jsp">Đơn Hàng</a></li>
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

</div>
</div>

<div id="body">
   <div class="body-icon1">
      <div class="ptrang"><p>Trang Chủ /</p></div>
      <div class="ptrang1"><p>Xe</p></div>
   </div>

   <div class="body-icon2">

    <div class="anhcao">
      <img class="anhcao1" id="img" onclick="changeImage()" src="img/banner-mtb-1400x431.jpg" alt="">
     </div>

   <script>
      var index = 1 ;
      function changeImage(){
         var imgs = ["img/bande4.jpg","img/bande2.jpg" , "img/bande3.png" , ] ; 
         document.getElementById('img').src = imgs[index] ; 
         index++ ;
        if(index == 3) {
         index = 0 ;
        }
      }
      setInterval(changeImage,2500);

   </script>

   <div class="caubao">
      <p >Xe Đạp Chính Hãng </p>
   </div>

   </div>

   <div class="body-icon3">
      <div class="anhdai">
         <img class="anhdai1" src="img/2024_Roam1Disc_BlackDiamond-768x768_transparent.png" alt="" title="Thương hiệu độc quyền rạng ngời phong cách" >
      </div>
      <div class="anhdai">
         <img  class="anhdai2" src="img/2024_Talon2_MetallicBlack-768x768.jpg" alt="" title="sdsdsds">
      </div>
      <div class="anhdai">
         <img  class="anhdai3" src="img/Fuji_Orange-768x768.jpg" alt="">
      </div>
      <div class="anhdai">
         <img  class="anhdai4" src="img/Jumper26_Blue-1-768x768.jpg" alt="">
      </div>

   </div>

   <div class="body-icon4">
     <div class="acao">
      <a href="">New Arrivals</a>
     </div>

     <div class="acao">
      <a href="">Best Seller</a>
     </div>

     <div class="acao">
      <a href="">Khuyến mãi</a>
     </div>

   </div>



 

 
 

 <div class="body-icon6">
   <div class="xakho">
      <img src="img/Banner-1200x120.webp" alt="" class="img-xakho">
   </div>
<div class="hangchinh">


   <div class="hang1">
      <div class="hanganh1">
         <img  src="img/ineed-latte-26-2022-mushroom_transparent.png" alt="">
      </div>
      <div class="tenhang1">
      <%  
                      Object obj2 = session.getAttribute("taikhoan") ; 
					      khachhang kh2 = null ;
					      if(obj2 != null ) 
					    	  kh2 = (khachhang)obj ; 
					      if(kh2 == null ) {
					    	  
					    	  
						 
                      %>
         <a href="dangnhap.jsp">Xe Đạp Đường Phố Touring Momentum Ineed</a>
         
         <%}else { %>
          <a href="dangnhapthanhcong.jsp">Xe Đạp Đường Phố Touring Momentum Ineed</a>
          
          <%} %>
         <p class="p5cu">5.500.000 <span>₫</span></p>
         <p class="p8cu"> <span class="ps8">9.800.000</span> <span class="psd">₫</span> <span class="ps37"> -37% </span></p>
        <ul><li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li></ul>
      </div>
   </div>

   <div class="hang1">
      <div class="hanganh1">
         <img  src="img/Totem_Martin24_Yellow-768x768_transparent.png" alt="">
      </div>
      <div class="tenhang1">
       <%  
          
					      if(obj2 != null ) 
					    	  kh2 = (khachhang)obj ; 
					      if(kh2 == null ) {
					    	  
					    	  
						 
                      %>
         <a href="dangnhap.jsp">Xe Đạp Địa Hình MTB GIANT ATX 860 – Phanh Đĩa</a>
         
         <% }else { %>
         <a href="dangnhapthanhcong.jsp">Xe Đạp Địa Hình MTB GIANT ATX 860 – Phanh Đĩa</a>
         <% } %>
         <p class="p5cu">5.500.000 <span>₫</span></p>
         <p class="p8cu"> <span class="ps8">8.800.000</span> <span class="psd">₫</span> <span class="ps37"> -37% </span></p>
        <ul><li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li></ul>
      </div>
   </div>

   <div class="hang1">
      <div class="hanganh1">
         <img  src="img/2022_IneedStreet_BlueGray-768x768_transparent.png" alt="">
      </div>
      <div class="tenhang1">
        <%  
          
					      if(obj2 != null ) 
					    	  kh2 = (khachhang)obj ; 
					      if(kh2 == null ) {
					    	  
					    	  
						 
                      %>
         <a href="dangnhap.jsp">Xe Đạp Đường Phố Touring MOMENTUM iNeed Street</a>
         
         <% }else { %>
         <a href="dangnhapthanhcong.jsp">Xe Đạp Đường Phố Touring MOMENTUM iNeed Street</a>
         <% } %>
         <p class="p5cu">5.500.000 <span>₫</span></p>
         <p class="p8cu"> <span class="ps8">19.800.000</span> <span class="psd">₫</span> <span class="ps37"> -37% </span></p>
        <ul><li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li></ul>
      </div>
   </div>

   <div class="hang1">
      <div class="hanganh1">
         <img  src="img/2022_Roam0Disc_Charcoal-768x768_transparent.png" alt="">
      </div>
      <div class="tenhang1">
         <%  
          
					      if(obj2 != null ) 
					    	  kh2 = (khachhang)obj ; 
					      if(kh2 == null ) {
					    	  
					    	  
						 
                      %>
         <a href="dangnhap.jsp">Xe Đạp Địa Hình MTB GIANT Roam 1 Disc – Phanh Đĩa</a>
         
         <% }else { %>
         <a href="dangnhapthanhcong.jsp">Xe Đạp Địa Hình MTB GIANT Roam 1 Disc – Phanh Đĩa</a>
         <% } %>
         <p class="p5cu">5.500.000 <span>₫</span></p>
         <p class="p8cu"> <span class="ps8">20.800.000</span> <span class="psd">₫</span> <span class="ps37"> -37% </span></p>
        <ul><li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li></ul>
      </div>
   </div>

   <div class="hang1">
      <div class="hanganh1">
         <img  src="img/2024_Roam1Disc_BlackDiamond-768x768_transparent.png">
      </div>
      <div class="tenhang1">
         <%  
          
					      if(obj2 != null ) 
					    	  kh2 = (khachhang)obj ; 
					      if(kh2 == null ) {
					    	  
					    	  
						 
                      %>
         <a href="dangnhap.jsp">Xe Đạp Địa Hình MTB MEREC XR300 26 – Phanh Đĩa</a>
         
         <% }else { %>
         <a href="dangnhapthanhcong.jsp">Xe Đạp Địa Hình MTB MEREC XR300 26 – Phanh Đĩa</a>
         <% } %>
         <p class="p5cu">5.500.000 <span>₫</span></p>
         <p class="p8cu"> <span class="ps8">8.800.000</span> <span class="psd">₫</span> <span class="ps37"> -37% </span></p>
        <ul><li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li></ul>
      </div>
   </div>

   <div class="hang1">
      <div class="hanganh1">
         <img  src="img/2300093103-PhoenixFire-768x768_transparent.png" alt="">
      </div>
      <div class="tenhang1">
         <%  
          
					      if(obj2 != null ) 
					    	  kh2 = (khachhang)obj ; 
					      if(kh2 == null ) {
					    	  
					    	  
						 
                      %>
         <a href="dangnhap.jsp">Xe Đạp Địa Hình MTB MEREC TS500 – Phanh Đĩa</a>
         
         <% }else { %>
         <a href="dangnhapthanhcong.jsp">Xe Đạp Địa Hình MTB MEREC TS500 – Phanh Đĩa</a>
         <% } %>
         <p class="p5cu">5.500.000 <span>₫</span></p>
         <p class="p8cu"> <span class="ps8">10.000.000</span> <span class="psd">₫</span> <span class="ps37"> -37% </span></p>
        <ul><li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li>
        <li><img src="img/star.svg" alt=""></li></ul>
      </div>
   </div>

  </div>


 </div>
 
 
 
 
 
 <div class="body-icon88">  
<%   String url1= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
        		+ request.getContextPath();  
    	
        		%>
        		
        		<%   sanphamDao spd = new sanphamDao() ;
                         
                 
%>

<% 
String timkiem = request.getAttribute("dodu") + "" ;
if(timkiem.equals("null")) {
	 List<sanpham> sp = spd.selectAll() ;
	%>

  <div class="col-sm-9">
     
            <div class="row">
             <% if ( !sp.isEmpty()) {
            for(sanpham p: sp ){%>
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
            <a href="gioithieusp?id=<%= p.getMasanpham() %>" class="anhxe1"><img class="card-img-top" src= "<%= url1 %>/anh/<%=p.getAnhsanpham()%>"
          alt=""><%= p.getTensanpham() %> </a>
       <div class="card-body">
          <h4 class="card-title">
             <a class="anhxe2" href="gioithieusp?id=<%= p.getMasanpham() %>"> <%= p.getGiatien() %> đ</a>
          </h4> 
             </div>
               <div class="card-footer">
          <small class="text-muted">&#9733; &#9733; &#9733;
             &#9733; &#9734;</small>
            </div>
            </div>
           </div>
    <% 
      }
      }%>  </div>	
      	
   </div>
   <% }else  {
	  
   %>

    <div class="col-sm-9">
            <div class="row">
            <c:forEach items="${dodu}" var="h"> 
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
       <a href="gioithieusp?id=${h.masanpham }" class="anhxe1"><img class="card-img-top" src= "<%= url1 %>/anh/${h.anhsanpham}"
          alt=""> ${h.tensanpham}</a>
       <div class="card-body">
          <h4 class="card-title">
             <a class="anhxe2" href="gioithieusp?id=${h.masanpham }">${h.giatien} đ</a>
          </h4> 
             </div>
               <div class="card-footer">
          <small class="text-muted">&#9733; &#9733; &#9733;
             &#9733; &#9734;</small>
            </div>
            </div>
           </div>
             </c:forEach>
      </div>		
   </div>
    <% 
   
      }
      %>  
      </div>	
      	
   



   <div id="footer">
     <div class="footer-dau">
     <ul class="footer-dau1">
      <li> <a href=""><ti class="ti-angle-left"></ti></a> </li>
      <li> <a href="" class="a11">1</a> </li>
      <li><a href="">2</a> </li>
      <li><a href="">3</a> </li>
      <li><a href="">4</a> </li>
      <li><a href="">5</a> </li>
      <li><a href="">6</a> </li>
      <li><a href="">7</a> </li>
      <li><a href="">8</a> </li>
      <li><a href=""><ti class="ti-angle-right"></ti></a> </li>
       </ul>
  </div>
   <div class="footer-giua">
      <div class="footer-giuaheadel">
         <p>Blog & Tips</p>
      </div>
      <div class="fotter-giua1">
          <div class="anhfooter">
            <img src="img/cach-sua-xe-dap-bi-truot-mat-ca-thumbnail-300x155.jpg" alt="">
          </div>
          <div class="baogomloi">
            <div class="loifooter">
               <p class="p-f">Chọn xe đạp làm phụ kiện - xu hướng thời trang mới của phái đẹp</p>
             </div>
             <div class="loifooter1">
               <p>Những năm gần đây, Xe đạp là phương tiện giao thông chính ở nhiều nơi trên thế giới</p>
             </div>
          </div>
          
      </div>

      <div class="fotter-giua2">
         <div class="anhfooter">
           <img src="img/cach-chay-xe-dap-leo-nui-thumbnail-300x155.jpg" alt="">
         </div>
         <div class="baogomloi">
           <div class="loifooter">
              <p class="p-f">Xe Đạp Việt Nam - Tượng đài  của giới 2 bánh</p>
            </div>
            <div class="loifooter1">
              <p>Nhắc đến Việt Nam, điều đầu tiên bạn nhớ về đất nước này là gì? Chắc chắn là Xe Đạp Rồi!</p>
            </div>
         </div>
         
     </div>

   </div>
   <div class="kengang">
      <hr  width="85%" size="2px"   />
   </div>
   
   <div class="cuoi1">
      <div class="anhcuoi">
         <img src="img/pnj.com.vn.png" alt="">
      </div>
      <div class="loicuoi">
         <p class="pa1">© 2017 Công Ty Cổ Phần Xe Đạp VN</p>
         <p class="pa2">170E Phan Đăng Lưu, P.3, Q.Phú Nhuận, TP.Hồ Chí Minh</p>
         <p class="pa3">ĐT: 028 39951703 - Fax: 028 3995 1702</p>
         <p class="pa4">Giấy chứng nhận đăng ký doanh nghiệp: 0300521758.</p>
         <p class="pa5">Tổng đài hỗ trợ (08:00-21:00, miễn phí gọi)</p>
         <p class="pa6">Gọi mua: 1800545457 (phím 1)</p>
         <p class="pa7">Khiếu nại: 1800545457 (phím 2)</p>

      </div>
   </div>
   
   <div class="fote-hai">
      <div class="fote-hai1">
      <p class="pb1">Về PNJ</p>
      <p class="pb2">Câu chuyện PNJ</p>
      <p class="pb3">Tuyển dụng</p>
      <p class="pb4">Xuất khẩu</p>
      <p class="pb5">Kinh doanh sỉ</p>
     

      </div>
     
   </div>

   <div class="fote-ba">
      <div class="fote-ba1">
         <p class="pc1">DỊCH VỤ KHÁCH HÀNG</p>
         <p class="pc2">Mua hàng trả góp</p>
         <p class="pc2">Chính sách hoàn tiền</p>
         <p class="pc2">Chính sách giao hàng</p>
         <p class="pc3">PHƯƠNG THỨC THANH TOÁN</p>
      </div>
      <div class="fote-bai2">
         <ul>
            <li><img src="img/visa.svg" alt=""> </li>
            <li><img src="img/mastercard.svg" alt=""></li>
            <li><img src="img/jcb.svg" alt=""></li>
            <li><img src="img/thanhtoantienmat.svg" alt=""></li>
            <li><img src="img/internetBanking.svg" alt=""></li>
            <li><img src="img/tragop.svg" alt=""></li>
         </ul>
      </div>
   </div>

   <div class="foote4">
      <div class="footer4a">
         <p class="pd1">KẾT NỐI VỚI CHÚNG TÔI</p>
      </div>
      <div class="foote4b">
         <ul>
            <li> <a href=" https://www.facebook.com/profile.php?id=100037102273912"> <img src="img/facebook.svg" alt=""></a> </li>
            <li> <img src="img/instagram.svg" alt=""></li>
            <li> <img src="img/youtube.svg" alt=""></li>
            <li> <img src="img/email.svg" alt=""></li>
         </ul>
      </div>
      <div class="foote4c">
        
         <p class="pd3">CHỨNG NHẬN</p>
         </div>
        
   </div>
    <div class="anh-fote">
      <img  class="img-fote" src="img/logoSaleNoti.png" alt="">
   </div>
 </div>

   </div>
  
 
</div>
</body>
</html>