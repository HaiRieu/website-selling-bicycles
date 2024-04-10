package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.sanphamDao;

/**
 * Servlet implementation class chinhsuasp
 */
@WebServlet("/chinhsuasp")
public class chinhsuasp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public chinhsuasp() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		
		sanphamDao spd = new sanphamDao() ; 
		String masanpham = request.getParameter("masanpham");
		
		String tensanpham = request.getParameter("tensanpham");
		String soluong = request.getParameter("soluong");
		int sl = Integer.valueOf(soluong);
		String giatien = request.getParameter("giatien");
	     int gt = Integer.valueOf(giatien);
		spd.suaspp(tensanpham, sl, gt, masanpham) ; 
		   request.getRequestDispatcher("admin2.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
