package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.giohang;
import model.sanpham;

public class sanphamDao {
  public ArrayList<sanpham> data = new ArrayList<sanpham>() ; 
  
  public ArrayList<sanpham> selectAll() {
	  ArrayList<sanpham> ketqua = new ArrayList<sanpham>() ;
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "select * from sanpham " ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  ResultSet rs = ps.executeQuery() ; 
		  while(rs.next()) {
			 String masanpham =  rs.getString("masanpham");
			 String tensanpham =  rs.getString("tensanpham");
			 int soluong =  rs.getInt("soluong");
			 int giatien =  rs.getInt("giatien");
			 String anhsanpham =  rs.getString("anhsanpham");
			 
			 sanpham sp = new sanpham(masanpham, tensanpham, soluong, giatien, anhsanpham) ;
			 
			 ketqua.add(sp) ; 
		  }
		  
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  
	  return ketqua ; 
  }
  
  public ArrayList<sanpham> timkiemsanpham (String timkiem) {
	  ArrayList<sanpham> ketqua = new ArrayList<sanpham>() ;
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "select * from sanpham where tensanpham like ? " ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  ps.setString(1, "%"+ timkiem +"%");
		  
		  ResultSet rs = ps.executeQuery() ; 
		  while(rs.next()) {
			 String masanpham =  rs.getString("masanpham");
			 String tensanpham =  rs.getString("tensanpham");
			 int soluong =  rs.getInt("soluong");
			 int giatien =  rs.getInt("giatien");
			 String anhsanpham =  rs.getString("anhsanpham");
			 
			 sanpham sp = new sanpham(masanpham, tensanpham, soluong, giatien, anhsanpham) ;
			 
			 ketqua.add(sp) ; 
		  }
		  
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	return ketqua;
  }
  public int insert(sanpham sp) {
	  int ketqua = 0 ; 
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "insert into sanpham value (?,?,?,?,?) " ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  
		
		  
		  ps.setString(1, sp.getMasanpham());
		  ps.setString(2, sp.getTensanpham());
		  ps.setInt(3, sp.getSoluong());
		  ps.setInt(4,  sp.getGiatien());
		  ps.setString(5, sp.getAnhsanpham());
		  
		  ketqua = ps.executeUpdate() ; 
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  
	  
	  return ketqua ;
  }
  
  public int xoasp(String msp) {
	  int ketqua = 0 ;
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "delete from sanpham where masanpham = ?  " ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  ps.setString(1,msp);
		  ketqua = ps.executeUpdate() ; 
		  
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  return ketqua ;
  }
  
  public List<giohang> duyet(ArrayList<giohang> giohang) {
	  
	  List<giohang> giohangd = new ArrayList<giohang>();
	  try {
		  Connection con = JDBCutil.getConnection() ;
		  
		if(giohang.size() > 0 ) {
		  for (giohang item : giohang) {
			String sql = "select * from sanpham where masanpham = ? " ;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, item.getMagiohang());
			ResultSet rs = ps.executeQuery() ;
			while (rs.next()) {
				giohang gh = new giohang() ;
				gh.setMagiohang(rs.getLong("masanpham"));
				gh.setTensanpham(rs.getString("tensanpham"));
				gh.setSoluong(rs.getInt("soluong"));
				gh.setGiatien(rs.getInt("giatien"));
			giohangd.add(gh) ;
			}
			
		}
	  }
	  
	} catch (Exception e) {
	e.printStackTrace();
	}
	  
	  return giohangd ;
  }
  
  
  public sanpham getsanphamID(String masp){

	  ArrayList<sanpham> ketqua = new ArrayList<sanpham>() ;
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "select * from sanpham where masanpham = ?" ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  ps.setString(1, masp);
		  ResultSet rs = ps.executeQuery() ; 
		  while(rs.next()) {
		  return new sanpham( rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)) ;
		  }
		  
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return null ; 
		
	  }
  
  public ArrayList<sanpham> getsanphamID2(String masp){

	  ArrayList<sanpham> ketqua = new ArrayList<sanpham>() ;
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "select * from sanpham where masanpham = ?" ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  ps.setString(1, masp);
		  ResultSet rs = ps.executeQuery() ; 
		  while(rs.next()) {
		  sanpham sp = new  sanpham( rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)) ;
		 ketqua.add(sp);
		  }
		  
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		return ketqua ; 
	  }
  
  public int suasp(int soluong , String msp ) {
	  int ketqua = 0 ;
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "update sanpham set soluong = ?  where masanpham = ?  " ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  ps.setInt(1,soluong);
		
		  ps.setString(2, msp);
		  ketqua = ps.executeUpdate() ; 
		  
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  return ketqua ;
  }
  
  public int suaspp( String tensp ,int sl , int giatien ,String msp ) {
	  int ketqua = 0 ;
	  try {
		  Connection con = JDBCutil.getConnection() ; 
		  String sql = "update sanpham set tensanpham = ? , soluong = ? , giatien = ? where masanpham = ?  " ; 
		  PreparedStatement ps = con.prepareStatement(sql) ; 
		  ps.setString(1, tensp);
		  ps.setInt(2, sl);
		  ps.setInt(3, giatien);
		  ps.setString(4, msp);
		  ketqua = ps.executeUpdate() ; 
		  
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  return ketqua ;
  }
  
  
  public static void main(String[] args) {
	  sanphamDao spd = new sanphamDao() ;
	  sanpham sp = spd.getsanphamID("1700467749201");
	  System.out.println(sp);
	  
	
}
  
  
}
