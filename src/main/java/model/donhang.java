package model;

public class donhang {
 private String madonhang ;
 private String msp ;
 private String makhachhang ; 
 private String giatien ; 
 private int soluong ; 

 public donhang() {
	 
 }
 

public donhang(String madonhang, String msp, String makhachhang, String giatien, int soluong) {
	this.madonhang = madonhang;
	this.msp = msp;
	this.makhachhang = makhachhang;
	this.giatien = giatien;
	this.soluong = soluong;
}


public donhang(String madonhang, String msp, String makhachhang, String giatien) {

	this.madonhang = madonhang;
	this.msp = msp;
	this.makhachhang = makhachhang;
	this.giatien = giatien;
}

public String getMadonhang() {
	return madonhang;
}

public void setMadonhang(String madonhang) {
	this.madonhang = madonhang;
}

public String getMsp() {
	return msp;
}

public void setMsp(String msp) {
	this.msp = msp;
}

public String getMakhachhang() {
	return makhachhang;
}

public void setMakhachhang(String makhachhang) {
	this.makhachhang = makhachhang;
}


public String getGiatien() {
	return giatien;
}

public void setGiatien(String giatien) {
	this.giatien = giatien;
}


public int getSoluong() {
	return soluong;
}


public void setSoluong(int soluong) {
	this.soluong = soluong;
}


@Override
public String toString() {
	return "donhang [madonhang=" + madonhang + ", msp=" + msp + ", makhachhang=" + makhachhang + "]";
}

 
 
 
 
}
