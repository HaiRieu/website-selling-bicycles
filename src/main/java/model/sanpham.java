package model;

public class sanpham {
  private String masanpham ; 
  private String tensanpham ; 
  private int soluong ;
  private int giatien ;
  private String anhsanpham ;
public sanpham(String masanpham, String tensanpham, int soluong, int giatien, String anhsanpham) {
	
	this.masanpham = masanpham;
	this.tensanpham = tensanpham;
	this.soluong = soluong;
	this.giatien = giatien;
	this.anhsanpham = anhsanpham;
}

public sanpham () {
	
}

public String getMasanpham() {
	return masanpham;
}
public void setMasanpham(String masanpham) {
	this.masanpham = masanpham;
}
public String getTensanpham() {
	return tensanpham;
}
public void setTensanpham(String tensanpham) {
	this.tensanpham = tensanpham;
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
public String getAnhsanpham() {
	return anhsanpham;
}
public void setAnhsanpham(String anhsanpham) {
	this.anhsanpham = anhsanpham;
}

@Override
public String toString() {
	return "sanpham [masanpham=" + masanpham + ", tensanpham=" + tensanpham + ", soluong=" + soluong + ", giatien="
			+ giatien + ", anhsanpham=" + anhsanpham + "]";
} 
 
  
}
