import static java.lang.System.out;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AddTask {

	{
		Scanner sc=new Scanner(System.in);
	
	Database db=new Database();
	db.get_con();
	if(db.get_con()==true)
	{
		out.println("Database Connected");
	}
	else
		out.println("not connected");
	
	//accept task description from user
	String tuname=db.uname;
	System.out.println(tuname);
	String task_name;
	int t_prio;
	String udate;
	
	
	out.println("Enter task Name ");
	task_name=sc.nextLine();
	out.println("Enter Priority of task at that day");
	t_prio=sc.nextInt();
	System.out.println("Enter date yyyy-mm-dd");
	udate=sc.next();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date;
	try {
		date = sdf.parse(udate);
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		 String query="insert into task(t_name,due_date,priority,user)values(?,?,?,?)";
		 
		 try {
				db.ps=db.connection.prepareStatement(query);
				db.ps.setString(1,task_name);
				db.ps.setDate(2,sqlDate);
				db.ps.setInt(3,t_prio);
				db.ps.setString(4, tuname);
				db.ps.executeUpdate();
				
				System.out.println("Task Addedd Succesfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
	//add new task
	
	
	
	
		
}
}

