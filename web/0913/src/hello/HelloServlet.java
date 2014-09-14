package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		PrintWriter out = resp.getWriter();
		Date date = new Date();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet !! ^--^//");
		out.println("<br>");
		out.println("오늘 날짜는 "+ date + "입니다! ^^");
		out.println("<br>");
		out.println("첫번째 servlet 프로젝트가 완성되었네요! 축하합니다!! You Win :) ");
		out.println("</body>");
		out.println("</html>");
	}
}
