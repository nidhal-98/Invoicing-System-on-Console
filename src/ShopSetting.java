
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
					if (Main.newShop.productList.isEmpty()) {
						System.out.println("There is no Items");
						break;
					} 
					else if(Main.newShop.invoiceList.isEmpty()) {
						System.out.println("Thhere is no Invoices");
					}
					else {
						System.out.println("Items: ");
						System.out.println(
								"..............................................................................................................");
						System.out.printf("%20s %20s %20s %20s %20s\n", "Item ID", "Item Name", "Price", "Quantity",
								"QTY.");
						for (int i = 0; i < Main.newShop.productList.size(); i++) {
							System.out.printf("%20s %20s %20s %20s %20s\n", Main.newShop.productList.get(i).getItemID(),
									Main.newShop.productList.get(i).getItemName(),
									Main.newShop.productList.get(i).getPrice() + " R.O",
									Main.newShop.productList.get(i).getQuantity(), ((Main.newShop.productList.get(i).getPrice())
											* (Main.newShop.productList.get(i).getQuantity()) + " R.O"));
							System.out.println(
									"--------------------------------------------------------------------------------------------------------------");
						}
						System.out.println(
								"..............................................................................................................");
						System.out.println("Invoices: ");
						System.out.println(
								"..............................................................................................................");
						System.out.printf("%20s %20s %20s %20s %20s %20s %20s\n", "Invoice Number", "Date", "Name", "Phone",
								"Total", "Paid", "Balance");
						for (int i = 0; i < Main.newShop.invoiceList.size(); i++) {
							System.out.printf("%20s %20s %20s %20s %20s %20s %20s\n", Main.newShop.invoiceList.get(i).number,
									Main.newShop.invoiceList.get(i).date,
									Main.newShop.invoiceList.get(i).fullName,
									Main.newShop.invoiceList.get(i).phoneNumber,
									Main.newShop.invoiceList.get(i).total,
									Main.newShop.invoiceList.get(i).paid,
									Main.newShop.invoiceList.get(i).balance);
							System.out.println(
									"--------------------------------------------------------------------------------------------------------------");
						}
						System.out.println(
								"..............................................................................................................");

					}

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
