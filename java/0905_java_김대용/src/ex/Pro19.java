package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import util.ConnectionUtil;

public class Pro19 {

	public static void main(String[] args) {
		
		//커넥션 및 스테이트먼트 객체 선언 및 초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		//SELECT구문에 필요한 ResultSet 선언 및 초기화
		ResultSet rs = null;
		
		String sql = "SELECT no,name,director,release_date,genre FROM movies";
		
		try {
			//-----------------SELECT 구문 시작-----------//
			
			con = ConnectionUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				String movie = "번호: " +rs.getInt("no") + "/  이름 : " + rs.getString("name");
				
				System.out.println(movie);
			}

			//---------- DELETE 작업 시작 -----------------------------//
			//유저에게 movies table의 삭제할 번호를 입력받음
			
			System.out.println("삭제할 영화번호를 입력하세요.");
			
			Scanner scan = new Scanner(System.in);
			
			int num = scan.nextInt();
			
			String sql2 = "DELETE movies WHERE no = " + num;

			
			stmt = con.createStatement();
			
			
			int result = stmt.executeUpdate(sql2);
			
			// 입력받은 num과 movies table의 no를 비교하여 같으면 DELETE 구문 수행
			// 다르면 "삭제되지 않았습니다" 출력
			
				if(result != 0){
					System.out.println(result + "개의 영화가 잘 삭제되었습니다.");
					
					pstmt.close();
					rs.close();
					
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()){
						
						String movie = "번호: " +rs.getInt("no") + "/  이름 : " + rs.getString("name") ;
							   movie += " / 감독: "+ rs.getString("director")+"/ 개봉일 :"+rs.getDate("release_date")+"/ 장르번호:"+rs.getInt("genre") ;
						System.out.println(movie);
					}
				}
				else
					System.out.println("삭제가 되지 않았습니다.");

			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {if(rs != null){rs.close();	}} catch (Exception e) {}
			try {if(pstmt != null){	pstmt.close();	}} catch (Exception e) {}
			try {if(con != null){	con.close();}} catch (Exception e) {}
		}//try-catch end
		
	}//main() end
	
}//Pro19 end
