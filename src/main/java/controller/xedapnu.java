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


@WebServlet("/xedapnu")
public class xedapnu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public xedapnu() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		String xedapnu = "xe đạp nữ";
		sanphamDao spd = new sanphamDao() ;
		List<sanpham> sp = spd.timkiemsanpham(xedapnu);
		
		request.setAttribute("dodu", sp);
		request.getRequestDispatcher("trangchu.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
