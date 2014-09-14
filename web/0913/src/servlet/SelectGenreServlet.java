package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectGenreServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			//드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jbdc:oracle:thin:@localhost:1521:xe";
			String user ="test";
			String password = "1111";
			
			//커넥션 얻기
			con = DriverManager.getConnection(url, user, password);
			
			//스테이트먼트 구문 얻기
			stmt = con.createStatement();
			
			//SQL 구문
			String sql = "SELECT no name FROM genres ORDER BY 1";
			//수행 후 결과 받기 
			rs = stmt.executeQuery(sql);
			
			//인코딩 설정
			resp.setCharacterEncoding("UTF-8");
			
			//문서의 컨텐트 형식 정의
			resp.setContentType("text/html; charset=UTF-8");
			
			//클라이언트로 보낼 응답 출력
			PrintWriter out = resp.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html lang='ko'>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>장르</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>장르 목록</h1>");
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>번호</th>");
			out.println("<th>장르명</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			//while문 돌려서 결과 출력
			
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getInt("no"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("name"));
				out.println("</td>");
				out.println("</tr>");
			}

			out.println("</tbody>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null){rs.close();}} catch (Exception e) {}
			try {if(stmt != null){stmt.close();}} catch (Exception e) {} 
			try {if(con != null){con.close();}} catch (Exception e) {}
		}
	}
}
