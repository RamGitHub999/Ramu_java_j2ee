package jdbc_practice;
import java.sql.*; // to get all libraries
public class JdbcCrudOperations {

	public static void main(String[] args)throws SQLException, ClassNotFoundException {
		
		//instead of writing drivermanager class object --stpe1
		//we also write without this line to jvm autoload this driver 
		Class.forName("oracle.jdbc.driver.OracleDriver"); // to avoid exception here ClassNotFoundException or else we can use try catch blocks also
		
		// creating connection to database --step2
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","orcl" );
		System.out.println("get connection successfully");
		
		//create statement for query creation --step3
		Statement st = c.createStatement();
		
		//create query and execute --step4
		String queryText="insert into student values(9,'karthik',68)";	
		st.executeUpdate(queryText);// executeUpdate method is used to non select clause quarries.
		System.out.println("data inserted successfully");
		
		// close the connection -- step5
		c.close();
	}

}
