package test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class test1 {
	static DBConnect db=DBConnect.getInstance();
	public static void insert(mem m) {
		Connection conn=db.conn();
		// 실행할 쿼리문 작성
		
		String sql="insert into mem values(?,?,?,?)";
		// 자바에서 sql을 실행할 수 있는 preparedStatement 생성
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			int cnt=pstmt.executeUpdate(); //insert , update, delete 문장 실행,
			System.out.println(cnt+" excuted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			 insert(new mem ("dsaas","dasdsa","dasdsa","dsadsa"));
	}

}
