<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> 
</head>
<style>
.red{
 color : red ;  
}
</style>
<body>
<% 
String nhanloi = request.getAttribute("baoloi") + "" ;
  nhanloi = (nhanloi.equals("null")) ? " ":nhanloi ;
  
  String loiten = request.getAttribute("loiten") + "" ;
  loiten = (loiten.equals("null")) ? " " :loiten ; 
  
  String sodienthoai = request.getAttribute("loiso") + "" ;
  sodienthoai = (sodienthoai.equals("null")) ? "":sodienthoai ; 
  
  String diachi = request.getAttribute("diachi") + "" ;
  diachi = (diachi.equals("null")) ? " " :diachi ; 
  
  String email = request.getAttribute("email") + "" ;
  email = (email.equals("null")) ? "" :email ; 
  
  String gioitinh = request.getAttribute("gioitinh") + "" ;
  gioitinh = (gioitinh.equals("null")) ? "" :gioitinh ; 	

%>

<div class="container">
		<div class="text-center">
			<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
		</div>
		
		<div class="red" id="baoLoi">
			
		</div>
		<form class="form" action="dangky" method="post">
			<div class="row">
				<div class="col-sm-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="tenDangNhap" class="form-label"> Tài Khoản <span
							class="red">*</span> <span class = "red"> <%= nhanloi %> </span></label> <input type="text" class="form-control"
							id="taikhoan" name="tentaikhoan" required="required" value="">
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Mật Khẩu <span
							class="red">*</span></label> <input type="password" class="form-control"
							id="matkhau" name="matkhau" required="required" >
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">Nhập Lại Mật Khẩu <span id="msg" class="red" ></span></label> <input type="password" class="form-control"
							id="nhaplaimatkhau" name="nhaplaimatkhau" required="required"  onkeyup="kiemtramatkhau()">
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label"> Họ Và Tên  </label> <input type="text" class="form-control"
							id="hoten" name="tenkhachhang" required="required" value = "<%= loiten %>" >
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">Giới tính </label> <input type="text"  class="form-control"
							id="gioitinh" name="gioitinh" required="required" value = "<%= gioitinh %>" >
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Số Điện Thoại </label> <input type="number" class="form-control"
							id="sodienthoai" name="sodienthoai" required="required"  value = "<%= sodienthoai %>" >
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Địa Chỉ </label> <input type="text" class="form-control"
							id="diachi" name="diachi" required="required" value = "<%= diachi %>"  >
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Email </label> <input type="text"  class="form-control"
							id="email" name="email" required="required" value = "<%= email %>"  >
					</div>
					
					
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit"  />
				
					
				
					
				
				</div>
			</div>
		</form>
	</div>


</body>

<script >

function kiemtramatkhau () {
	matkhau = document.getElementById("matkhau").value ; 
	nhaplaimatkhau = document.getElementById("nhaplaimatkhau").value ; 
	if(matkhau != nhaplaimatkhau){
		document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
		return false ; 
	}else {
		document.getElementById("msg").innerHTML = "";
		return true
	}
}

</script>

</html>