import static java.lang.System.out;

import java.util.Scanner;

 
public class Main {
    public static void main(String arg[])
    {
    	Database db=new Database();
		db.get_con();
		if(db.get_con()==true)
		{
			//out.println("Database Connected");
		}
		else
			out.println("not connected");
		try (Scanner input = new Scanner(System.in)) {
			int choice=0;
			out.println("*******************************************************************************************************");
			out.println("-------------------------------Welcome To Taskmaster -------------------------------------------------");
			
			out.println("1: New user Registration ");
			out.println("2: Log in to your TaskMaster");
			out.println("Enter Your Choice");
			try{
				choice=input.nextInt();
			}catch(Exception e) {
				System.out.println("Please Enter Integer Only");
			}
			switch(choice)
			{
			case 1:
				db.register();
				break;
			case 2:
				db.login();
				break;
			default:
				out.println("Enter Correct Choice");
			}
		}
        
    } // function ends
} // class ends
