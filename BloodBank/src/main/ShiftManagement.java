package main;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ShiftManagement {
	
	private int manageStaffShifts() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =
					(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankmanagementsystem","root","");
		Statement stmt=(Statement) con.createStatement();
		String rs="UPDATE `shiftmanagement`\r\n" + 
				"SET \r\n" + 
				"`EmpName` = CASE WHEN `EmpName`  = 'Ahmed' THEN 'Ali' ELSE 'Ahmed' END";
		
		stmt.executeUpdate(rs);
		return 0;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public String doYouWanttoShiftEmployess(String shift) {
		if(shift.contains("yes") ||shift.contains("Yes")  ) {
			if(manageStaffShifts()==0)
			return "Staff timings have been shifted";
			else
				return "err";
		}
		
		return "Staff timings have not shifted";

		
	}
}
