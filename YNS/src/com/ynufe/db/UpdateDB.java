package com.ynufe.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class UpdateDB {
public static void main(String[] args) {
	String className="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	//thin�Ǽ����ӣ��߼�������oci
	String user="liping";
	String password="123456";
	//��ǰ��������������Ҫ���󣨱�����
	Connection conn=null;//�������Ӷ��󣨱���������ʼ��Ϊ��
	java.sql.Statement st=null;
	int rs=0;
	String sql="update g005 set name='yew' where id=2";
	
	
	
	
	try {
		Class.forName(className);
		conn=DriverManager.getConnection(url, user, password);
		st=conn.createStatement();
		rs=st.executeUpdate(sql);
		System.out.println("ִ�и��³ɹ���");
		SelectDB selectDB=new SelectDB();
		SelectDB.main(args);
	} catch (Exception e) {
		System.out.println("���ݸ���ʧ�ܣ�");
	}
	
	try {
		st.close();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("���ӹر�ʧ�ܣ�");
	}
}
}
