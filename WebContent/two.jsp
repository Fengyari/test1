<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

 
<%
	//request.setCharacterEncoding("utf-8");
	int name=Integer.parseInt(request.getParameter("name"));
	name=name+1;
	out.print("name==="+name);
%>