package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import util.ConnectionUtil;

public class Pro15 {
	
	public static void main(String[] args) {
		
		System.out.println("변경할 장르명 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
		
		String name1 = scan.nextLine();
		
		System.out.println("변경될 장르명을 입력하세요.");
		
		String name2 = scan.nextLine();
		
		scan.close();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//수행
			con = ConnectionUtil.getConnection();
			String sql = "UPDATE genres SET name = ? WHERE name = ?";
			System.out.println(sql);
			
			pstmt = con.prepareStatement(sql);
			
			//바인딩 세팅
			pstmt.setString(1,name2);
			pstmt.setString(2,name1);
			
			System.out.println("바인딩세팅!");
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result +"개의 장르명이 잘 변경되었습니다.");
			
			
		} catch (Exception e) {
		} finally {
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (Exception e) {
				
			}
			try{
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				
			}
		}//try-catch end
		
	}//main() end
	

}//JDBCEx2 end
