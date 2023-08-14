import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShowTask {
	
	Database db=new Database();
	
	String tuname=db.uname;
	Statement stmt;
	public void pending() {
		// TODO Auto-generated method stub
		db.get_con();
		String tuname=db.uname;
		
		Statement stmt;
	
		
		
		
		System.out.println("---------------------------Pending Task --------------------------------------------");
	

	
		String sts="Completed";
		String query="select * from task where status!='"+sts+"'and user='"+tuname+"'";
		query+="order by due_date ASC,priority ASC";
		System.out.println("-------------------------------------------------------------------------------------");

		System.out.println("Id \t\t Task Name\t\t Status \t\t priority \t\t Duedate");
		try {
			 stmt=db.connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("id");
				String n=rs.getString("t_name");
				String s=rs.getString("status");
				int p=rs.getInt("priority");
				Date d=rs.getDate("due_date");
				
				System.out.println(id+"\t\t"+n+"\t\t"+s+"\t\t"+p+"\t\t"+d);
			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("---------------------------------------------------------------------------------------");

		
		System.out.println("----------------------------------------------------------------------------------------");

	}

	public void delete() {
		// TODO Auto-generated method stub
		db.get_con();
		String query="delete from task where status='completed'";
		try {
			stmt=db.connection.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Completed task deleted successfully !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
try {
			
			db.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void priority() {
	
	show();	
	}

	public void show() {
		
		db.get_con();
		String query="select * from task where user='"+tuname+"'";
		query+="order by due_date ASC,priority ASC";
		System.out.println("-----------------------------------------------------------------------");

		System.out.println("Id \t\t Task Name\t\t Status \t\t priority \t\t Duedate");
		try {
			 stmt=db.connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("id");
				String n=rs.getString("t_name");
				String s=rs.getString("status");
				int p=rs.getInt("priority");
				Date d=rs.getDate("due_date");
				
				System.out.println(id+"\t\t"+n+"\t\t"+s+"\t\t"+p+"\t\t"+d);
			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------");
try {
			
			db.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void trem() {
		// TODO Auto-generated method stub
		db.get_con();
		String tuname=db.uname;
		LocalDate ld=LocalDate.now();//get Current date
		Statement stmt;
		System.out.println(""+ld);
		java.sql.Date sqlDate=java.sql.Date.valueOf(ld);
		System.out.println(""+sqlDate);
		String query="select * from task where due_date='"+sqlDate+"'and user='"+tuname+"'";
		query+="order by due_date DESC,priority ASC";
		
		
		System.out.println("---------------------------Remainder --------------------------------------------");
		System.out.println("Below task please Complete today itself");

		System.out.println("\nId \t\t Task Name\t\t Status \t\t priority \t\t Duedate");
		try {
		
			stmt=db.connection.prepareStatement(query);
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("id");
				String n=rs.getString("t_name");
				String s=rs.getString("status");
				int p=rs.getInt("priority");
				Date d=rs.getDate("due_date");
				
				System.out.println(id+"\t\t"+n+"\t\t"+s+"\t\t"+p+"\t\t"+d);
			
		} }catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			db.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}

	public void twrem() {
		db.get_con();
		String query="select * from task where due_date=DATE_ADD(CURDATE(),INTERVAL 1 DAY) and user='"+tuname+"'";
		query+="order by due_date ASC,priority ASC";
		System.out.println("---------------------------------------------------------------------------------------");

		System.out.println("Id \t\t Task Name\t\t Status \t priority \t\t Duedate");
		try {
			 stmt=db.connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("id");
				String n=rs.getString("t_name");
				String s=rs.getString("status");
				int p=rs.getInt("priority");
				Date d=rs.getDate("due_date");
				
				System.out.println(id+"  \t\t"+n+" \t\t\t\t"+s+"\t\t\t\t "+p+"\t\t\t\t"+d);
			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------------------------------------------------");
try {
			
			db.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
				
	}


	
}
