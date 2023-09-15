<%@page import="com.poscodx.guestbook.vo.GuestBookVo"%>
<%@page import="com.poscodx.guestbook.repository.GuestBookRepository"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    request.setCharacterEncoding("utf-8");
    	int no = Integer.parseInt(request.getParameter("id"));
    	String password = request.getParameter("password");
    	
    	new GuestBookRepository().deleteById(no, password);
    	
    	response.sendRedirect("/guestbook01/index.jsp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>