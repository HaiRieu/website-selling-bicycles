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
import model.admin;

/**
 * Servlet implementation class dangnhapAdmin
 */
@WebServlet("/dangnhapAdmin")
public class dangnhapAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public dangnhapAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		adminDao add = new adminDao() ; 
          String taikhoan = request.getParameter("taikhoan") ; 
          String matkhau = request.getParameter("matkhau") ; 
          String url = "" ; 
          String baoloi = "" ;
          admin ad = new admin() ; 
          ad.setTaikhoaadmin(taikhoan);
          ad.setMatkhauadmin(matkhau);
          
          admin admin = add.kiemtraadmin(ad) ; 
          
          if(admin != null) {
       	  
       	   url = "/admin2.jsp" ; 
          }else {
        	  baoloi = "Tài khoản hoặc mật khẩu không chính xác " ;
	        	 request.setAttribute("loi", baoloi);
	        	 url = "/dangnhapAdmin.jsp";
          }
          RequestDispatcher rs = getServletContext().getRequestDispatcher(url) ; 
          rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
