package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.sanphamDao;


@WebServlet("/xoasanpham")
public class xoasanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public xoasanpham() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		String xoasp = request.getParameter("id") ;
		sanphamDao spd = new sanphamDao() ;
		spd.xoasp(xoasp) ;
		System.out.println("xoa thanh cong ");
		request.getRequestDispatcher("admin2.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
