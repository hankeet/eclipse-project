package com.ynufe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDB {

	public static void main(String[] args) {
		System.out.println("���գ�");
		String className="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		//thin�Ǽ����ӣ��߼�������oci
		String user="liping";
		String password="123456";
		//��ǰ��������������Ҫ���󣨱�����
		Connection conn=null;//�������Ӷ��󣨱���������ʼ��Ϊ��
		java.sql.Statement st=null;
		int rs=0;
		String sql1="insert into g005 values (22,'iphone se',3990,'iphone','black','USA')";
		
		try {
			Class.forName(className);
			System.out.println("�׹������ݿ��������ɹ�������");
		} catch (ClassNotFoundException e) {
			// �쳣�����鲻������쳣��
			System.out.println("�׹������ݿ����ʧ�ܣ�����");
			e.printStackTrace();
		}
		
		try {
			//ͨ����Ҫ���������ݿ⣬����һ�������Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("��ϲ���׹������ݿ����ӳɹ�,�Ҵ������Ӷ���ɹ�����");
		} catch (SQLException e) {
			// �쳣����SQL���ݿ������쳣��
			System.out.println("���ݿ����Ӳ��ɹ����������Ҫ�أ�����");
			e.printStackTrace();
		}
		
		try {
			st=conn.createStatement();
			System.out.println("����������ɹ�������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����������ʧ�ܣ����޸ĳ��򣡣���");
			e.printStackTrace();
		} 
		
		
		try {
			//��ɲ��룬�����������rs��zz
			rs=st.executeUpdate(sql1);
			System.out.println("ִ�в������ɹ�����");
			System.out.println("��ѯ������£�");
			SelectDB selectDB=new SelectDB();//ʵ����һ��SelectDB 
			SelectDB.main(args);//����SelectDB��main()����
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ִ��SQL���ʧ�ܣ���");
			e.printStackTrace();
		}
		
		
		try {
			st.close();
			System.out.println("���ж��������ѹرգ���");
		} catch (SQLException e) {
			// �쳣���� ��SQL��䣩
			e.printStackTrace();
		}
	}
}
