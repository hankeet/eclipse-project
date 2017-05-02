package com.ynufe.dao;

public class Show {
	public static void main(String[] args) {
		DBUtil lp=new DBUtil();
		
		try {
			lp.getConn();
			lp.getClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
