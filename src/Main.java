import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Shop newShop = new Shop();
	static Scanner hold = new Scanner(System.in);

	public static void main(String[] args) {
		boolean menu = true;
		try {
			newShop.shopName = "Not Enterd";
			while (menu) {
				String[] mainMenuOption = { "Shop Settings", "Manage Shop Items", "Create New Invoice", "Report - Statistics", "Report - All Invoices", 
						"Search", "Program Statistics", "Exit" };
				Menu mainMenu = new Menu(mainMenuOption);
				mainMenu.show();
				String select = hold.next();

				switch (select) {
				case "1":
					ShopSetting.shopSetting();
					break;
				case "2":
					ManageShopItem.ManageShopItem1();
					break;
				case "3":
					CreateNewInvoice.CreateNewInvoice1();
					break;
				case "4":
					Report.statistics();
					break;
				case "5":
					Report.allInvoices();
					break;
				case "7":
					menu = false;
					break;
				default:
					System.out.println("Invalid Input\n");
				}
			}
		} catch (Exception ex) {
			System.out.println("Invalid Input\n");
		}
	}

}
