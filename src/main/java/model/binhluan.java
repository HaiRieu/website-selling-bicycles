package model;

public class binhluan {
  private String makhachhang ; 
  private String noidung ;
  private String masanpham ; 


public binhluan(String makhachhang, String noidung, String masanpham) {

	this.makhachhang = makhachhang;
	this.noidung = noidung;
	this.masanpham = masanpham;
}



public binhluan(String makhachhang, String noidung) {
	
	this.makhachhang = makhachhang;
	this.noidung = noidung;
}



public String getMakhachhang() {
	return makhachhang;
}
public void setMakhachhang(String makhachhang) {
	this.makhachhang = makhachhang;
}
public String getNoidung() {
	return noidung;
}
public void setNoidung(String noidung) {
	this.noidung = noidung;
}


public String getMasanpham() {
	return masanpham;
}


public void setMasanpham(String masanpham) {
	this.masanpham = masanpham;
}


@Override
public String toString() {
	return "binhluan [makhachhang=" + makhachhang + ", noidung=" + noidung + "]";
}
  
  
}
