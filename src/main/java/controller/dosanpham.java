package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.sanphamDao;
import model.sanpham;


@WebServlet(name = "dosanpham" , urlPatterns = ("/trangchu")) 
public class dosanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dosanpham() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       sanphamDao spd = new sanphamDao() ;
	       List<sanpham> sp = spd.selectAll() ;
	       
	      
	       request.setAttribute("dodu", sp);
	       String url ="trangchu.jsp" ;
	       request.getRequestDispatcher(url).forward(request, response);
	     
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
