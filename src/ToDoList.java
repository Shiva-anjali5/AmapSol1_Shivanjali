import java.util.*;
import static java.lang.System.out;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
public class ToDoList {
	{
		Scanner sc=new Scanner(System.in);
		ShowTask st=new ShowTask();
		
		
		
		
		
		System.out.println("----------------------------------------------------Remainder -----------------------------------------------");
		System.out.println("Below task please Complete today itself");

			
		st.trem();
		System.out.println("------------------------------------------------------------------------------------");

		
	int c=0;
	do {
		out.println("------------------------------------------------------------------------------------------");
		
		out.println("Enter What you Want to do ");
		out.println("1. Add New Task"
				+"\n2. Mark as Done "
				+"\n3. List pending Task"
				+"\n4. Remove Completed Task"
				+"\n5. Check Priority of Pending Task Tasks"
				+"\n6. View All Task"
				+"\n 7. Remainder"
				+"\n 8. Exit from system");
		out.println("Please select number from 1 to 8");
		
		c=sc.nextInt();
		
		switch(c)
		{
		case 1:
			AddTask ta=new AddTask();
			break;
		case 2:
			DoneTask td=new DoneTask();
			break;
		case 3:
			st.pending();
			break;
			
		case 4:
			st.delete();
			break;
			
		case 5:
			
			st.priority();
			break;
		case 6:
			st.show();
			break;
		case 7:
			int rc;
			out.println("\n\nEnter choise");
			out.println("1. Todays Remaining Task"
					+"\n2. Tommarows Tasks"
					+"\n 3. All Remaining Task"
					
			);
			rc=sc.nextInt();
			switch(rc)
			{
			case 1:
				st.trem();
				break;
			case 2:
				st.twrem();//check tommarows
				break;
			case 3:
				st.show();
				break;
			default:
				System.out.println("please Enter Values Between 1 to 3 Only");
			}

		default:
			out.println("Please enter 1 to 8 only");
			
		}
		
	}while(c!=8);
	
	System.out.println("Thank You!!!");
	System.exit(0);
}
}
