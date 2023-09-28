package jdbc_practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class DbFunctionsCallingUsingCallableStatements 
{
	public static void main(String[] args) {
	/* here sample programe for how we are calling the DB Functions in the java programe by using jdbc
	 * function are created in db
	 * function have only IN parameters 
	 * ---sample eaxample sql function--
	 * create or replace function avgmarks(s1 IN number ,s2 IN number) return number
	 as 
	 marks1 number;marks2 number;
	 begin
	 select smarks into marks1 from student where sid=s1;
	 select smarks into marks2 from student where sid=s2;
	 return (marks1+marks2)/2;
	 end avgmarks;
	 /
	 commit;
	 ---execution of function---
	 select avgmarks(12,14) as avaregeMarks from dual; here passed values are the static values based on the db values*/
	
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // to avoid exception here ClassNotFoundException or else we can use try catch blocks also
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","orcl" );
		CallableStatement cst=c.prepareCall("{?=call avgmarks(?,?)}");// this how we call function in jdbc here getStudentDetails is function name we created in db
		//in  above line question marks symbols are called as position parameters
		cst.setInt(2, 12); // static values 
		cst.setInt(3, 13);
		cst.registerOutParameter(1, Types.FLOAT); // return type based on the position parameter and functionaly return type
		cst.execute();
		float avg =cst.getFloat(1);
		System.out.println("avarage marks of 2 students : "+avg);
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
