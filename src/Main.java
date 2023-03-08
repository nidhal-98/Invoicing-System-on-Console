import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Shop newShop = new Shop();
	static Scanner hold = new Scanner(System.in);
	
	static int settingsCount =0;
	static int manageCount =0;
	static int newInvoiceCount =0;
	static int reportStatisticsCount =0;
	static int reportInvoicesCount =0;
	static int searchCount =0;
	static int statisticsCount =0;
	static int deserializationCount = 0;

	public static void main(String[] args) {
		boolean menu = true;
		try {
			newShop.shopName = "Not Enterd";
			while (menu) {
				String[] mainMenuOption = { "Shop Settings", "Manage Shop Items", "Create New Invoice", "Report - Statistics", "Report - All Invoices", 
						"Search", "Program Statistics", "Deserialization", "Exit" };
				Menu mainMenu = new Menu(mainMenuOption);
				mainMenu.show();
				String select = hold.next();

				switch (select) {
				case "1":
					settingsCount = settingsCount + 1;
					ShopSetting.shopSetting();
					break;
				case "2":
					manageCount = manageCount +1;
					ManageShopItem.ManageShopItem1();
					break;
				case "3":
					newInvoiceCount = newInvoiceCount + 1;
					CreateNewInvoice.CreateNewInvoice1();
					break;
				case "4":
					reportStatisticsCount = reportStatisticsCount + 1;
					Report.statistics();
					break;
				case "5":
					reportInvoicesCount = reportInvoicesCount + 1;
					Report.allInvoices();
					break;
				case "6":
					searchCount = searchCount +1;
					Search.search1();
					break;
				case "7":
					statisticsCount = statisticsCount +1;
					Report.AppStatistics();
					break;
				case "8":
					deserializationCount = deserializationCount +1;
					DeSerialize.main();
					break;
				case "9":
					System.out.println("Are you sure you want to exit? (Yes or No)");
					String exitOption = hold.next();
					if(exitOption.equalsIgnoreCase("Y") || exitOption.equalsIgnoreCase("YES")) {
						menu = false;
					}
					else if (exitOption.equalsIgnoreCase("N") || exitOption.equalsIgnoreCase("NO")) {
						
					}
					else {
						System.out.println("Invalid Input\n");
						
					}
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
