
public class ShopSetting {
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
					break;
					
				case "2":
					Shop.newShop();
					break;
					
				case "3":
					Invoice.setData();
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
