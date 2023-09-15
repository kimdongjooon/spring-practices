<%@page import="com.poscodx.guestbook.vo.GuestBookVo"%>
<%@page import="com.poscodx.guestbook.repository.GuestBookRepository"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String Name = request.getParameter("name");
	String Password = request.getParameter("password");
	String Message = request.getParameter("message");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setName(Name);
	vo.setPassword(Password);
	vo.setContents(Message);
	
	new GuestBookRepository().insert(vo);
	
	response.sendRedirect("/guestbook01/index.jsp");
%>

