package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.sanphamDao;
import model.sanpham;


@WebServlet("/gioithieusp")
public class gioithieusp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public gioithieusp() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
	  String id = request.getParameter("id") ; 
	  sanphamDao spd = new sanphamDao() ;
	  sanpham sp = spd.getsanphamID(id);
	  System.out.println(sp);
	  request.setAttribute("id", sp);
	  request.getRequestDispatcher("gioithieu.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
