package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.binhluanDao;
import model.binhluan;
import model.khachhang;


@WebServlet("/binhluannd")
public class binhluannd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public binhluannd() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession() ;
   	   Object obj = session.getAttribute("taikhoan") ;
   	   khachhang kh = (khachhang)obj ;
   	   String makhachhang = kh.getMakhachhang() ;
   	   String noidung = request.getParameter("binhluan") ; 
       String masanpham = request.getParameter("id") ; 
       System.out.println(noidung);
       System.out.println(masanpham);
   	   binhluanDao bld = new binhluanDao() ;
   	   binhluan bl = new binhluan(makhachhang, noidung, masanpham);
   	   bld.insert(bl);
 
   	   request.getRequestDispatcher("trangchu.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
