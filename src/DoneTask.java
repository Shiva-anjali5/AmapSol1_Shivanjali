import java.sql.*;
import java.util.Scanner;
public class DoneTask {
	{
Database db=new Database();
db.get_con();
String tuname=db.uname;
String query;
Statement stmt;
ShowTask s=new ShowTask();
s.show();
System.out.println("-----------------------------------------------------------------------");
System.out.println("Enter Task Id");
Scanner sc=new Scanner(System.in);
int i=sc.nextInt();
query="update task set status='completed' where id=? && user=?";
try {
	db.ps=db.connection.prepareStatement(query);
	db.ps.setInt(1,i);
	db.ps.setString(2,tuname);
	db.ps.executeUpdate();
	System.out.println("Status Changed !");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("only enter your id");
	e.printStackTrace();
}

	}

}
