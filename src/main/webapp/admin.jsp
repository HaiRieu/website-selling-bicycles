<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> 
</head>
<body>

<div class="container">
		
		<form class="form" action="themsanpham" method="post" enctype="multipart/form-data" >
			<div class="row">
				<div class="col-sm-6">
					
					<div class="mb-3">
						<label for="tenDangNhap" class="form-label">Tên sản phẩm <span
							class="red">*</span> <span class = "red">  </span></label> <input type="text" class="form-control"
							id="tensanpham" name="tensanpham"  value="">
					</div>
			
					<div class="mb-3">
						<label for="" class="form-label"> Số lượng </label> <input type="number" class="form-control"
							id="soluong" name="soluong"  value = "" >
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">Giá Tiền </label> <input type="number" class="form-control"
							id="giatien" name="giatien"   value = "" >
					</div>
						
	               <div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
							type="file" class="form-control" id="duongdanhanh" name="anhsanpham">
					</div>
					
					
					<input class="btn btn-primary form-control" type="submit"
						value="Thêm" name="submit" id="submit"  />
				
					
				
					
				
				</div>
			</div>
			
		</form>
	</div>

</body>
</html>