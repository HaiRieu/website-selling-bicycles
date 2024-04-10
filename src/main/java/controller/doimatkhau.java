package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.khachhangDao;
import model.khachhang;

/**
 * Servlet implementation class doimatkhau
 */
@WebServlet("/doimatkhau")
public class doimatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doimatkhau() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String matkhaucu =  request.getParameter("matkhaucu");
	       String matkhaumoi = request.getParameter("matkhaumoi") ; 
	       String matkhauhientai = request.getParameter("matkhauhientai") ;
	   
	       String baoloi = "" ;
	       String url = "/doimatkhau.jsp" ; 
	     
	HttpSession session = request.getSession() ;
	Object obj = session.getAttribute("taikhoan") ; 
	khachhang kh = null ;
	if( obj != null ) 
		kh = (khachhang)obj ;
		
	if(kh == null ) {
		baoloi ="Bạn chưa đăng nhập vào hệ thống" ; 
		
	}else {
		if(!matkhauhientai.equals(kh.getMatkhau())) {
			baoloi = "Mật khẩu hiện tại không chính xác" ; 
		}else {
			khachhangDao khd  = new khachhangDao() ;
	        kh.setMatkhau(matkhaumoi);
		    
		   if(khd.doimatkhau(kh)) {
			   baoloi = "Thay đổi mật khẩu thành công" ;
			  
		   }
	    
		}
		
	
		
	}
	   request.setAttribute("baoloi", baoloi);
	   RequestDispatcher rd = getServletContext().getRequestDispatcher(url) ;
	   rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
