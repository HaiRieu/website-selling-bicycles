package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xacnhan
 */
@WebServlet("/xacnhan")
public class xacnhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public xacnhan() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String xacnhan = "Đã Nhận Hàng" ;
	   request.setAttribute("xacnhan", xacnhan); 
	   request.getRequestDispatcher("donhangkh.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
