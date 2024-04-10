package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.binhluan;
import model.donhang;


public class binhluanDao {
	public ArrayList<binhluan> data = new ArrayList<binhluan>() ; 
	  
	  public ArrayList<binhluan> selectAll() {
		  ArrayList<binhluan> ketqua = new ArrayList<binhluan>() ;
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "select * from binhluan " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ResultSet rs = ps.executeQuery() ; 
			  while(rs.next()) {
				String makhachhang =  rs.getString("makhachhang");
				  String noidung =  rs.getString("noidung");
	     		 String masanpham = rs.getString("masanpham");
	     		
				 binhluan bl = new binhluan(makhachhang, noidung,masanpham) ;
				 
				 ketqua.add(bl) ; 
			  }
			  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  return ketqua ; 
	  }
	  
	  public int insert(binhluan bl) {
		  int ketqua = 0 ; 
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "insert into binhluan value (?,?,?) " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ps.setString(1, bl.getMakhachhang());
			  ps.setString(2, bl.getNoidung());
			  ps.setString(3, bl.getMasanpham());
			  ketqua = ps.executeUpdate() ; 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  
		  return ketqua ;
	  }
	  
	  public ArrayList<binhluan> noidung() {
		  ArrayList<binhluan> ketqua = new ArrayList<binhluan>() ;
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "SELECT khachhang.hoten, binhluan.noidung  FROM  binhluan , khachhang \r\n"
			  		+ "WHERE binhluan.makhachhang = khachhang.makhachhang" ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ResultSet rs = ps.executeQuery() ; 
			  while(rs.next()) {
	     		      String makhachhang =  rs.getString("hoten");
				 	  String noidung =  rs.getString("noidung");
				 	
		    	binhluan bl = new binhluan(makhachhang, noidung) ; 
				 
				 ketqua.add(bl) ; 
			  }
			  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  return ketqua ; 
	  }
	  
	  public static void main(String[] args) {
		/*binhluanDao bld = new binhluanDao() ;
		List<binhluan> bl = bld.selectAll() ;
		for (binhluan binhluan : bl) {
			System.out.println(bl);
		}*/
		  
		  binhluanDao bld = new binhluanDao() ;
		  binhluan bl = new binhluan("11", "22", "33");
		  bld.insert(bl);
	}

}
