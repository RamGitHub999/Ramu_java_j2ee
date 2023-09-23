package jdbc_practice;

 import java.sql.*; // to get all 
public class JdbcConnection {

	public static void main(String[] args)throws SQLException {
	
		//register to oracle driver --step1
		//add jar for this name ojdbc jar from oracle	
		Driver d = new oracle.jdbc.driver.OracleDriver(); //database fully qualified name , 
		
		DriverManager.registerDriver(d); //register to driver manager 
		
		// creating connection to database --step2
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","orcl" );
		System.out.println("get connection successfully");
		
		//create statement for query creation --step3
		Statement st = c.createStatement();
		
		//create query and execute --step4
		String queryText="create table student (sid number primary key , sname varchar2(50 byte) , smarks number)";	
		st.executeUpdate(queryText);// executeUpdate method is used to non select clause quarries.
		System.out.println("table created successfully");
		
		// close the connection -- step5
		c.close();
		
		
		//above metioned are the basic steps for jdbc connections
	}

}
