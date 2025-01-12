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

/**
 * Servlet implementation class noidungtimkiem
 */
@WebServlet("/noidungtimkiem")
public class noidungtimkiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noidungtimkiem() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
	String timkiem = request.getParameter("txt") ;
	sanphamDao spd = new sanphamDao() ;
	List<sanpham> sp = spd.timkiemsanpham(timkiem);
	
	request.setAttribute("dodu", sp);
	request.getRequestDispatcher("trangchu.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
