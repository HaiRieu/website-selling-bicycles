package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.donhang;
import model.giohang;
import model.giohang1;

public class giohangDao {
	
	public ArrayList<giohang1> data = new ArrayList<giohang1>() ; 

	
	  public int insert(giohang1 gh) {
		  int ketqua = 0 ; 
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "insert into giohang value (?,?,?,?,?) " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ps.setString(1, gh.getMagiohang());
			  ps.setString(2, gh.getMasanpham());
			  ps.setString(3, gh.getMakhachang());
			  ps.setInt(4, gh.getSoluong());
			  ps.setInt(5, gh.getGiatien());
			
			  ketqua = ps.executeUpdate() ; 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  
		  return ketqua ;
	  }
	  
	 
	  
	  public ArrayList<giohang1> timkiemdh (String timkiem) {
			 ArrayList<giohang1> ketqua = new ArrayList<giohang1>() ; 
			 try {
				 
				 Connection con = JDBCutil.getConnection() ; 
				 String sql = "SELECT giohang.magiohang ,sanpham.masanpham, sanpham.tensanpham , giohang.soluong , giohang.giatien from giohang ,sanpham\r\n"
				 		+ "WHERE  giohang.masanpham = sanpham.masanpham AND giohang.makhachhang LIKE ?  " ;
				 PreparedStatement ps = con.prepareStatement(sql) ; 
				 ps.setString(1, "%"+ timkiem + "%");
				 
				 ResultSet rs = ps.executeQuery() ;
				 while (rs.next()) {
					 String magiohang = rs.getString("magiohang") ;
					 String masanpham = rs.getString("masanpham");
					 String tensanpham = rs.getString("tensanpham") ;
					 int soluong = rs.getInt("soluong") ;
					 int  giatien = rs.getInt("giatien") ;
					 
					giohang1 gh1 = new giohang1(magiohang,masanpham, tensanpham, soluong, giatien);
					ketqua.add(gh1);		 
				 }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  
			  return ketqua ;
		  }
	  public ArrayList<giohang1> timkiemgh (String timkiem) {
			 ArrayList<giohang1> ketqua = new ArrayList<giohang1>() ; 
			 try {
				 
				 Connection con = JDBCutil.getConnection() ; 
				 String sql = "SELECT giohang.masanpham from giohang \r\n"
				 		+ "WHERE  giohang.makhachhang LIKE ?  " ;
				 PreparedStatement ps = con.prepareStatement(sql) ; 
				 ps.setString(1, "%"+ timkiem + "%");
				 
				 ResultSet rs = ps.executeQuery() ;
				 while (rs.next()) {
					
					 String masanpham = rs.getString("masanpham");
					
					 
					giohang1 gh1 = new giohang1(masanpham);
					ketqua.add(gh1);		 
				 }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  
			  return ketqua ;
		  }
	  
	  public int xoagh(String mgh) {
		  int ketqua = 0 ;
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "delete from giohang where magiohang = ?  " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ps.setString(1,mgh);
			  ketqua = ps.executeUpdate() ; 
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  return ketqua ;
	  }
	  public int suagh(int soluong , int giatien ,  String mgh ) {
		  int ketqua = 0 ;
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "update giohang set soluong = ? , giatien = ? where magiohang = ?  " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ps.setInt(1,soluong);
			  ps.setInt(2,giatien);
			  ps.setString(3, mgh);
			  ketqua = ps.executeUpdate() ; 
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  return ketqua ;
	  }
	  public int suaghh(int soluong, int giatien ,String mgh ) {
		  int ketqua = 0 ;
		  try {
			  Connection con = JDBCutil.getConnection() ; 
			  String sql = "update giohang set soluong = ? , giatien = ? where magiohang = ?  " ; 
			  PreparedStatement ps = con.prepareStatement(sql) ; 
			  ps.setInt(1,soluong);
			  ps.setInt(2, giatien);
			  ps.setString(3, mgh);
			  ketqua = ps.executeUpdate() ; 
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  return ketqua ;
	  }
	  public static void main(String[] args) {
		giohangDao ghd = new giohangDao() ;
		giohang1 gh = new giohang1("12", "22","22" , 2,2 ) ;
		ghd.insert(gh);
	}
	
}
