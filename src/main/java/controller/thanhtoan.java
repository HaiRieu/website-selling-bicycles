package controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.donhangDao;
import database.giohangDao;
import database.sanphamDao;
import model.donhang;
import model.khachhang;
import model.sanpham;


@WebServlet("/thanhtoan")
public class thanhtoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public thanhtoan() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		
      
           sanphamDao spd = new sanphamDao() ; 
         
   	       String masanpham = request.getParameter("id"); 
   	       String giatien = request.getParameter("gia");
   	    
   	       int soluong = 1 ; 
   	       int soluong2 = 0;
   	      List<sanpham> sp =  spd.getsanphamID2(masanpham);
   	       for (int i = 0 ; i < sp.size() ; i++) {
   	    	  int sl = sp.get(i).getSoluong();
   	    	  soluong2 = sl - soluong ; 
   	      }
   	       
   	       spd.suasp(soluong2, masanpham);
    	   HttpSession session = request.getSession() ;
    	   Object obj = session.getAttribute("taikhoan") ;
    	   khachhang kh = (khachhang)obj ;
    	    String makhachhang = kh.getMakhachhang() ; 
    	    Random r = new Random() ;
    	    String madonhang = System.currentTimeMillis() + r.nextInt(1000) + "" ;
    	    
    	    donhang dh = new donhang(madonhang, masanpham, makhachhang,giatien,soluong);
    	    donhangDao dhd = new donhangDao() ;
    	    dhd.insert(dh);
    	   
    	    
    	    request.getRequestDispatcher("donhangkh.jsp").forward(request, response);
    	    
    	    
    	    
    	
    	   
        
    	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
