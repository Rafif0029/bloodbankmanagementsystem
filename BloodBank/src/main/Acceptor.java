package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Acceptor {
		

	
	
	
	private boolean checkInventory(String bloodType) {
		if(bloodType.equals("A+") || bloodType.equals("A-") || bloodType.equals("AB+") || bloodType.equals("AB-") ||
				bloodType.equals("B+") || bloodType.equals("B-") || bloodType.equals("O-") || bloodType.equals("O+")) {
			return true;
		}
		return false;
	}
	
	

public String acceptorRegistration(String name, String address,String bloodType, String phone,int quantity,String medicalCondition) {
if(checkBloodAvailibility(bloodType)>0 && checkBloodAvailibility(bloodType)>=quantity) {
if(!checkInventory(bloodType)) {
return "Plz enter the valid bloodtype";
}


try{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con =
	DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
	Statement stmt=con.createStatement();
	String rs="INSERT INTO `acceptor`(`acceptorName`,`acceptorAddress`,`bloodType`,`acceptorphone`,`acceptorMedicalCondotion`,`quantityInliters`) VALUES('"+name+"','"+address+"','"+bloodType+"','"+phone+"' ,'"+medicalCondition+"','"+quantity+"')";
	stmt.executeUpdate(rs,Statement.RETURN_GENERATED_KEYS);
	
	ResultSet generatedkeys= stmt.getGeneratedKeys();
	updateInventroy(bloodType,quantity);
	int inventoryid = getInventoryID(bloodType);
	if(generatedkeys.next()) {
		int donorId = generatedkeys.getInt(1);
		
		updateAcceptorAndDonor(donorId,inventoryid,quantity);
	}
	
	
	
	 return "acceptor Registered and blood is available";
	} catch(Exception e)
	{
	System.out.println(e);
	}
}

else
	return bloodType+" not available";


return "err";

}

  private int checkBloodAvailibility(String bloodtype) {
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con =
		  DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
		  Statement stmt=con.createStatement();
		  ResultSet rs=stmt.executeQuery("select quantity FROM `inventory`"
		  		+ "where `bloodtype` = '"+bloodtype+"'");
		  rs.next();
		  return rs.getInt(1);
		  } 
		  catch(Exception e){
		  System.out.println(e);
		  }

		  return -1;
  }

private void updateAcceptorAndDonor(int acceptor, int inventoryid,int quantity) {
try{

Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
Statement stmt=con.createStatement();
String rs="insert into inventoryandacceptor(accptorid,inventoryid,quantity) values('"+acceptor+"','"+inventoryid+"','"+quantity+"')";
stmt.executeUpdate(rs);

} catch(Exception e)
{
System.out.println(e);
}
}

private void updateInventroy(String bloodType,int quantity) {
try{

Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
Statement stmt=con.createStatement();
String rs="update inventory set quantity=quantity-'"+quantity+"' where bloodType = '"+bloodType+"' ";
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


	
}