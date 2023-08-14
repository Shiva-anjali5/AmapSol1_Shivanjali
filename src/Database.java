import static java.lang.System.out;

import java.sql.*;
import java.util.*;
public class Database {

	Connection connection = null;
	PreparedStatement ps=null;
	public static String uname;
    Scanner sc=new Scanner(System.in);
	public boolean get_con() {
		// TODO Auto-generated method stub
		
	    try {
	        // below two lines are used for connectivity.
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3307/taskmaster",
	            "root", "Shiva@anjali5");

	        // taskmaster is database
	        // root is name of database
	        // Shiva@anjali5 is password of database
	        if (connection != null && !connection.isClosed()) {
	            // run sql statements
	        	//System.out.print("Connected");
	        } else {
	            // handle closed connection path
	        }
	        
	  
	        return true;
	    }
	    catch (Exception exception) {
	        System.out.println(exception);
	    }
	    return false;
	}
    
	public void register() {
		// TODO Auto-generated method stub
		String uname,upass;
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("-----------------------Register----------------------");
		
		System.out.println("Enter your name:");
		uname=sc.nextLine();
		System.out.println("Enter your password:");
		upass=sc.nextLine();
		
		String query="insert into user(uname,pass)values(?,?);";
		try {
			ps=connection.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.executeUpdate();
			System.out.println("Registration Completed Please log in !!");
			login();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public void login() {
		// TODO Auto-generated method stub
		out.println("*******************************************************************************************************");
		
		System.out.println("--------------------------------------------Log In ----------------------------------------------\n");
		
		
		String upass;
		String duname,dupass;
		System.out.println("Enter your name:");
		uname=sc.nextLine();
		System.out.println("Enter your password:");
		upass=sc.nextLine();
		
		String query="select * from user where uname=?";
		try {
			ps=connection.prepareStatement(query);
			ps.setString(1,uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ResultSet result=ps.executeQuery();
			
			while(result.next())
			{
				String v1=result.getString(1);
				String v2=result.getString(2);
				System.out.println(v1+"  "+v2);
				if(uname.equals(v1)&&upass.equals(v2))
				{
					System.out.println("-----------------------------------------------------------------------------------------------------");
					System.out.println("Logged In Successfully");
					
					ToDoList todolist=new ToDoList();
				}
			}
		    
		   
		   
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
