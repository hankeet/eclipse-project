package com.ynufe.db;

//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//��д��ѯ���ݵ���
public class SelectDB {
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
		ResultSet rs=null;
		String sql="select * from g005";
		
		
		
		//������������ɱ��
		//��һ��
		try {
			Class.forName(className);
			System.out.println("�׹������ݿ��������ɹ�������");
		} catch (ClassNotFoundException e) {
			// �쳣�����鲻������쳣��
			System.out.println("�׹������ݿ����ʧ�ܣ�����");
			e.printStackTrace();
		}
		
		//�ڶ�������������
		//������Ҫ�أ�4+1+1
		//url -ͳһ��Դ��λ�� ���԰�������Ա�ҵ��������ϵ����ݿ�
		//�������͡����������˿ڡ����ݿ�
		//�˺ţ�1Ҫ�أ�
		//���루2Ҫ�أ�
		
		try {
			//ͨ����Ҫ���������ݿ⣬����һ�������Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("��ϲ���׹������ݿ����ӳɹ�,�Ҵ������Ӷ���ɹ�����");
		} catch (SQLException e) {
			// �쳣����SQL���ݿ������쳣��
			System.out.println("���ݿ����Ӳ��ɹ����������Ҫ�أ�����");
			e.printStackTrace();
		}
//		���������������
//		ͨ�����Ӷ���conn�����µ�������
		try {
			st=conn.createStatement();
			System.out.println("����������ɹ�������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����������ʧ�ܣ����޸ĳ��򣡣���");
			e.printStackTrace();
		} 

		
//���Ĳ���ִ�����
		try {
			//��ɲ�ѯ�������������rs��
			rs=st.executeQuery(sql);
			System.out.println("ִ��SQL���ɹ�����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ִ��SQL���ʧ�ܣ���");
			e.printStackTrace();
		}
		
		
		
//���岽��������
//ͨ�������ResultSet,���б�����ѯ��ѭ�����rs
		System.out.println("liping����Ʒ���������£�");
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
			// �쳣����SQL�쳣��
			System.out.println("���ʧ�ܣ�");
			e.printStackTrace();
		}
		

//���������ر����Ӷ���
//���� conn st rs
		
		try {
			rs.close();
			st.close();
			rs.close();
			System.out.println("���ж��������ѹرգ�����");
		} catch (SQLException e) {
			// �쳣���� ��SQL��䣩
			e.printStackTrace();
		}
		
		
		
	}
}
