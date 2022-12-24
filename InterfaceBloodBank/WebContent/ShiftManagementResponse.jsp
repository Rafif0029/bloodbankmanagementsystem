<%
  String sh= request.getParameter("shift");
  
  if (sh==null) {
    response.sendRedirect("ShiftManagementInterface.jsp");
    return;
  }
%>
<%@page import="main.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Bank</title>
</head>
<body>
  <%
    String shift = request.getParameter("shift");
    
    ShiftManagement obj = new ShiftManagementProxy().getShiftManagement();
    String result = obj.doYouWanttoShiftEmployess(shift);
    out.println(result);
  %>
  
</body>
</html>
