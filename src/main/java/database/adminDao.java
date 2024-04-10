package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.admin;
import model.sanpham;

public class adminDao {
	 public admin kiemtraadmin (admin ad) {
	    	admin ketqua = null ;
	    	
	    	try {
				
	    		Connection con = JDBCutil.getConnection() ;
	    		String sql = "select * from admin where taikhoanadmin = ? and matkhau = ?" ;
	    		PreparedStatement ps = con.prepareStatement(sql) ;
	    		ps.setString(1, ad.getTaikhoaadmin());
	    		ps.setString(2, ad.getMatkhauadmin());
	    		
	    	    ResultSet rs = ps.executeQuery() ;
	    	    while (rs.next()) {
	    	    	String maadmin = rs.getString("maadmin") ; 
	    	    	String taikhoanadmin = rs.getString("taikhoanadmin") ; 
	    	    	String matkhauadmin = rs.getString("matkhau") ; 
	    	    	
	    	    	ketqua = new admin(maadmin, maadmin, matkhauadmin);
	    	    }
	    		
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	
	    	
	    	
	    	
	    	return ketqua ;
	    
	    }
	 
}
