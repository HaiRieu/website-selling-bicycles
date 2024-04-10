package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.giohangDao;
import database.sanphamDao;

/**
 * Servlet implementation class xoagiohang
 */
@WebServlet("/xoagiohang")
public class xoagiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public xoagiohang() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		String magiohang = request.getParameter("id") ;
		giohangDao ghd = new giohangDao() ;
		ghd.xoagh(magiohang);
		System.out.println("xoa thanh cong ");
		request.getRequestDispatcher("giohang.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
