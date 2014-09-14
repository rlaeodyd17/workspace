package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import util.ConnectionUtil;

public class JDBCEx2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		
		String name = scan.nextLine();
		
		
		System.out.println("태어난 출생년도를 입력하세요");
		
		String year = scan.nextLine();
		
		System.out.println("태어난 출생 월을 입력하세요");

		String month = scan.nextLine();
		
		System.out.println("태어난 출생 일을 입력하세요");

		String day = scan.nextLine();
		
		String birth = year  +   "-" +   month + "-"  +  day;

		System.out.println("키를 입력하세요");
		
		int height = scan.nextInt();
		
		
		//커넥션 초기화
		Connection con = null; 
		
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		sql = "INSERT INTO students (no,name,birth_date,height) VALUES(students_seq.nextval, ?,?,?)";
		
		try{
			//실행할 구문
			con = ConnectionUtil.getConnection();
			System.out.println("연결완료!");
			
			pstmt = con.prepareStatement(sql); //프리페어드스테이트먼트: 생성할 때 sql 입력
			//stmt = con.createStatement(); 스테이트먼트 : excuteQuery시 sql 입력
			System.out.println("Statement객체생성");
			Date date = Date.valueOf(birth);
			
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setInt(3, height);
			
			System.out.println("바인딩완료");
			//query 문에 SELECT가 없으므로 table생성과 관계되지 않는다. 
			//따라서 INSERT를 하는 excuteUpdate메서드의 리턴값이 정수이므로 ResultSet객체 생성이 필요하지 않다.
			System.out.println("query실행중");
			int result = pstmt.executeUpdate();

			System.out.println(result+"명이 추가되었음");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null){
					pstmt.close();
				}
				
			} catch (Exception e) {
				}
			try {
				if(con != null){
					con.close();
				}
				
			} catch (Exception e) {
				}
		}//try~catch end
		
	}
}
