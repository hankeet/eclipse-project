package com.ynufe.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class UpdateDB {
public static void main(String[] args) {
	String className="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	//thin是简单连接，高级连接用oci
	String user="liping";
	String password="123456";
	//提前声明定义三个重要对象（变量）
	Connection conn=null;//定义连接对象（变量）并初始化为空
	java.sql.Statement st=null;
	int rs=0;
	String sql="update g005 set name='yew' where id=2";
	
	
	
	
	try {
		Class.forName(className);
		conn=DriverManager.getConnection(url, user, password);
		st=conn.createStatement();
		rs=st.executeUpdate(sql);
		System.out.println("执行更新成功！");
		SelectDB selectDB=new SelectDB();
		SelectDB.main(args);
	} catch (Exception e) {
		System.out.println("数据更新失败！");
	}
	
	try {
		st.close();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("连接关闭失败！");
	}
}
}
