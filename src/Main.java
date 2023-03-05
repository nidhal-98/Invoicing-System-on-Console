import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Shop newShop = new Shop();
	static Scanner hold = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean menu = true;
		try {
			int i = 0;
			newShop.shopName = "Not Enterd";
			while(menu) {			
				String[] mainMenuOption = {"Shop Settings", "Manage Shop Items", "Create New Invoice", "Report", "Search", "Program Statistics", "Exit"};
				Menu mainMenu = new Menu(mainMenuOption);
				mainMenu.show();
				String select = hold.next();
				
				switch(select) {
				case"1":
					ShopSetting.shopSetting();
					break;
				case "2":
					ManageShopItem.ManageShopItem();
				case "3":
					i = i+1;
					System.out.print("Do you want you to add new invoice?  ");
					String option = hold.next();
					if(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("YES")) {
						Invoice newInvoice = new Invoice();
						newInvoice.number = i;
						newShop.invoiceList.add(newInvoice);
						System.out.println("Invoce is add :)\n");
					}
					else if(option.equalsIgnoreCase("N") || option.equalsIgnoreCase("NO")) {
					}
					else {
						System.out.println("Invalid Input\n");
					}
					break;
				case "7":
					menu = false;
					break;
				default:
					System.out.println("Invalid Input\n");
				}
			}
		}
		catch (Exception ex) {
			System.out.println("Invalid Input\n");
		}
	}

}
