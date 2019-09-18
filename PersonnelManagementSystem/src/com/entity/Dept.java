package com.entity;

//应该啊导入哪个Date包? java.util???java.sql???
import java.util.Date;

public class Dept {
	private String deptno;
	private String deptname;
	private String depttype;
	private String depttel;
	private String deptfax;
	private String deptdesc;
	private String superiordept;
	private String establish;
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDepttype() {
		return depttype;
	}
	public void setDepttype(String depttype) {
		this.depttype = depttype;
	}
	public String getDepttel() {
		return depttel;
	}
	public void setDepttel(String depttel) {
		this.depttel = depttel;
	}
	public String getDeptfax() {
		return deptfax;
	}
	public void setDeptfax(String deptfax) {
		this.deptfax = deptfax;
	}
	public String getDeptdesc() {
		return deptdesc;
	}
	public void setDeptdesc(String deptdesc) {
		this.deptdesc = deptdesc;
	}
	public String getSuperiordept() {
		return superiordept;
	}
	public void setSuperiordept(String superiordept) {
		this.superiordept = superiordept;
	}
	public String getEstablish() {
		return establish;
	}
	public void setEstablish(String establish) {
		this.establish = establish;
	}
	
}
