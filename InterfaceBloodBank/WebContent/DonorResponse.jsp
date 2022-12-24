<%@page import="main.*"%>
<%
String a= request.getParameter("name");
String b= request.getParameter("address");
String c = request.getParameter("phone");
String d= request.getParameter("quantity");
  if (a == null || b == null || c==null|| d==null) {
    response.sendRedirect("DonorInterface.jsp");
    return;
  }
%>
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
          String name = request.getParameter("name");
          String phone = request.getParameter("phone");
          String address = request.getParameter("address");
          String medicalCondition = request.getParameter("medicalcondition");
          int quantity = Integer.parseInt(request.getParameter("quantity"));
          String bloodType = request.getParameter("bloodtype");
          
          Donor obj = new DonorProxy().getDonor();
          String result = obj.donorRegistration(name, address, bloodType, phone, quantity,medicalCondition);
          out.println(result);
        %>
</body>
</html>