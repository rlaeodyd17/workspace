package ex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import util.ConnectionUtil;

public class Pro20 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("===============영화입력프로그램=================");
		
		System.out.println("장르번호를 입력하세요.");
		
		int genre = scan.nextInt();
		scan.nextLine();
		
		System.out.println("영화이름을 입력해주세요 ^-^");
		
		String name = scan.nextLine();
		
		System.out.println("감독이름을 입력해주세요^-^");
		
		String director = scan.nextLine();
		
		System.out.println("아래와 같은 포맷으로 개봉일을 입력하세요.");
		System.out.println("예) 2012-12-31");
		
		//지정된 문자열을 입력값으로 설정
		
		
		String releaseDate = scan.nextLine();
		
//		System.out.println(releaseDate);
		
		String sql2 = "INSERT INTO movies (no,name,release_date,director,genre) VALUES(movie_seq.nextval,?,to_date(?,'YYYY-MM-DD'),?,?)";

		scan.close();
		try {
			//---------------장르번호 입력 ----------//
			
			con = ConnectionUtil.getConnection();
			
			pstmt = con.prepareStatement(sql2);
			
//			Date date = Date.valueOf(releaseDate);
			
			pstmt.setString(1, name);
			pstmt.setString(2, releaseDate);
			pstmt.setString(3, director);
			pstmt.setInt(4, genre);
			
			System.out.println(sql2);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(name+ "이 잘 등록되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {

			}try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				
			} try {
				if(con != null){
					con.close();
				}
				
			} catch (Exception e) {

			}
			
		}//try-catch end
		
	}//main() end

}//Pro20 end
