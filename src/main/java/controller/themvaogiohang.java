package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.giohang;


@WebServlet("/themvaogiohang")
public class themvaogiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public themvaogiohang() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<giohang> gh = new ArrayList<>() ;
		long id = Long.parseLong(request.getParameter("id"))  ;
		
	   	giohang gio = new giohang() ;
           gio.setMagiohang(id);
           
           HttpSession session = request.getSession() ;
           ArrayList<giohang> gio_hang =  (ArrayList<giohang>) session.getAttribute("gio-hang") ;
           if(gio_hang == null) {
        	   gh.add(gio) ;
        	   session.setAttribute("gio-hang", gh);
        	   System.out.println("them thanh cong");
           }else {
        	 gh = gio_hang ;
        	 boolean exit = false ;
        	 for (giohang g : gio_hang) {
        		 if(g.getMagiohang() == id) {
        			 exit = true ;
        		 }
        	 }
        	 if(!exit ) {
        		 gh.add(gio);
        		 response.sendRedirect("trangchu.jsp");
        	 }
        	 
           }
           
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
