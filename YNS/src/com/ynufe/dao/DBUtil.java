package com.ynufe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//编写数据库工具类，利用DAO技术对六种常见业务进行封装
//流程：先将功能封装，编写独立的方法 ——> 再调用不同方法，实现业务
public class DBUtil {
	
//提前定义类中 的各种变量
	Connection conn=null;//连接对象
	Statement stat=null;//语句对象
	ResultSet rs=null;//结果集对象
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String user="liping";
	String password="123456";
	
	String sql="insert into g005 values (8,'sm',2345,'sm','black','Korea')";
	
//第一个方法，连接
	public Connection getConn() throws Exception {
		//加载驱动-创建连接-返回连接
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("驱动加载成功，数据库连接成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败，数据库连接失败！");
		}
		
		
		return conn;
	}
	
//第二个方法，关闭
	public void getClose() {
//关闭连接对象，释放资源，节约系统占用的CPU和内容
		try {
			if (rs!=null) {
				rs.close();
				System.out.println("结果集对象关闭！");
			}
			if (stat!=null) {
				stat.close();
				System.out.println("语句对象关闭！");
			}
			if (conn!=null) {
				conn.close();
				System.out.println("连接对象关闭！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//第三个方法，增加

	
	
//通过main()方法，开启程序入口，调用方法
	
//	public static void main(String[] agrs) {
//		//流程：先用构造方法创建对象，再由对象调用方法
//		DBUtil lp=new DBUtil();
//		try {
//			lp.getConn();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
