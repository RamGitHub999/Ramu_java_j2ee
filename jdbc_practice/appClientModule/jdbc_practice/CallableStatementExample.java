package jdbc_practice;

import java.util.*;
import java.sql.*;

public class CallableStatementExample {

	public static void main(String[] args) {
		
		/*callable statement example
		 * callable statement is used for procedure calling from the db*/
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // to avoid exception here ClassNotFoundException or else we can use try catch blocks also
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","orcl" );
			CallableStatement cst=c.prepareCall("{call getStudentDetails(?,?)}");// this how we call procedure in jdbc here getStudentDetails is procedure name we created in db
			
			cst.setInt(1, 12); // static values 
			cst.registerOutParameter(2, Types.VARCHAR);//register for output pramater
			cst.execute();//execute procedure
		
			String studentName =cst.getString(2);//get outparameter based on type and index
			
			System.out.println("student name : "+studentName);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
