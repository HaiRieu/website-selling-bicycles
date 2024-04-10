package model;

public class admin {
 private String maadmin ;
 private String taikhoaadmin ; 
 private String matkhauadmin ;
public admin(String maadmin, String taikhoaadmin, String matkhauadmin) {
	this.maadmin = maadmin;
	this.taikhoaadmin = taikhoaadmin;
	this.matkhauadmin = matkhauadmin;
} 
public admin () {
	
}
public String getMaadmin() {
	return maadmin;
}
public void setMaadmin(String maadmin) {
	this.maadmin = maadmin;
}
public String getTaikhoaadmin() {
	return taikhoaadmin;
}
public void setTaikhoaadmin(String taikhoaadmin) {
	this.taikhoaadmin = taikhoaadmin;
}
public String getMatkhauadmin() {
	return matkhauadmin;
}
public void setMatkhauadmin(String matkhauadmin) {
	this.matkhauadmin = matkhauadmin;
}

 
 
}
