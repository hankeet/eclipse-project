package com.ynufe.db;

//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//编写查询数据的类
public class SelectDB {
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
		ResultSet rs=null;
		String sql="select * from g005";
		
		
		
		//按六步法则完成编程
		//第一步
		try {
			Class.forName(className);
			System.out.println("甲骨文数据库加载主类成功！！！");
		} catch (ClassNotFoundException e) {
			// 异常处理（查不到类的异常）
			System.out.println("甲骨文数据库加载失败！！！");
			e.printStackTrace();
		}
		
		//第二步：创建连接
		//连接六要素：4+1+1
		//url -统一资源定位符 可以帮助程序员找到服务器上的数据库
		//驱动类型、服务器、端口、数据库
		//账号（1要素）
		//密码（2要素）
		
		try {
			//通过六要素连接数据库，创建一个库连接对象
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("恭喜，甲骨文数据库连接成功,且创建连接对象成功！！");
		} catch (SQLException e) {
			// 异常处理（SQL数据库语言异常）
			System.out.println("数据库连接不成功，请检查相关要素！！！");
			e.printStackTrace();
		}
//		第三步，创建语句
//		通过连接对象conn产生新的语句对象
		try {
			st=conn.createStatement();
			System.out.println("创建语句对象成功！！！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建语句对象失败，请修改程序！！！");
			e.printStackTrace();
		} 

		
//第四步：执行语句
		try {
			//完成查询，将结果集放入rs中
			rs=st.executeQuery(sql);
			System.out.println("执行SQL语句成功！！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行SQL语句失败！！");
			e.printStackTrace();
		}
		
		
		
//第五步：输出结果
//通过结果集ResultSet,进行遍历查询，循环输出rs
		System.out.println("liping的商品表数据如下：");
		try {
			while (rs.next()) {
				//System.out.println("ok!");
				System.out.println(
								  rs.getInt(1)+"\t"+rs.getString(2)+
								  "\t"+rs.getFloat(3)+"\t"+rs.getString(4)+
								  "\t"+rs.getString(5)+"\t"+rs.getString(6)
								  );
			}
		} catch (SQLException e) {
			// 异常处理（SQL异常）
			System.out.println("输出失败！");
			e.printStackTrace();
		}
		

//第六步：关闭连接对象
//正向 conn st rs
		
		try {
			rs.close();
			st.close();
			rs.close();
			System.out.println("所有对象连接已关闭！！！");
		} catch (SQLException e) {
			// 异常处理 （SQL语句）
			e.printStackTrace();
		}
		
		
		
	}
}
