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
 * Servlet implementation class doithongtin
 */
@WebServlet("/doithongtinkhachhang")
public class doithongtin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public doithongtin() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
	   String hoten = request.getParameter("tenkhachhang") ;
	   String gioitinh = request.getParameter("gioitinh") ;
	   String sodienthoai = request.getParameter("sodienthoai") ;
	   String diachi = request.getParameter("diachi") ;
	   String email = request.getParameter("email") ;
	   
	   String baoloi = "" ; 
	   String url = "/thaydoithongtin.jsp" ; 
	   khachhangDao dao = new khachhangDao() ; 
	   HttpSession session = request.getSession() ; 
	   
	   Object obj = session.getAttribute("taikhoan") ; 
	   khachhang kh = null ; 
	   
	   if(obj != null ) 
		    kh = (khachhang)obj ; 
	   if(kh == null) {
		   baoloi = "bạn chưa đăng nhập vào hệ thống " ; 
	   }else {
		 kh.setTenkhachhang(hoten);
		 kh.setGioitinh(gioitinh);
		 kh.setSodienthoai(sodienthoai);
		 kh.setDiachi(diachi);
		 kh.setEmail(email);
		   dao.doithongtin(kh) ; 
		   baoloi = "Bạn đã thay đổi thành công" ; 
	   }
	   
	   request.setAttribute("baoloi", baoloi);
	   
	   RequestDispatcher rd = getServletContext().getRequestDispatcher(url) ; 
	   rd.forward(request, response);
	   
	   
	   
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
