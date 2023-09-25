package jdbc_practice;

import java.sql.*;
import java.util.*;


public class ExampleForPreparedStatement {

	public static void main(String[] args) {
	
		/*
		 * programe is example of preparedstatement concept in jdbc this programe is
		 * used written with try and catch to handle the exception 
		 * Preparedstatement :are used to execute complex quaries and quries allowes parametarized we can
		 * pass multiple argument and multiple records at a time
		 * it is used to  execute parametraized query
		 */
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // to avoid exception here ClassNotFoundException or else we can use try catch blocks also
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","orcl" );
			String queryText="insert into SMAPLE values(?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(queryText); // here PreparedStatement --className  and prepareStatement --methodName
			Scanner sc=new Scanner(System.in); // Scanner will take the input from console 
			while(true) {
				System.out.println("enter name : ");
				String name=sc.next();// to get user entered value string type and store in string variable
				System.out.println("enter phoneno");
				int phoneno=sc.nextInt();
				System.out.println("enter city");
				String city=sc.next();
				//int sid=0;
				String refno =null;
			
				
			
				pst.setString(1, refno);
				//pst.setInt(1, sid1);
				pst.setString(2, name);
				pst.setInt(3, phoneno);
				pst.setString(4, city);
				
				pst.executeUpdate();
				System.out.println("data inserted successfully");
				System.out.println(" Do You want insert one more Record ?[Yes/No] :");
				String option = sc.next();
				if(option.equalsIgnoreCase("NO"))
				{
					break;
				}
				
				
				
			}
			
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
	}

}
