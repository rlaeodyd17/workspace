package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import util.ConnectionUtil;

public class JDBCEx1 {
	
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
		
		Statement stmt = null;
		
		String sql = null;
		
		try{
			//실행할 구문
			con = ConnectionUtil.getConnection();
			System.out.println("연결완료!");
			
			stmt = con.createStatement();
			System.out.println("Statement객체생성");
			
			sql = "INSERT INTO students (no,name,birth_date,height) VALUES(students_seq.nextval,'" +  name +  "','" +  birth +  "','" +  height +  "')";
			
			System.out.println("query실행중");
			int result = stmt.executeUpdate(sql);

			System.out.println(result+"명이 추가되었음");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(stmt != null){
					stmt.close();
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
