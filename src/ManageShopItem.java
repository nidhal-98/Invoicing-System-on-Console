
public class ManageShopItem {
	public static void ManageShopItem() {
		boolean menu = true;
		while(menu) {
			try {
				String[] subMenuOption = {"Add Items", "Delete Items", "Change Item Price","Report All Items", "Go Back"};
				Menu subMenu = new Menu(subMenuOption);
				subMenu.show();
				String select = Main.hold.next();
				switch (select) {
				case "1":
					boolean addItem = true;
					while(addItem) {
						Product newProduct = new Product();
						Main.newShop.productList.add(newProduct);
						System.out.print("Enter Item ID:  ");
						int itemIDEnterd = Main.hold.nextInt();
						boolean ID = true;
						for(int i =0; i<Main.newShop.productList.size(); i++) {
							if(Main.newShop.productList.get(i).itemID == itemIDEnterd) {
								System.out.println("This ID is already there!");
								ID = false;
								addItem = false;
							}
						}
						if(ID == true) {
							Main.newShop.productList.get((Main.newShop.productList.size()-1)).itemID = itemIDEnterd;
							System.out.print("Enter Item Name:  ");
							String nameEntered = Main.hold.next();
							boolean name = true;
							for(int i = 0; i < Main.newShop.productList.size(); i++) {
								if(Main.newShop.productList.get(i).itemName != null && Main.newShop.productList.get(i).itemName.equals(nameEntered)) {
								    System.out.println("This Name is already there!");
								    name = false;
								    addItem = false;
								    Main.newShop.productList.remove((Main.newShop.productList.size()-1));
								}
							}
							if(name == true) {
								Main.newShop.productList.get((Main.newShop.productList.size()-1)).itemName = nameEntered;
								System.out.print("Enter Item Price:  ");
								int itemPriceEnterd = Main.hold.nextInt();
								Main.newShop.productList.get((Main.newShop.productList.size()-1)).price = itemPriceEnterd;
								System.out.print("Enter Item Quantity:  ");
								int itemQuantityEnterd = Main.hold.nextInt();
								Main.newShop.productList.get((Main.newShop.productList.size()-1)).quantity = itemQuantityEnterd;
								System.out.print("Do you want to add other item?  ");
								String option = Main.hold.next();
								if(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("YES")){
								}
								else if(option.equalsIgnoreCase("N") || option.equalsIgnoreCase("NO")) {
									addItem = false;
								}
								else {
									System.out.println("Invalid Input\n");
									addItem = false;
								}
							}
							
						}
					}
					break;
					
				case "2":
					if(Main.newShop.productList.isEmpty()) {
						System.out.println("There is no Items\n");
						break;
					}
					System.out.printf("%20s %20s\n","Item Name", "Item ID");
					for(int i = 0; i< Main.newShop.productList.size(); i++) {
						System.out.printf("%20s %20s\n",(i+1) + ". " + Main.newShop.productList.get(i).itemName , Main.newShop.productList.get(i).itemID);
					}
					System.out.print("Enter Number of product to delete it:  ");
					int deleteItem = Main.hold.nextInt();
					if(deleteItem <= 0 || deleteItem > Main.newShop.productList.size()) {
						System.out.println("Invalid Input\n");
					}
					else {
						deleteItem = deleteItem - 1;
						Main.newShop.productList.remove(deleteItem);
						System.out.println("It has deleted successfully :)\n");
					}
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
					System.out.println("Invalid Input3\n");
					System.out.println(ex.getMessage());
					
				}
			
		}
	}

}
