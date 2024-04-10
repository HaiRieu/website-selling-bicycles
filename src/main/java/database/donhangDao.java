package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.donhang;
import model.sanpham;


public class donhangDao {
	public ArrayList<donhang> data = new ArrayList<donhang>() ; 
	  
	  public ArrayList<donhang> selectAll() {
		  ArrayList<donhang> ketqua = new ArrayList<donhang>() ;
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "select * from donhang " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ResultSet rs = ps.executeQuery() ; 
			  while(rs.next()) {
				 String madonhang =  rs.getString("madonhang");
				 String masanpham =  rs.getString("masanpham");
	     		 String makhachhang =  rs.getString("makhachhang");
	     		 String giatien = rs.getString("giatien");
				 
		    	donhang dh = new donhang(madonhang, masanpham, makhachhang,giatien);
				 
				 ketqua.add(dh) ; 
			  }
			  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  return ketqua ; 
	  }
	  
	  public int insert(donhang dh) {
		  int ketqua = 0 ; 
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "insert into donhang value (?,?,?,?,?) " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ps.setString(1, dh.getMadonhang());
			  ps.setString(2, dh.getMsp());
			  ps.setString(3, dh.getMakhachhang());
			  ps.setString(4, dh.getGiatien());
			  ps.setInt(5, dh.getSoluong());
			  ketqua = ps.executeUpdate() ; 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  
		  return ketqua ;
	  }
	  
	  public int truyen(  String mkh) {
		  int ketqua = 0 ; 
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "insert into donhang (madonhang,masanpham, makhachhang , soluong , giatien)\r\n"
			  		+ "select giohang.magiohang , giohang.masanpham, giohang.makhachhang  , giohang.soluong , giohang.giatien \r\n"
			  		+ "from giohang   \r\n"
			  		+ "where giohang.makhachhang = ? ; " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			
			  ps.setString(1, mkh);
			  ketqua = ps.executeUpdate() ; 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		    
		  
		  return ketqua ;
	  }
	  
	  
	  public ArrayList<donhang> dodonhang() {
		  ArrayList<donhang> ketqua = new ArrayList<donhang>() ;
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "SELECT donhang.madonhang , khachhang.hoten , sanpham.tensanpham ,donhang.giatien ,donhang.soluong FROM  donhang , khachhang ,sanpham "
			  		+ "WHERE donhang.makhachhang = khachhang.makhachhang AND donhang.masanpham = sanpham.masanpham; " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ResultSet rs = ps.executeQuery() ; 
			  while(rs.next()) {
				      String madonhang =  rs.getString("madonhang");
	     		      String makhachhang =  rs.getString("hoten");
				 	  String tensanpham =  rs.getString("tensanpham");
				 	  String giatien = rs.getString("giatien");
				 	  int soluong = rs.getInt("soluong");
		    	 donhang dh = new donhang(madonhang   , tensanpham , makhachhang ,giatien ,soluong);
				 
				 ketqua.add(dh) ; 
			  }
			  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  return ketqua ; 
	  }
	  
	  public ArrayList<donhang> timkiemdh (String timkiem) {
		 ArrayList<donhang> ketqua = new ArrayList<donhang>() ; 
		 try {
			 
			 Connection con = JDBCutil.getConnection() ; 
			 String sql = "SELECT donhang.madonhang , khachhang.hoten , sanpham.tensanpham , donhang.giatien ,donhang.soluong from donhang , khachhang , sanpham \r\n"
			 		+ "WHERE donhang.makhachhang = khachhang.makhachhang AND donhang.masanpham = sanpham.masanpham AND donhang.makhachhang LIKE ?  " ;
			 PreparedStatement ps = con.prepareStatement(sql) ; 
			 ps.setString(1, "%"+ timkiem + "%");
			 
			 ResultSet rs = ps.executeQuery() ;
			 while (rs.next()) {
				 String madonhang = rs.getString("madonhang") ;
				 String hoten = rs.getString("hoten") ;
				 String tensanpham = rs.getString("tensanpham") ;
				 String giatien = rs.getString("giatien") ;
				 int soluong = rs.getInt("soluong");
				 
				 donhang dh = new donhang(madonhang, hoten, tensanpham, giatien , soluong) ;
				 ketqua.add(dh);			 
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  return ketqua ;
	  }
	  public boolean kiemtradonhang(String mkh) {
		  boolean ketqua = false ;
		  try {
			  
			  Connection con = JDBCutil.getConnection() ;
			  String sql = "select * from donhang where makhachhang = ? " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
				
				ps.setString(1, mkh);
				ResultSet rs = ps.executeQuery() ; 
				while (rs.next()) {
					ketqua = true ; 
				}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		  	  
		  return ketqua ;
	  }
	
	  public static void main(String[] args) {
		donhangDao dhd = new donhangDao() ;
      List<donhang> dh2 = dhd.dodonhang() ;
      for (donhang donhang : dh2) {
		System.out.println(dh2);
	}
      
	}
	

}
