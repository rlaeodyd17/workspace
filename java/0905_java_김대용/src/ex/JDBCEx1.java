package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import util.ConnectionUtil;

public class JDBCEx1 {
	
	public static void main(String[] args) {
		
		System.out.println("추가할 장르를 입력하세요.");

		Scanner scan = new Scanner(System.in);
		
		String genres = scan.nextLine();
		
		scan.close();
		
		//정보입력
		Connection con = null;
	    PreparedStatement pstmt = null;
	
		
		
		try {
			con = ConnectionUtil.getConnection();
			//스테이트구문 생성
			String sql = "INSERT INTO genres (no,name) VALUES(genres_seq.nextval,?)";
			pstmt = con.prepareStatement(sql);
			System.out.println("스테이트구문 생성");
			
			//INSERT 구문 및 sql
			
			//? 바인딩
			
			pstmt.setString(1, genres);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "개의 장르가 입력되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (Exception e) {
				
			}
			try {
				if(con !=null){
					con.close();
				}
			} catch (Exception e) {
				
			}
		}//try-catch end
		
	}
}//JDBCEx1 end

