package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import database.donhangDao;
import model.donhang;
import model.khachhang;


@WebServlet("/thanhtoangiohanghihi")
public class thanhtoangiohanghihi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public thanhtoangiohanghihi() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		
		donhangDao dhd = new donhangDao() ; 
		
		  HttpSession session = request.getSession() ;
   	   Object obj = session.getAttribute("taikhoan") ;
   	   khachhang kh = (khachhang)obj ;
   	    String makhachhang = kh.getMakhachhang() ; 
   	    Random r = new Random() ;
   	    String madonhang = System.currentTimeMillis() + r.nextInt(1000) + "" ;
		 
		dhd.truyen(makhachhang) ; 
		
		request.getRequestDispatcher("donhangkh.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
