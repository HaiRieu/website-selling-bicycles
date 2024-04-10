package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.khachhang;

public class khachhangDao {

	public ArrayList<khachhang> data = new ArrayList<khachhang>() ; 
	 
	public ArrayList<khachhang> selectAll () {
		ArrayList<khachhang> ketqua = new ArrayList() ; 
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = "select * from khachhang " ; 
			PreparedStatement ps = con.prepareStatement(sql) ; 
			ResultSet rs = ps.executeQuery() ; 
			
			while (rs.next()) {
				String makhachhang = rs.getString("makhachhang") ; 
				String tenkhachhang = rs.getString("hoten") ; 
				String gioitinh = rs.getString("gioitinh") ; 
				String sodienthoai = rs.getString("sodienthoai") ; 
				String diachi = rs.getString("diachi") ; 
				String email = rs.getString("email") ; 
				String tendangnhap = rs.getString("tendangnhap") ; 
				String matkhau = rs.getString("matkhau") ; 
				String duongdananh = rs.getString("duongdananh") ; 
				
				khachhang khmoi = new khachhang(makhachhang, tenkhachhang, gioitinh, sodienthoai, diachi, email, tendangnhap, matkhau,duongdananh) ; 
				ketqua.add(khmoi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua ; 
	} 
	public  khachhang selectId (khachhang kh) {
		khachhang ketqua = null ;
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = "select * from khachhang where tendangnhap = ? " ; 
			PreparedStatement ps = con.prepareStatement(sql) ; 
			
			ps.setString(1, kh.getTentaikhoan());
			
			ResultSet rs = ps.executeQuery() ; 
			
			while (rs.next()) {
				String makhachhang = rs.getString("makhachhang") ; 
				String tenkhachhang = rs.getString("hoten") ; 
				String gioitinh = rs.getString("gioitinh") ; 
				String sodienthoai = rs.getString("sodienthoai") ; 
				String diachi = rs.getString("diachi") ; 
				String email = rs.getString("email") ; 
				String tendangnhap = rs.getString("tendangnhap") ; 
				String matkhau = rs.getString("matkhau") ; 
				String duongdananh = rs.getString("duongdananh") ; 
				
				ketqua = new khachhang(makhachhang, tenkhachhang, gioitinh, sodienthoai, diachi, email, tendangnhap, matkhau,duongdananh) ; 
			   
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ketqua ;
	}
	
	public int insert (khachhang kh) {
		int ketqua = 0 ; 
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = "insert into khachhang values" + "(?,?,?,?,?,?,?,?,?)" ; 
			PreparedStatement ps = con.prepareStatement(sql) ; 
			ps.setString(1, kh.getMakhachhang());
			ps.setString(2, kh.getTenkhachhang());
			ps.setString(3, kh.getGioitinh());
			ps.setString(4, kh.getSodienthoai());
			ps.setString(5, kh.getDiachi());
			ps.setString(6, kh.getEmail());
			ps.setString(7, kh.getTentaikhoan());
			ps.setString(8, kh.getMatkhau());
			ps.setString(9, kh.getDuongdananh());
			ketqua = ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ketqua ;
	}
	
	public boolean kiemtrataikhoan(String  tendangnhap ) {
		boolean ketqua = false ;
		
		
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = " select * from khachhang where tendangnhap = ?" ; 
			PreparedStatement ps = con.prepareStatement(sql) ; 
			
			ps.setString(1, tendangnhap);
			ResultSet rs = ps.executeQuery() ; 
			while (rs.next()) {
				ketqua = true ; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ketqua ;
	}
	
	public khachhang kiemtramatkhau (khachhang kh) {
		khachhang ketqua = null ;
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = "select * from khachhang where tendangnhap = ? and matkhau = ?" ; 
			PreparedStatement ps = con.prepareStatement(sql) ; 
			ps.setString(1, kh.getTentaikhoan());
			ps.setString(2, kh.getMatkhau());
			
			ResultSet rs = ps.executeQuery() ; 
			while(rs.next()) {
				String makhachhang = rs.getString("makhachhang") ; 
				String tenkhachhang = rs.getString("hoten") ; 
				String gioitinh = rs.getString("gioitinh") ; 
				String sodienthoai = rs.getString("sodienthoai") ; 
				String diachi = rs.getString("diachi") ; 
				String email = rs.getString("email") ; 
				String tendangnhap = rs.getString("tendangnhap") ; 
				String matkhau = rs.getString("matkhau") ; 
				String duongdananh = rs.getString("duongdananh");
			
			ketqua = new khachhang(makhachhang, tenkhachhang, gioitinh, sodienthoai, diachi, email, tendangnhap, matkhau, duongdananh);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketqua ;
	}
	public boolean doimatkhau(khachhang kh ) {
		int ketqua = 0 ; 
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = "update khachhang  set matkhau = ? where tendangnhap = ?" ; 
			PreparedStatement ps = con.prepareStatement(sql) ;
			ps.setString(1, kh.getMatkhau());
			ps.setString(2, kh.getTentaikhoan()); 
			
			
			ketqua = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketqua > 0   ; 
		
	} 
	public boolean doithongtin(khachhang kh ) {
		int ketqua = 0 ; 
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = " update khachhang set hoten = ? , gioitinh = ? , sodienthoai = ? , diachi = ? , email = ?  where tendangnhap = ?" ;
		    PreparedStatement ps = con.prepareStatement(sql) ; 
		      ps.setString(1, kh.getTenkhachhang());
		      ps.setString(2, kh.getGioitinh());
		      ps.setString(3, kh.getSodienthoai());
		      ps.setString(4, kh.getDiachi());
		      ps.setString(5, kh.getEmail());
		      ps.setString(6, kh.getTentaikhoan());
		      
            ketqua = ps.executeUpdate() ; 
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ketqua > 0 ; 
	}
	
	public int thaydoianh (khachhang kh ) {
		int ketqua = 0 ; 
		try {
			Connection con = JDBCutil.getConnection() ; 
			String sql = "update khachhang set duongdananh = ? where tendangnhap = ? " ; 
			PreparedStatement ps = con.prepareStatement(sql) ; 
			ps.setString(1, kh.getDuongdananh());
			ps.setString(2, kh.getTentaikhoan());
			ketqua = ps.executeUpdate() ; 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ketqua ;
	}
	
	
	
	
}
