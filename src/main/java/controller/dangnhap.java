package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.adminDao;
import database.khachhangDao;
import model.admin;
import model.khachhang;

/**
 * Servlet implementation class dangnhap2
 */
@WebServlet("/dangnhap")
public class dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public dangnhap() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     khachhangDao khd = new khachhangDao() ;
		   
	          String taikhoan = request.getParameter("taikhoan") ; 
	          String matkhau = request.getParameter("matkhau") ; 
	          
	          String url = "" ; 
	          String baoloi = "" ;
	          
	          
	          
	           khachhang kh  = new khachhang() ;
	           kh.setTentaikhoan(taikhoan);
	           kh.setMatkhau(matkhau);
	          khachhang khachhang = khd.kiemtramatkhau(kh) ;
	        
	            
	         
	           	
	        if(khachhang != null ) {
	        	HttpSession session =  request.getSession() ;
	        	session.setAttribute("taikhoan", khachhang);
	        	  url = "/trangchu";
	        }else {
	        	baoloi = "Tài khoản hoặc mật khẩu không chính xác " ;
	        	 request.setAttribute("loi", baoloi);
	        	 url = "/dangnhap.jsp";
	        	 
	        }
	        
	        
	       
	        	
	        	
	        
	           
	        
	          
	          RequestDispatcher rs = getServletContext().getRequestDispatcher(url) ; 
	          rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
