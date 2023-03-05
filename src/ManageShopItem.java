
public class ManageShopItem {
	public static void ManageShopItem() {
		boolean menu = true;
		while(menu) {
			try {
				
				String[] mainMenuOption = {"Load Data", "Set Shop Name", "Set Invoice Header", "Go Back"};
				Menu mainMenu = new Menu(mainMenuOption);
				mainMenu.show();
				String select = Main.hold.next();
				switch (select) {
				case "1":
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				default:
					System.out.println("Invalid Input");
				}
			}
				catch (NumberFormatException ex) {
					System.out.println("Invalid Input");
				}
			
		}
	}

}
