package jdbc_practice;

import java.util.*;
import java.lang.*;
import java.sql.*;
import java.text.SimpleDateFormat;


public class DateStoreProcessInSqlUsingJDBC {
	
	/* here example programe of date store process by jdbc in spcific format 
	 * first read date from user in string format --step1
	 * create SimpleDateFormat instance with format like "dd-MM-yyyy" -- step2
	 * second convert string format date into java.util.Date format , SimpleDateFormat instace parse to  java.util.Date format --step3
	 * get getTime() from the  java.util.Date format instance and store in the long type variable --step4
	 * pass this long type of varible to the java.sql.Date instance and stored in one instance(object) -- step4
	 * the java.sql.Date object is passed to the date type insert column in the setDate() methode*/

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","orcl" );
			String queryText="insert into smaple(REFNO,NAME,PHONENO,CIT,DOB) values(?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(queryText);
			
			String refno=null;
			Scanner sc =new Scanner(System.in);
			System.out.println("enter the Name :");
			String sampleName = sc.nextLine();
			System.out.println("enter mobile number[5] :");
			String mno =sc.nextLine();
			
			System.out.println("enter city :");
			String cityname =sc.nextLine();
			System.out.println("enter dob : (dd-mm-yyy)");
			String dob=sc.next();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // this sample date instance 
			
			java.util.Date dob1 =sdf.parse(dob); // date is parse into the java.util.date instance
			
			long dob2 = dob1.getTime();
			java.sql.Date dob3 =new java.sql.Date(dob2);
			
			
			int mnumber = Integer.parseInt(mno);//prse string into integer
			
			pst.setString(1,refno); // here indexes are based on position parameters
			pst.setString(2, sampleName);
			pst.setInt(3, mnumber);
			pst.setString(4, cityname);
			pst.setDate(5, dob3);
			
			pst.executeUpdate();
			
			System.out.println("data inserted successfully");
			
			c.close();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int parseInt(String mno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
