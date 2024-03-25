package view;


import java.util.List;
import java.util.Scanner;
import controller.AuthController;
import controller.CropController;
import controller.MeetingController;
import controller.QueryController;
import controller.UserController;
import dao.UserQueryImpl;
import model.Crop;
import model.Meeting;
import model.User;
import model.UserQuery;


public class Main {
	
	public static Scanner sc=new Scanner(System.in);
	public static String username = null;
	public static String password = null;
	
	public static void printTitle1(String title) {
		System.out.println("***************************************************************************");
		System.out.println("\n         "+title+"         \n");
		System.out.println("***************************************************************************");
	}
	public static void printTitle(String title) {
		
		System.out.println("\n************ "+title+" ************\n");
		
	}
	
	public static void printTitle2(String title) {
		
		System.out.println("\n****************************** "+title+" ******************************\n");
		
	}
	
//	Logout Method
	public void logout() {
		System.out.println("Logged out successfully!");
		System.out.println("Thank you for visiting!!");
		System.exit(0);
	}
	
//	Displays upcomings meetings table
	public void viewUpcomingMeetings() {
		Main.printTitle2("Upcoming Meetings");
		System.out.format("%-15s%-30s%-25s%-25s\n\n", "Meeting Id","Title","Date","Time");
		List<Meeting> list=new MeetingController().viewMeetings();
		for (Meeting meeting : list) {
			System.out.println(meeting);
		}
	}
	
//	Add new meeting record to the database
	public void AddMeeting() {
		printTitle("Add Meeting");
		System.out.println("Enter meeting id");
		Integer id=sc.nextInt();
		System.out.println("Enter meeting title");
		sc.nextLine();
		String title=sc.nextLine();
		System.out.println("Enter meeting date");
		String date=sc.next();
		System.out.println("Enter meeting time");
		sc.nextLine();
		String time=sc.nextLine();
		System.out.println(new MeetingController().addMeeting(id, title, date, time));
		
	}
	
//	Update existing meeting record from the database
	public void updateMeeting() {
		printTitle("Update Meeting");
		System.out.println("Enter meeting id");
		Integer id=sc.nextInt();
		System.out.println("Enter meeting title");
		sc.nextLine();
		String title=sc.nextLine();
		System.out.println("Enter meeting date");
		String date=sc.next();
		System.out.println("Enter meeting time");
		sc.nextLine();
		String time=sc.nextLine();
		System.out.println(new MeetingController().updateMeeting(id, title, date, time));
		
	}
	
//	Delete existing meeting record from the database
	public void deleteMeeting() {
		printTitle("Delete Meeting");
		System.out.println("Enter meeting id");
		Integer id=sc.nextInt();
		System.out.println(new MeetingController().deleteMeeting(id));
	}
	public void showCropDetails() {
		int cr; boolean continueFlag=true;
		do {
		printTitle2("Select Crop");
		List<Crop> crops=new CropController().viewCrops();
		int i=0;
		for(i=0;i<crops.size();i++) {
			System.out.print((i+1)+"."+crops.get(i).getName()+"  ");
		}
		System.out.println((i+1)+".Logout "+(i+2)+".Back ");
		cr=sc.nextInt();
		
		if(cr==crops.size()+1) new Main().logout();
		else if(cr==crops.size()+2) continueFlag=false;
		else if(cr<1 || cr>crops.size()+2) {
			System.out.println("Invalid Input! Please try again.");
		}
		else {
			System.out.println("Crop Name: "+crops.get(cr-1).getName());
			System.out.println("Description: "+crops.get(cr-1).getDescription());
		}
		}while(continueFlag);
	}
	
	
	
	public void viewUsers() {
		List<User> users =new UserController().viewUsers();
		printTitle("List Of Users");
		System.out.format("%-5s%-20s%-20s\n", "Sr.","Username","Password");
		for (int i = 0; i < users.size(); i++) {
			System.out.format("%-5s", i+1);
			System.out.println(users.get(i));
		}
	}
	public void addUser() {
		printTitle("Add User");
		System.out.println("Enter Username: ");
		sc.nextLine();
		String username1=sc.nextLine();
		System.out.println("Enter Password: ");
		String password1=sc.next();
		String result=new UserController().addUser(username1, password1);
		if(result.equals("success")) {
			System.out.println("User added successfully!");
		}
		else {
			System.out.println(result);
		}
	}
	public void updateUser() {
		printTitle("Update User Details");
		System.out.println("Enter Old Username: ");
		sc.nextLine();
		String oldUsername=sc.nextLine();
		System.out.println("Enter New Username: ");
		String NewUsername=sc.nextLine();
		System.out.println("Enter Password: ");
		String password2=sc.next();
		if(oldUsername.equals("Admin")) {
			System.out.println("Admin's Username can't be changed\nPlease try again.");
			return;
		}
		System.out.println(new UserController().updateUser(oldUsername, NewUsername, password2));
		if(oldUsername.equals(username)) {
			username=NewUsername;
		}
	}
	public void updateAdmin() {
		printTitle("Update Admin Details");
		System.out.println("Enter New Password: ");
		String password2=sc.next();
		System.out.println(new UserController().updateUser("Admin", "Admin", password2));
	}
	
	public void deleteUser() {
		printTitle("Delete User");
		System.out.println("Enter Username: ");
		sc.nextLine();
		String username2=sc.nextLine();
		System.out.println(new UserController().deleteUser(username2));
	}
	
	public void addCrop() {
		printTitle("Add Crop");
		sc.nextLine();
		System.out.print("Enter Crop Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Description (Press enter and type 'Quit' to submit your crop description paragraph):");
		String description="";
		String linetext="";
		do {
			description+=linetext;
		linetext=sc.nextLine();
		linetext+="\n";
		}while(!linetext.equals("Quit\n"));
		System.out.println(new CropController().addCrop(name, description));
	}
	
	public void updateCrop() {
		printTitle("Update Crop");
		sc.nextLine();
		System.out.print("Enter Crop Old Name: ");
		String oldName=sc.nextLine();
		System.out.print("Enter Crop New Name: ");
		String newName=sc.nextLine();
		System.out.println("Enter Description (Press enter and type 'Quit' to submit your crop description paragraph):");
		String description="";
		String linetext="";
		do {
			description+=linetext;
		linetext=sc.nextLine();
		linetext+="\n";
		}while(!linetext.equals("Quit\n"));
		System.out.println(new CropController().updateCrop(oldName, newName, description));
	}
	
	public void deletecrop() {
		printTitle("Delete Crop");
		sc.nextLine();
		System.out.print("Enter Crop Name: ");
		String name=sc.nextLine();
		System.out.println(new CropController().deleteCrop(name));
	}
	
	public void addQuery() {
		printTitle2("Query Section");
		sc.nextLine();
		System.out.print("Enter your username: ");
		String username1=sc.nextLine();
		if(!username1.equals(username)) {
			if(!username.equals("Admin")) {
				System.out.println("Invalid Username Please try again!");
				return;
			}
		}
		System.out.print("Enter your Phone No.: ");
		String phone=sc.nextLine();
		System.out.println("Enter Query (Press enter and type 'Quit' to submit your Query):");
		String query="";
		String linetext="";
		do {
			query+=linetext;
		linetext=sc.nextLine();
		linetext+="\n";
		}while(!linetext.equals("Quit\n"));
		System.out.println(new QueryController().addQuery(username1, phone, query));
	}
	
	public void displayUserQueries() {
		List<UserQuery> userQueries=new QueryController().viewQueries();
		printTitle2("User Queries");
		System.out.format("%-15s%-25s%-25s%-30s\n", "Ticket No.","Username","Phone","Query");
		for (UserQuery userQuery : userQueries) {
			System.out.format("%-15s%-25s%-25s%-30s\n", userQuery.getQueryId(),userQuery.getUsername(),userQuery.getPhone(),userQuery.getQuery().substring(0, 15)+"...");
		}
		System.out.println("\n****************");
		System.out.println("Enter ticket No to view full query:");
		int ticketNo=sc.nextInt();
		UserQuery query=new UserQueryImpl().getUserQueryById(ticketNo);
		if(query==null) {
			System.out.println("Invalid ticket number! Please try again.");
			return;
		}
		if(userQueries.contains(query)) {
			System.out.println("Ticket No.: "+query.getQueryId());
			System.out.println("Username: "+query.getUsername());
			System.out.println("User Contact No.: "+query.getPhone());
			System.out.println("User Query:");
			System.out.println(query.getQuery());
		}
		
	}
	public void deleteUserQuery() {
		System.out.print("Enter Query Ticket No.: ");
		int ticketNo=sc.nextInt();
		UserQuery query=new UserQueryImpl().getUserQueryById(ticketNo);
		if(query==null) {
			System.out.println("Invalid ticket number! Please try again.");
			return;
		}
		System.out.println(new QueryController().deleteQuery(ticketNo));
	}
public static void main(String[] args) {
	printTitle1("WELCOME TO AGRICULTURE MANAGEMENT SYSTEM");
	printTitle("MENU");
	System.out.println("1.SIGNUP  2.LOGIN  3.EXIT");
	String s1=sc.nextLine();
	char ch;
	if(s1.length()>1 || s1.length()<1) {
		ch='0';
	}
	else ch=s1.charAt(0);
	AuthController auth;
	do {
	switch (ch) {
	case '1':
		System.out.print("Enter Username: ");
		
		username=sc.nextLine();
		System.out.print("Enter Password: ");
		password=sc.nextLine();
		auth=new AuthController();
		if(auth.signup(username, password)) {
			System.out.println("Registration Successfull!");
			System.out.println("Welcome "+username);
			ch='4';
		}
		else {
			System.out.println("User with username "+username+" already exist!");
			System.out.println("Please try Login option\n");
			ch='0';
		}
		break;
	case '2':
		System.out.print("Enter Username: ");
	
		username=sc.nextLine();
		System.out.print("Enter Password: ");
		password=sc.nextLine();
		auth=new AuthController();
		if(auth.login(username, password)) {
			System.out.println("Login Successfull!");
			System.out.println("Welcome "+username);
			ch='4';
		}
		else {
			System.out.println("Invalid username or password!");
			System.out.println("Please try Login again\n");
			ch='0';
		}
		break;
	case '3':
		System.out.println("Thank you for visiting!!");
		System.exit(0);
		break;
	default:
		System.out.println("Invalid Input!\nPlease try again\n");
		ch='0';
	}
	if(ch=='0') {
		printTitle("MENU");
		System.out.println("1.SIGNUP  2.LOGIN  3.EXIT");
	
		String s2=sc.nextLine();
		if(s2.length()>1 || s2.length()<1) {
			ch='0';
		}
		else ch=s2.charAt(0);
	}
	}while(ch!='4');
	
	do {
	printTitle2("MENU");
	System.out.print("1.Upcoming meetings  2.Crops  3.Profile  4.Submit Query  5.Logout");
	if(new AuthController().isAdmin(username, password)) {
		System.out.println("  6.Admin Operations");
	}
	else {
		System.out.println();
	}

	ch=sc.next().charAt(0);
	
		switch (ch) {
		case '1':
			new Main().viewUpcomingMeetings();
			break;
		case '2':
			new Main().showCropDetails();
			break;
		case '3':
			char choice4;
			do {
			System.out.println("\nMENU:  1.View Profile Details  2.Edit Profile Details  3.Back");
			choice4=sc.next().charAt(0);
			switch (choice4) {
			case '1':
				printTitle("Profile Details");
				System.out.format("%-20s%-20s\n","Username","Password");
				User user=new UserController().getUserByUsername(username);
				System.out.format("%-20s%-20s\n",user.getUsername(),user.getPassword());
				break;
			case '2':
				if(username.equals("Admin")) new Main().updateAdmin();
				else
				new Main().updateUser();
				break;
			default:
				if(choice4!='3')
					System.out.println("Invalid Input! Please try again");
				break;
			}
			}while(choice4!='3');
			break;
		case '4':
			new Main().addQuery();
			break;
		case '5':
			new Main().logout();
			break;
		case '6':
			if(!username.equals("Admin")) {
				System.out.println("Invalid Input! Please try again");
				break;
			}
			printTitle2("Welcome to Admin Panel");
			
			char choice;
			do {
			printTitle("MENU");
			System.out.println("1.Manage Meetings  2.Manage Crops  3.Manage Users  4.User Queries  5.Logout  6.Back");
			choice=sc.next().charAt(0);
				switch (choice) {
				case '1':
					char choice2;
					do {
						System.out.println("\nMENU:  1.View Meetings  2.Add Meeting  3.Update Meeting  4.Delete Meeting  5.Back");
						choice2=sc.next().charAt(0);
						switch (choice2) {
						case '1':
							new Main().viewUpcomingMeetings();
							break;
						case '2':
							new Main().AddMeeting();
							break;
						case '3':
							new Main().updateMeeting();
							break;
						case '4':
							new Main().deleteMeeting();
							break;
						default:
							if(choice2!='5')
							System.out.println("Invalid Input! Please try again");
							break;
						}
					}while(choice2!='5');
					break;
				case '2':
					char choice3;
					do {
						System.out.println("\nMENU:  1.View Crops  2.Add Crop  3.Update Crop  4.Delete Crop  5.Back");
						choice3=sc.next().charAt(0);
						
						switch (choice3) {
						case '1':
							new Main().showCropDetails();
							break;
						case '2':
							new Main().addCrop();
							break;
						case '3':
							new Main().updateCrop();
							break;
						case '4':
							new Main().deletecrop();
							break;
						default:
							if(choice3!='5')
							System.out.println("Invalid Input! Please try again");
							break;
						}
						
					}while(choice3!='5');
					break;
				case '3':
					char choice1;
					do {
					System.out.println("\nMENU:  1.View Users  2.Add user  3.Update user  4.Delete user  5.Back");
					choice1=sc.next().charAt(0);
					switch (choice1) {
					case '1':
						new Main().viewUsers();
						break;
					case '2':
						new Main().addUser();
						break;
					case '3':
						new Main().updateUser();
						break;
					case '4':
						new Main().deleteUser();
						break;
					default:
						if(choice1!='5')
						System.out.println("Invalid Input! Please try again");
						break;
					}
					}while(choice1!='5');
					break;
				case '4':
					char choice5;
					do {
					System.out.println("\nMenu:  1.View User Queriers  2.Delete User Query  3.Logout  4.Back");
					choice5=sc.next().charAt(0);
						switch (choice5) {
						case '1':
							new Main().displayUserQueries();
							break;
						case '2':
							new Main().deleteUserQuery();
							break;
						case '3':
							new Main().logout();
							break;
						default:
							if(choice5!='4')
								System.out.println("Invalid Input! Please try again");
							break;
						}
					}while(choice5!='4');
					
					break;
				case '5':
					new Main().logout();
					break;
				default:
					if(choice!='6')
					System.out.println("Invalid Input! Please try again");
					break;
				}
			}while(choice!='6');
			break;
		default:
			System.out.println("Invalid Input! Please try again");
			break;
		}
	}while(true);
}
}
