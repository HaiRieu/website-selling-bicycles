package model;

import java.util.Date;

public class khachhang {
	private String makhachhang ; 
	private String tenkhachhang ; 
	private String gioitinh ; 
	private String sodienthoai ;
	private String diachi ;
	private String email ; 
	private String tentaikhoan ; 
	private String matkhau ;
	private String duongdananh ; 
	public khachhang(String makhachhang, String tenkhachhang, String gioitinh, String sodienthoai, String diachi,
			String email, String tentaikhoan, String matkhau) {
		
		this.makhachhang = makhachhang;
		this.tenkhachhang = tenkhachhang;
		this.gioitinh = gioitinh;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.email = email;
		this.tentaikhoan = tentaikhoan;
		this.matkhau = matkhau;
	}
	

	public khachhang(String makhachhang, String tenkhachhang, String gioitinh, String sodienthoai, String diachi,
			String email, String tentaikhoan, String matkhau, String duongdananh) {
		
		this.makhachhang = makhachhang;
		this.tenkhachhang = tenkhachhang;
		this.gioitinh = gioitinh;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.email = email;
		this.tentaikhoan = tentaikhoan;
		this.matkhau = matkhau;
		this.duongdananh = duongdananh;
	}


	public khachhang() {
		
	}
	

	public khachhang(String tenkhachhang, String gioitinh, String sodienthoai, String diachi, String email) {
		this.tenkhachhang = tenkhachhang;
		this.gioitinh = gioitinh;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.email = email;
	}

	public khachhang(String tentaikhoan, String matkhau) {

		this.tentaikhoan = tentaikhoan;
		this.matkhau = matkhau;
	}

	
	public khachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}


	public String getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTentaikhoan() {
		return tentaikhoan;
	}

	public void setTentaikhoan(String tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}


	public String getDuongdananh() {
		return duongdananh;	
	}


	public void setDuongdananh(String duongdananh) {
		this.duongdananh = duongdananh;
	}
	
	

}
