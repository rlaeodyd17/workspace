<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is my first dynamic Webpage.!</h1>
	<h1>내가 만든 첫 동적 페이지(jsp) </h1>
	<%
		//Here is the code of JAVA !!!
		System.out.println("Hello Web Application Server World!!!");
		
		out.println("<h2>이건 html에 출력됩니다.</h2>");
	
		out.println(new Date());
	
	%>
	
	<h2>Hello Web Application World !!! </h2>
	<br>
	
	<h3>Congratulation Kevin Kim :)!!!! </h3>	
	
</body>
</html>