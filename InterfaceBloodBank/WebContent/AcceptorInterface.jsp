<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Bank</title>
<style>
 
  body {
    font-family: 'Roboto', sans-serif;
    
  }
  h1 {
    font-size: 24px;
   
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
<h1>Acceptor Registration</h1>
<form action="AcceptorResponse.jsp">
<label>Name</label>
	<input name="name" type="Text"></input>
	<br>
	<br>
	<label>Address</label>
	<input name="address" type="Text"></input>
	<br>
	<br>
	<label>Blood Type</label>
	<select name="bloodtype">
			<option value="A+">A+</option>
			<option value="A-">A-</option>
			<option value="B+">B+</option>
			<option value="B-">B-</option>
			<option value="O-">O-</option>
			<option value="O+">O+</option>
			<option value="AB+">AB+</option>
			<option value="AB-">AB-</option>
			
			
	</select>
	<br>
	<br>
	<label>Phone</label>
	<input name="phone" type="Text"></input>
	<br>
	<br>
	<label>Quantity(liters)</label>
	<input name="quantity" type="Text"></input>
	<br>
	<br>
	<label>Medical Condition</label>
	<input name="medicalcondition" type="Text"></input>
	<br>
	<br>
	<button type="submit">Register</button>
	
	
</form>
</body>
</html>