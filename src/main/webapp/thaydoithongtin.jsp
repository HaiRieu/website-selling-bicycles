<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi thông tin </title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
</head>
<body>

<% 
String nhanloi = request.getAttribute("baoloi")+ "" ;
nhanloi = (nhanloi.equals("null")) ? "" : nhanloi ; 

%>
<form class="form" action="doithongtinkhachhang" method="post">
			<div class="row">
				<div class="col-sm-6">
					<h3>Thông Tin Tài khoản</h3>
					<h4> <%= nhanloi %> </h4>
					
					<div class="mb-3 mg-3">
						<label for="" class="form-label"> Họ Và Tên  </label> <input type="text" class="form-control"
							id="hoten" name="tenkhachhang" required="required" value = "" >
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">Giới tính </label> <input type="text"  class="form-control"
							id="gioitinh" name="gioitinh" required="required" value = "" >
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Số Điện Thoại </label> <input type="number" class="form-control"
							id="sodienthoai" name="sodienthoai" required="required"  value = "" >
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Địa Chỉ </label> <input type="text" class="form-control"
							id="diachi" name="diachi" required="required" value = ""  >
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Email </label> <input type="text"  class="form-control"
							id="email" name="email" required="required" value = ""  >
					</div>
					
					
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit"  />
				
					
				
					
				
				</div>
			</div>
		</form>
	</div>
</body>
</html>