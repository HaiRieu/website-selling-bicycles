package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.giohangDao;
import database.sanphamDao;
import model.giohang1;
import model.sanpham;

/**
 * Servlet implementation class giamsl
 */
@WebServlet("/giamsl")
public class giamsl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public giamsl() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		giohangDao ghd = new giohangDao() ;
		sanphamDao spd = new sanphamDao() ; 
		String id = request.getParameter("id");
		String msp = request.getParameter("msp");
		List<giohang1> gh = ghd.timkiemdh(id) ; 
		int giatien = 1 ; 
		List<sanpham> sp =  spd.getsanphamID2(msp);
		for(int i = 0 ; i < sp.size() ; i++) {
			if(sp.get(i).getMasanpham().equals(msp)) {
				giatien = sp.get(i).getGiatien() ; 
			}
		}
		String mgh = request.getParameter("mgh");
		int sl = 1; 
		int gt = 1 ; ; 
		for(int i = 0 ; i<gh.size() ; i++) {
			int  soluong = gh.get(i).getSoluong()  ;
			int giatien1 = giatien ;
			int giatien2 = gh.get(i).getGiatien() ; 
		         if(gh.get(i).getMagiohang().equals(mgh)) {
		        	
		        	 soluong-- ;
				     sl  = soluong  ;
				     giatien2 -= giatien1 ; 
				     gt = giatien2 ; 
		         }
				}
			
		
		
		ghd.suagh(sl, gt, mgh) ;
		
		   request.getRequestDispatcher("giohang.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
