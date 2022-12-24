package main;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
public class Donor {
	
	
	
	private boolean checkHealthCondition(String condition) {
		if(condition.equals("No Disease")) {
			return true;
		}
		return false;
	}
	
	private boolean checkInventory(String bloodType) {
		if(bloodType.equals("A+") || bloodType.equals("A-") || bloodType.equals("AB+") || bloodType.equals("AB-") ||
				bloodType.equals("B+") || bloodType.equals("B-") || bloodType.equals("O-") || bloodType.equals("O+")) {
			return true;
		}
		return false;
	}



public String donorRegistration(String name, String address,String bloodType, String phone,int quantity,String medicalCondition) {

if(!checkInventory(bloodType)) {
return "Plz enter  valid bloodtype";
}

if(checkHealthCondition(medicalCondition)) {
try{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con =
	DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
	Statement stmt=con.createStatement();
	String rs="INSERT INTO `donor`(`donorName`,`donoraddress`,`donorbloodType`,`donorphone`,`donorHealthCondition`,`quantityInliters`) VALUES('"+name+"','"+address+"','"+bloodType+"','"+phone+"' ,'"+medicalCondition+"','"+quantity+"')";
	stmt.executeUpdate(rs,Statement.RETURN_GENERATED_KEYS);
	
	ResultSet generatedkeys= stmt.getGeneratedKeys();
	updateInventroy(bloodType,quantity);
	int inventoryid = getInventoryID(bloodType);
	if(generatedkeys.next()) {
		int donorId = generatedkeys.getInt(1);
		
		updateInventoryAndDonor(donorId,inventoryid,quantity);
	}
	
	
	
	 return "donor Registered";
	} catch(Exception e)
	{
	return "Plz enter correct data";
	}
}
else
return "Registration Canceled because of disease";




}

private void updateInventroy(String bloodType,int quantity) {
try{

Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
Statement stmt=con.createStatement();
String rs="update inventory set quantity=quantity+'"+quantity+"' where bloodType = '"+bloodType+"' ";
stmt.executeUpdate(rs);

} catch(Exception e)
{
System.out.println(e);
}
}

private int getInventoryID(String bloodType) {
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select bloodid FROM `inventory`"
		+ "where `bloodtype` = '"+bloodType+"'");
rs.next();
return rs.getInt(1);
} 
catch(Exception e){
System.out.println(e);
}

return -1;
}


private void updateInventoryAndDonor(int donorid, int inventoryid,int quantity) {
try{

Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
Statement stmt=con.createStatement();
String rs="insert into inventoryanddonor(donorid,inventoryid,quantity) values('"+donorid+"','"+inventoryid+"','"+quantity+"')";
stmt.executeUpdate(rs);

} catch(Exception e)
{
System.out.println(e);
}
}
}
