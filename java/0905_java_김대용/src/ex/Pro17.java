package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConnectionUtil;

public class Pro17 {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
			
		String sql = "SELECT no,name FROM genres";
		
		try {
			//수행
			con = ConnectionUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String genres = "번호 : "+rs.getInt(1)+" / 장르명 : " +rs.getString("name");
				
				System.out.println(genres);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
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
			}try {
				if(con != null){
					con.close();
				}
			} catch (Exception e) {
			}
			
		}//try-catch end
		
	}//main() end
	
	
}//Pro17 end
