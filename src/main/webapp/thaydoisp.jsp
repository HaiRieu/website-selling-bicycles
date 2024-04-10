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
String msp = request.getParameter("msp")+ "" ;
String tensp = request.getParameter("tensp")+ "" ;
String sl = request.getParameter("sl")+ "" ;
  int sll = Integer.valueOf(sl) ; 
String gt = request.getParameter("gt")+ "" ;
int gtt = Integer.valueOf(gt) ; 



%>
<form class="form" action="chinhsuasp" method="post">
			<div class="row">
				<div class="col-sm-6">
					<h3>Thông Tin Sản Phẩm Cần Thay Đổi</h3>
				
					
					<div class="mb-3 mg-3">
						<label for="" class="form-label"> Mã Sản Phẩm </label> <input type="text" class="form-control"
							id="tensp" name="masanpham" required="required" value = "<%= msp %>" >
					</div>
					
					<div class="mb-3 mg-3">
						<label for="" class="form-label"> Tên Sản Phẩm </label> <input type="text" class="form-control"
							id="tensp" name="tensanpham" required="required" value = "<%= tensp %>" >
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">Số Lượng </label> <input type="numble"  class="form-control"
							id="gioitinh" name="soluong" required="required" value = "<%= sll %>" >
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Giá Tiền </label> <input type="number" class="form-control"
							id="sodienthoai" name="giatien" required="required"  value = "<%= gtt %>" >
					</div>
			
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit"  />
				
				</div>
			</div>
		</form>
	</div>
</body>
</html>