package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import util.ConnectionUtil;

public class Pro16 {
	
	public static void main(String[] args) {
		
		System.out.println("삭제할 장르를 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
		
		String name = scan.nextLine();
		
		scan.close();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//수행
			con = ConnectionUtil.getConnection();
			String sql = "DELETE genres WHERE name = ?";
			
			pstmt = con.prepareStatement(sql);
			
			//바인딩 세팅
			pstmt.setString(1,name);
			
			System.out.println("바인딩세팅!");
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result +"개의 장르가 삭제 되었습니다.");
			
			
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

}
