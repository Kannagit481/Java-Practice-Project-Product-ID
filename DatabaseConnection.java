import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static Connection con=null;
	public static Connection getMyConnection() {
		try{  
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		 
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce1","root","Root@sql123");  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return con;
		
		}

}


