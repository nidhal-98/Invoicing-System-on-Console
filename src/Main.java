import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner hold = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean menu = true;
		try {
			
			while(menu) {			
				String[] mainMenuOption = {"Shop Settings", "Manage Shop Items", "Create New Invoice", "Report", "Search", "Program Statistics", "Exit"};
				Menu mainMenu = new Menu(mainMenuOption);
				mainMenu.show();
				String select = hold.next();
				
				switch(select) {
				case"1":
					ShopSetting.shopSetting();
					break;
				case "7":
					menu = false;
					break;
				default:
					System.out.println("Invalid Input");
				}
			}
		}
		catch (NumberFormatException ex) {
			System.out.println("Invalid Input");
		}
	}

}
