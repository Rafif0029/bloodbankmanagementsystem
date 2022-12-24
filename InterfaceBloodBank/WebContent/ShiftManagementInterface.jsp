<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Bank</title>
<style>
  /* Define your styles here */
  body {
    font-family: 'Roboto', sans-serif;
    background: linear-gradient(to right, #f06d06, #e82c0c);
  }
  h1 {
    font-size: 24px;
    color: #fff;
    text-align: center;
  }
  form {
    width: 500px;
    margin: 0 auto;
  }
  label {
    display: block;
    margin-bottom: 10px;
    font-size: 18px;
  }
  input[type="text"] {
    width: 100%;
    height: 40px;
    padding: 0 10px;
    font-size: 18px;
  }
  button {
    display: block;
    margin: 20px auto;
    width: 200px;
    height: 40px;
    font-size: 18px;
    border: none;
    background-color: #000;
    color: #fff;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    transition: all 0.5s;
  }
  button:hover {
    cursor: pointer;
    background-color: #fff;
    color: #000;
  }
</style>
</head>
<body>
<form action="ShiftManagementResponse.jsp">
<h1>Shift Employee</h1>
  <label>Do You Want to Shift Employee Timings?</label>
  <input name="shift" type="Text"></input>
  <button type="submit">Shift</button>
	
	
</form>

</body>
</html>
