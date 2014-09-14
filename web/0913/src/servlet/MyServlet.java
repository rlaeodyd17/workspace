package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		//서버의 콘솔에 출력 테스트
		System.out.println("test!!");
		
		//인코딩 설정
		resp.setCharacterEncoding("UTF-8");
		
		//문서의 컨텐트 타입 정의
		resp.setContentType("type/html; charset=UTF-8");
		
		//클라이언트로 보낼 응답 출력
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Hello World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>My first Servelt!!</h1>");
		out.println("<h2>내가 만든 첫번째 서블릿, 안녕^.~//</h2>");
		out.println("</body>");
		out.println("</html>");		
	}
}
