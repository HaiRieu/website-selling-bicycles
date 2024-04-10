package model;

public class giohang1 {
	
	private String magiohang ;
	private String masanpham ;
	private String makhachang ; 
	private int soluong ;
	private int giatien ; 
	
	
	

	public giohang1(String magiohang, String masanpham, String makhachang, int soluong, int giatien) {
	
		this.magiohang = magiohang;
		this.masanpham = masanpham;
		this.makhachang = makhachang;
		this.soluong = soluong;
		this.giatien = giatien;
	}
	
	

	public giohang1(String masanpham) {
	
		this.masanpham = masanpham;
	}



	public giohang1(String magiohang, String masanpham, int soluong, int giatien) {
	
		this.magiohang = magiohang;
		this.masanpham = masanpham;
		this.soluong = soluong;
		this.giatien = giatien;
	}



	public giohang1() {
		
	}

	public String getMagiohang() {
		return magiohang;
	}

	public void setMagiohang(String magiohang) {
		this.magiohang = magiohang;
	}

	public String getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}

	public String getMakhachang() {
		return makhachang;
	}

	public void setMakhachang(String makhachang) {
		this.makhachang = makhachang;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getGiatien() {
		return giatien;
	}

	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}
	
	
	
	
	

}
