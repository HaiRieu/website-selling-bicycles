package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.sanphamDao;
import model.sanpham;

/**
 * Servlet implementation class themsanpham
 */
@MultipartConfig
@WebServlet("/themsanpham")
public class themsanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public themsanpham() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ; 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ; charset = UTF-8");
		try {
		
		String tensanpham = request.getParameter("tensanpham") ; 
		String soluong = request.getParameter("soluong");
		String giatien = request.getParameter("giatien");
		int soluongep = Integer.parseInt(soluong);
		int giatienep = Integer.parseInt(giatien) ;
		System.out.println(tensanpham);
		Part part = request.getPart("anhsanpham") ; 
		
		
		String realpart = getServletContext().getRealPath("anh") ;
		String filename = Path.of(part.getSubmittedFileName()).getFileName().toString() ;
		
		if(!Files.exists(Path.of(realpart))) {
			Files.createDirectory(Path.of(realpart));
			
		}
		String paths = realpart+"/"+filename ;
		part.write(paths) ;
		
		sanphamDao spd = new sanphamDao() ;
		sanpham sp = new sanpham() ; 
		Random r = new Random() ;
		String masanpham = System.currentTimeMillis() +r.nextInt(10000) + "" ;
		sp.setMasanpham(masanpham);
		sp.setTensanpham(tensanpham);
		sp.setSoluong(soluongep);
		sp.setGiatien(giatienep);
		sp.setAnhsanpham(filename);
		
		spd.insert(sp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	
		
		String url = "/admin.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
