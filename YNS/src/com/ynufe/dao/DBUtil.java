package com.ynufe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��д���ݿ⹤���࣬����DAO���������ֳ���ҵ����з�װ
//���̣��Ƚ����ܷ�װ����д�����ķ��� ����> �ٵ��ò�ͬ������ʵ��ҵ��
public class DBUtil {
	
//��ǰ�������� �ĸ��ֱ���
	Connection conn=null;//���Ӷ���
	Statement stat=null;//������
	ResultSet rs=null;//���������
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String user="liping";
	String password="123456";
	
	String sql="insert into g005 values (8,'sm',2345,'sm','black','Korea')";
	
//��һ������������
	public Connection getConn() throws Exception {
		//��������-��������-��������
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("�������سɹ������ݿ����ӳɹ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ����ݿ�����ʧ�ܣ�");
		}
		
		
		return conn;
	}
	
//�ڶ����������ر�
	public void getClose() {
//�ر����Ӷ����ͷ���Դ����Լϵͳռ�õ�CPU������
		try {
			if (rs!=null) {
				rs.close();
				System.out.println("���������رգ�");
			}
			if (stat!=null) {
				stat.close();
				System.out.println("������رգ�");
			}
			if (conn!=null) {
				conn.close();
				System.out.println("���Ӷ���رգ�");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//����������������

	
	
//ͨ��main()����������������ڣ����÷���
	
//	public static void main(String[] agrs) {
//		//���̣����ù��췽�������������ɶ�����÷���
//		DBUtil lp=new DBUtil();
//		try {
//			lp.getConn();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
