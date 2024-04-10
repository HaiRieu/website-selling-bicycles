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

import database.giohangDao;
import database.sanphamDao;
import model.giohang1;
import model.khachhang;
import model.sanpham;

/**
 * Servlet implementation class themvaogiohang2
 */
@WebServlet("/themvaogiohang2")
public class themvaogiohang2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public themvaogiohang2() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		
		  
	   String masanpham = request.getParameter("id"); 
	   String giatien = request.getParameter("gia");
	   
	   int soluong = 1 ;
	   int soluongg = 1 ;
	   int giatien1 = Integer.valueOf(giatien);
 	   HttpSession session = request.getSession() ;
 	   Object obj = session.getAttribute("taikhoan") ;
 	   khachhang kh = (khachhang)obj ;
 	    String makhachhang = kh.getMakhachhang() ; 
 	    Random r = new Random() ;
 	    String magiohang = System.currentTimeMillis() + r.nextInt(1000) + "" ;
 	        int gtien = 1 ;
 	        int gtienn = 0  ; 
 	    sanphamDao spd = new sanphamDao() ; 
 	   List<sanpham> sp =  spd.getsanphamID2(masanpham);
		for(int i = 0 ; i < sp.size() ; i++) {
			if(sp.get(i).getMasanpham().equals(masanpham)) {
			  gtien  = sp.get(i).getGiatien() ; 
			  
			}
		}
 	    
 	    giohangDao ghd = new giohangDao() ;
 	    List<giohang1> gh1 = ghd.timkiemdh(makhachhang) ; 
 	  
 	 
 	  for(int i=0  ; i< gh1.size() ;) {
 		  if( gh1.get(i).getMasanpham().equals(masanpham) ) {
 			 int sluong = gh1.get(i).getSoluong() ; 
 			 int giatien2 = gtien; 
 			 int gg = gh1.get(i).getGiatien() ; 
			  sluong++ ; 
			  soluongg = sluong ;
			  gtienn = giatien2 + gg  ; 
			  ghd.suaghh(soluongg, gtienn,  gh1.get(i).getMagiohang());
			  
			  break ; 
			    }
 		  i++;
 		  if(i > (gh1.size()-1))
 		  {
 			 giohang1 gh = new giohang1(magiohang, masanpham, makhachhang, soluong, giatien1); 
	    	   ghd.insert(gh);
 		  }
 		  
 	  }
 	  if(gh1.size() == 0 ) {
 		 giohang1 gh = new giohang1(magiohang, masanpham, makhachhang, soluong, giatien1); 
  	   ghd.insert(gh);
 	  }
 	        	 
 	    
 	   request.getRequestDispatcher("giohang.jsp").forward(request, response);
 	    
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
