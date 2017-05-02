package com.ynufe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDB {

	public static void main(String[] args) {
		System.out.println("我日！");
		String className="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		//thin是简单连接，高级连接用oci
		String user="liping";
		String password="123456";
		//提前声明定义三个重要对象（变量）
		Connection conn=null;//定义连接对象（变量）并初始化为空
		java.sql.Statement st=null;
		int rs=0;
		String sql1="insert into g005 values (22,'iphone se',3990,'iphone','black','USA')";
		
		try {
			Class.forName(className);
			System.out.println("甲骨文数据库加载主类成功！！！");
		} catch (ClassNotFoundException e) {
			// 异常处理（查不到类的异常）
			System.out.println("甲骨文数据库加载失败！！！");
			e.printStackTrace();
		}
		
		try {
			//通过六要素连接数据库，创建一个库连接对象
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("恭喜，甲骨文数据库连接成功,且创建连接对象成功！！");
		} catch (SQLException e) {
			// 异常处理（SQL数据库语言异常）
			System.out.println("数据库连接不成功，请检查相关要素！！！");
			e.printStackTrace();
		}
		
		try {
			st=conn.createStatement();
			System.out.println("创建语句对象成功！！！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建语句对象失败，请修改程序！！！");
			e.printStackTrace();
		} 
		
		
		try {
			//完成插入，将结果集放入rs中zz
			rs=st.executeUpdate(sql1);
			System.out.println("执行插入语句成功！！");
			System.out.println("查询结果如下：");
			SelectDB selectDB=new SelectDB();//实例化一个SelectDB 
			SelectDB.main(args);//调用SelectDB的main()方法
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行SQL语句失败！！");
			e.printStackTrace();
		}
		
		
		try {
			st.close();
			System.out.println("所有对象连接已关闭！！");
		} catch (SQLException e) {
			// 异常处理 （SQL语句）
			e.printStackTrace();
		}
	}
}
