/*
�ڹٿ��� �����ͺ��̽� �����ϴ� ����� ������ JDBC (Java DataBase Connectivity)��� �ϸ�
java.sql ��Ű������ api�� �����ȴ�

�����ͺ��̽� ���� ������ ����
1. DB ������ �˸´� ����̹��� �ε� (oracle, mysql, mssql...���� jar�� �ʿ���)
2. ����
3. ���ϴ� ���� ����
4. �������� (Ư�� ��Ʈ�� �� DB�� ��� �� �ݵ�� ��������)
�Ⱥ��� ĥ �� ���������� ����!
*/

package day1105.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class OracleTest{
	public static void main(String[] args){
		Connection con = null;	//�޼����� ���������� �ݵ�� �ʱ�ȭ�ؾ���(�������ó�� �ڵ����� ���ִ��� ����!)
		PreparedStatement pstmt = null;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 1.����ϰ��� �ϴ� ����̹� Ŭ������ ���! (Ŭ���� �ε�)
			//���� ������� os�÷����� Ŭ�����н��� ��ϵǾ� �־�� �Ѵ�
			System.out.println("����̹� �ε� ����");

			// 2.DB������ url, id, password�� �̿��� ���ӽõ�
			String url = "jdbc:oracle:thin:@localhost:1521:XE";	//������ ��Ģ! �ϱ��ؾ���
			String user="user1104";
			String password = "user1104";

			//���ӽõ���, ������ �����Ǹ� Connection �̶�� �������̽��� �ν��Ͻ��� ��ȯ����!
			//Connection���� ������ ���� ������ ����ִ�!
			//���� ���� ���δ� Connection ��ü�� null ���η� �Ǵ��Ѵ�!
			con = DriverManager.getConnection(url, user, password);	//���ӽõ�!
			if(con==null){
				System.out.println("���ӽ���");
			}else{
				System.out.println("���Ӽ���");

				// 3.������ ���������Ƿ�, �������� ������ �� �ִ�
				//�������� �����ϴ� ��ü�� PreparedStatement (�������̽�) �̴�!
				String sql = "insert into member(member_id, name, age, phone)";
				sql += " values(seq_member.nextval, 'adams', 38, '010')";
				
				//������ �����Ǿ��, �������� ������ �� �����Ƿ�, Connection ��ü�κ��� �ν��Ͻ��� ���;� �Ѵ�(�������̽��̹Ƿ� new�� ����)
				pstmt = con.prepareStatement(sql);	//���������� �غ�!
				
				//���� ���� �� �������θ� �Ǵ��ϱ� ���ؼ��� executeUpdate() �޼����� ��ȯ���� �̿��Ѵ�
				//��ȯ���� int ���̸�, ������ ���࿡ ���� �ݿ��� ���ڵ��� ���� ��ȯ�Ѵ�
				//���� insert�� ��� ��ȯ���� 1, update, delete�� ����� ����޾Ҵ��� �˼��� ����... ���ǿ� ���� �ٸ�
				//�׷����� insert, update, delete�� ��� 0�̶�� ���з� �����ϸ� �ȴ�!
				int result = pstmt.executeUpdate();	//DML(insert, update, delete) ��������� �� �޼��� �����
				if(result!=1){
					System.out.println("�Է½���");
				}else{
					System.out.println("�Է¼���");
				}
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("������ ����̹��� ã�� �� �����ϴ�");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//db������ ���Ǿ��� ��� ��ü�� �ݾƾ� �Ѵ� (�湮(pstmt)�ݰ�, �빮(con)�ݰ�)
			if(pstmt!=null){	//�����Ҷ��� �ݴ´�...
				try{
					pstmt.close();
				}catch(SQLException e){
				}
			}
			if(con!=null){	//�����Ҷ��� �ݴ´�...
				try{
					con.close();
				}catch(SQLException e){
				}
			}
		}
	}
}
