
public class ManageShopItem {
	public static void ManageShopItem() {
		boolean menu = true;
		while(menu) {
			try {
				String[] mainMenuOption = {"Add Items", "Delete Items", "Change Item Price","Report All Items", "Go Back"};
				Menu mainMenu = new Menu(mainMenuOption);
				mainMenu.show();
				String select = Main.hold.next();
				switch (select) {
				case "1":
					boolean addItem = true;
					while(addItem) {
						Product newProduct = new Product();
						Main.newShop.productList.add(newProduct);
						System.out.print("Enter Item ID:  ");
						int itemIDEnterd = Main.hold.nextInt();
						Main.newShop.productList.get((Main.newShop.productList.size()-1)).itemID = itemIDEnterd;
						
					}
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				default:
					System.out.println("Invalid Input\n");
				}
			}
				catch (Exception ex) {
					System.out.println("Invalid Input\n");
				}
			
		}
	}

}
