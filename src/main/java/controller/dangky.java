package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.khachhangDao;
import model.khachhang;





@WebServlet("/dangky")
public class dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public dangky() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		
		String tenkhachhang = request.getParameter("tenkhachhang"); 
		String gioitinh = request.getParameter("gioitinh");
		String sodienthoai = request.getParameter("sodienthoai"); 
		String diachi = request.getParameter("diachi");
		String email = request.getParameter("email"); 
		String taikhoan = request.getParameter("tentaikhoan");
		String matkhau = request.getParameter("matkhau"); 
		khachhangDao khd = new khachhangDao() ; 
		String baoloi = "" ; 
		String url = "";
		System.out.println(tenkhachhang);
		if(khd.kiemtrataikhoan(taikhoan)) {
			baoloi = "Tài khoản này đã tồn tại" ; 
			
		}
		request.setAttribute("baoloi", baoloi);
		request.setAttribute("loiten", tenkhachhang);
		request.setAttribute("loiso", sodienthoai);
		request.setAttribute("diachi", diachi);
		request.setAttribute("email", email);
		request.setAttribute("gioitinh", gioitinh);
	
		
		if(baoloi.length() > 0 ) {
			 url = "/dangky.jsp";
		}else {
			Random rd1 = new Random() ; 
			String makhachhang = System.currentTimeMillis() + rd1.nextInt(1000) +"" ; 
			khachhang kh = new khachhang(makhachhang, tenkhachhang, gioitinh, sodienthoai, diachi, email, taikhoan, matkhau);
			khd.insert(kh);
			
		    url ="/dangnhapthanhcong.jsp" ;
		}
		
		
		
		
		
		
		
	       
	       RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	       rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
