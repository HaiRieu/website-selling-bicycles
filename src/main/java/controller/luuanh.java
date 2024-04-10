package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.khachhangDao;
import model.khachhang;

@MultipartConfig 
@WebServlet("/luuanh")
public class luuanh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public luuanh() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*request.setAttribute("duongdan",filename);
		
		request.setAttribute("baoloi", "thay doi anh thanh cong ");
	
	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/thaydoianh.jsp") ; 
	  rd.forward(request, response);*/
	

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ; 
		Object obj = session.getAttribute("taikhoan") ; 
		khachhang kh = (khachhang) obj ; 
		
		String baoloi = "" ; 
		
		Part part = request.getPart("duongdananh") ; 
		String realpart = getServletContext().getRealPath("anh") ;
		String filename = Path.of(part.getSubmittedFileName()).getFileName().toString() ;
		
		if(!Files.exists(Path.of(realpart))) {
			Files.createDirectory(Path.of(realpart));
			
		}
		String paths = realpart+"/"+filename ;
		
		part.write(paths) ;
		System.out.println(paths);
		khachhangDao khd = new khachhangDao() ;
		kh.setDuongdananh(filename) ;
		khd.thaydoianh(kh);
		kh = khd.selectId(kh) ;
		
	}

}
