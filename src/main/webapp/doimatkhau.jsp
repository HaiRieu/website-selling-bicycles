<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu</title>
</head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style> 
  .red{
  color : red ; 
  }
</style>
<body>

<%
String baoloi = request.getAttribute("baoloi") +""; 
baoloi = (baoloi.equals("null")) ? "" : baoloi ;
%>

	<div class="container">
		<h1>ĐỔI MẬT KHẨU</h1>
		<span style="color: red">
			<%= baoloi %>
		</span>
		<form action="doimatkhau" method="POST">
		  <div class="mb-3">
		    <label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại</label>
		    <input type="password" class="form-control" id="matkhauhientai" name="matkhauhientai">
		  </div>
		  <div class="mb-3">
		    <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
		    <input type="password" class="form-control" id="matkhaumoi" name="matkhaumoi">
		  </div>
		  <div class="mb-3">
		    <label for="matKhauMoiNhapLai" class="form-label " >Mật khẩu mới <span id ="msg" class = "red"></span></label> 
		    <input type="password" class="form-control" id="matkhaumoinhaplai" name="matkhaumoinhaplai" onkeyup = "kiemtramatkhau()">
		  </div>
		  <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
		</form>
	</div>

</body>  

<script >
    
function kiemtramatkhau () {
	matkhau = document.getElementById("matkhaumoi").value ; 
	nhaplaimatkhau = document.getElementById("matkhaumoinhaplai").value ; 
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