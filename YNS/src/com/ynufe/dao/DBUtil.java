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
	
	String insertSql="insert into g005 values (2,'on7 17',2345,'sm','black','Korea')";
	String selectSql="select * from g005";
	String deleteSql="delete from g005 where id =2 ";
	String updateSql="update g005 set name='good' where id=4";
	
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
	public void insert() {
		//�������������������ӡ����������󡪡�ִ����䡪�������������ر�����
		//�������ӷ��������ǰ������
		try {
			//conn=getConn();//�������ӷ������ȴ����ݿ������
			stat=conn.createStatement();//����������
			stat.executeUpdate(insertSql);//����stat�����insert����
			rs=stat.executeQuery(selectSql);//����stat�����Select����
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+
								  "\t"+rs.getFloat(3)+"\t"+rs.getString(4)+
								  "\t"+rs.getString(5)+"\t"+rs.getString(6)
								  );
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		getClose();
	}
//���ĸ���������ѯ
	public void select() throws Exception {
		//conn=getConn();//�������ӷ������ȴ����ݿ������
		stat=conn.createStatement();
		rs=stat.executeQuery(selectSql);//����ѯ�Ľ������rs
		while (rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+
							  "\t"+rs.getFloat(3)+"\t"+rs.getString(4)+
							  "\t"+rs.getString(5)+"\t"+rs.getString(6)
							  );
		}
		getClose();
	}
	
	
	
//�����������ɾ��
	
	
	public void delete() throws Exception {
		//conn=getConn();//�������ӷ������ȴ����ݿ������
		stat=conn.createStatement();
		stat.executeUpdate(deleteSql);
		rs=stat.executeQuery(selectSql);
		while (rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+
							  "\t"+rs.getFloat(3)+"\t"+rs.getString(4)+
							  "\t"+rs.getString(5)+"\t"+rs.getString(6)
							  );
		}
		getClose();
	}
	
//����������������
	public void update() throws Exception {
		//conn=getConn();//�������ӷ������ȴ����ݿ������
		stat=conn.createStatement();
		stat.executeUpdate(updateSql);
		rs=stat.executeQuery(selectSql);
		while (rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+
					  "\t"+rs.getFloat(3)+"\t"+rs.getString(4)+
					  "\t"+rs.getString(5)+"\t"+rs.getString(6)
					  );
			
		}
		getClose();
	}
	
	
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
