
public class ShopSetting {
	static int loadCount =0;
	static int setNameCount =0;
	static int headerCount =0;
	public static void shopSetting() {
		
		boolean menu = true;
		while (menu) {
			try {

				String[] subMenuOption = { "Load Data", "Set Shop Name", "Set Invoice Header", "Go Back" };
				Menu subMenu = new Menu(subMenuOption);
				subMenu.show();
				String select = Main.hold.next();
				switch (select) {
				case "1":
					loadCount = loadCount +1;
					break;
					
				case "2":
					setNameCount = setNameCount +1;
					Shop.newShop();
					break;
					
				case "3":
					headerCount = headerCount +1;
					Shop.setData();
					break;
					
				case "4":
					menu = false;
					break;
					
				default:
					System.out.println("Invalid Input\n");
				}
			} catch (Exception ex) {
				System.out.println("Invalid Input\n");
			}

		}
	}
}
