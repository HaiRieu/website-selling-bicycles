<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi ảnh</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<% 


    Object obj = session.getAttribute("taikhoan") ; 
      khachhang kh = (khachhang) obj ; 
	   String duongdananh = kh.getDuongdananh() ; 
%>


<div class="container">


		<div class="text-center">
			<h1>THÔNG TIN TÀI KHOẢN</h1>
		</div>
		
		<div class="red" id="baoLoi">
			
		</div>
		
		<form class="form" action="luuanh" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<% String url1= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
					
					
					
					%>
				
					<h3>Thông tin khách hàng</h3>
					
					<img src="<%= url1 %>/anh/<%= duongdananh %>" alt="Ảnh Avatar"   width = "400" hegiht = "400">
					<div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
							type="file" class="form-control" id="duongdanhanh" name="duongdananh">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit" />
				</div>
			</div>
		</form>
	</div>
	</div>
	
</body>
</html>