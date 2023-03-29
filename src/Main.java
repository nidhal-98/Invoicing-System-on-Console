import java.util.Scanner;

public class Main {
	static Shop newShop = new Shop();
	static Scanner hold = new Scanner(System.in);

	static int settingsCount = 0;
	static int manageCount = 0;
	static int newInvoiceCount = 0;
	static int reportStatisticsCount = 0;
	static int reportInvoicesCount = 0;
	static int searchCount = 0;
	static int statisticsCount = 0;
	static int deserializationCount = 0;
	static String urlEnterd;
	static String userName;
	static String passWord;

	public static void main(String[] args) {
		boolean menu = true;
		try {
			newShop.shopName = "Not Enterd";
			while (menu) {
				String[] mainMenuOption = { "Shop Settings", "Manage Shop Items", "Create New Invoice",
						"Report - Statistics", "Report - All Invoices", "Search", "Program Statistics",
						"Deserialization", "Exit" };
				Menu mainMenu = new Menu(mainMenuOption);
				System.out.println("Enter Url: ");
				String urlEntered1 = hold.next();
				urlEnterd = urlEntered1;

				System.out.println("Enter Username: ");
				String usernameEntered = hold.next();
				userName = usernameEntered;

				System.out.println("Enter Password: ");
				String passEntered = hold.next();
				passWord = passEntered;
				
				JDBC1.readItems();
				JDBC1.readInvoices();
				
				boolean loop = true;
				while (loop) {

					mainMenu.show();
					String select = hold.next();

					switch (select) {
					case "1":
						settingsCount = settingsCount + 1;
						ShopSetting.shopSetting();
						break;
					case "2":
						manageCount = manageCount + 1;
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
						searchCount = searchCount + 1;
						Search.search1();
						break;
					case "7":
						statisticsCount = statisticsCount + 1;
						Report.AppStatistics();
						break;
					case "8":
						deserializationCount = deserializationCount + 1;
						DeSerialize.main();
						break;
					case "9":
						System.out.println("Are you sure you want to exit? (Yes or No)");
						String exitOption = hold.next();
						if (exitOption.equalsIgnoreCase("Y") || exitOption.equalsIgnoreCase("YES")) {
							loop = false;
							menu = false;
							break;
						} else if (exitOption.equalsIgnoreCase("N") || exitOption.equalsIgnoreCase("NO")) {

						} else {
							System.out.println("Invalid Input\n");

						}
						break;
					default:
						System.out.println("Invalid Input \n");
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Invalid Input\n");
		}
	}

}
