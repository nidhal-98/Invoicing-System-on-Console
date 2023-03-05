import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.FileWriter;
import java.io.IOException;


public class ManageShopItem {
	public static void ManageShopItem() {
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formatDateTime = now.format(formatter);
		boolean menu = true;
		while (menu) {
			try {
				String[] subMenuOption = { "Add Items", "Delete Items", "Change Item Price", "Report All Items",
						"Go Back" };
				Menu subMenu = new Menu(subMenuOption);
				subMenu.show();
				String select = Main.hold.next();
				switch (select) {
				case "1":
					boolean addItem = true;
					while (addItem) {
						Product newProduct = new Product();
						Main.newShop.productList.add(newProduct);
						System.out.print("Enter Item ID:  ");
						int itemIDEnterd = Main.hold.nextInt();
						boolean ID = true;
						for (int i = 0; i < Main.newShop.productList.size(); i++) {
							if (Main.newShop.productList.get(i).itemID == itemIDEnterd) {
								System.out.println("This ID is already there!");
								ID = false;
								addItem = false;
							}
						}
						if (ID == true) {
							Main.newShop.productList.get((Main.newShop.productList.size() - 1)).itemID = itemIDEnterd;
							System.out.print("Enter Item Name:  ");
							String nameEntered = Main.hold.next();
							boolean name = true;
							for (int i = 0; i < Main.newShop.productList.size(); i++) {
								if (Main.newShop.productList.get(i).itemName != null
										&& Main.newShop.productList.get(i).itemName.equalsIgnoreCase(nameEntered)) {
									System.out.println("This Name is already there!");
									name = false;
									addItem = false;
									Main.newShop.productList.remove((Main.newShop.productList.size() - 1));
								}
							}
							if (name == true) {
								Main.newShop.productList
										.get((Main.newShop.productList.size() - 1)).itemName = nameEntered;
								System.out.print("Enter Item Price:  ");
								double itemPriceEnterd = Main.hold.nextDouble();
								Main.newShop.productList
										.get((Main.newShop.productList.size() - 1)).price = itemPriceEnterd;
								System.out.print("Enter Item Quantity:  ");
								int itemQuantityEnterd = Main.hold.nextInt();
								Main.newShop.productList
										.get((Main.newShop.productList.size() - 1)).quantity = itemQuantityEnterd;
								System.out.print("Do you want to add other item?  ");
								String option = Main.hold.next();
								if (option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("YES")) {
								} else if (option.equalsIgnoreCase("N") || option.equalsIgnoreCase("NO")) {
									try {
										FileWriter writer = new FileWriter("items.txt", true);
										writer.write(formatDateTime);
										writer.write(
												"\n..............................................................................................................\n");
										writer.write(String.format("%20s %20s %20s %20s %20s\n", "Item ID", "Item Name", "Price", "Quantity",
												"QTY."));
										for (int i = 0; i < Main.newShop.productList.size(); i++) {
											writer.write(String.format("%20s %20s %20s %20s %20s\n", Main.newShop.productList.get(i).itemID,
													Main.newShop.productList.get(i).itemName,
													Main.newShop.productList.get(i).price + " R.O",
													Main.newShop.productList.get(i).quantity, ((Main.newShop.productList.get(i).price)
															* (Main.newShop.productList.get(i).quantity) + " R.O")));
											writer.write(
													"\n--------------------------------------------------------------------------------------------------------------\n");
										}
										writer.close();
										System.out.println("Successfully wrote to the file.");
									} catch (IOException e) {
										System.out.println("An error occurred.");
										e.printStackTrace();
									}
									addItem = false;
								} else {
									System.out.println("Invalid Input\n");
									addItem = false;
								}
							}

						}
					}
					break;

				case "2":
					if (Main.newShop.productList.isEmpty()) {
						System.out.print("There is no Items\n");
						break;
					}
					System.out.printf("%20s %20s\n", "Item Name", "Item ID");
					for (int i = 0; i < Main.newShop.productList.size(); i++) {
						System.out.printf("%20s %20s\n", (i + 1) + ". " + Main.newShop.productList.get(i).itemName,
								Main.newShop.productList.get(i).itemID);
					}
					System.out.print("Enter Number of product to delete it:  ");
					int deleteItem = Main.hold.nextInt();
					if (deleteItem <= 0 || deleteItem > Main.newShop.productList.size()) {
						System.out.println("Invalid Input\n");
					} else {
						deleteItem = deleteItem - 1;
						Main.newShop.productList.remove(deleteItem);
						System.out.println("It has deleted successfully :)\n");
					}
					break;

				case "3":
					if (Main.newShop.productList.isEmpty()) {
						System.out.print("There is no Items\n");
						break;
					} else {
						for (int i = 0; i < Main.newShop.productList.size(); i++) {
							System.out.println((i + 1) + ". " + Main.newShop.productList.get(i).itemName);
						}
						System.out.print("Enter the number of item:  ");
						int rePriceOption = Main.hold.nextInt();
						if (rePriceOption <= 0 || rePriceOption > Main.newShop.productList.size()) {
							System.out.println("Invalid Input\n");
						} else {
							rePriceOption = rePriceOption - 1;
							System.out.print("Enter the price of "
									+ Main.newShop.productList.get(rePriceOption).itemName + ":  ");
							double rePrice = Main.hold.nextDouble();
							Main.newShop.productList.get(rePriceOption).price = rePrice;
							System.out.println("It has changed successfully :)\n");
						}
					}
					break;

				case "4":
					if (Main.newShop.productList.isEmpty()) {
						System.out.print("There is no Items\n");
						break;
					} else {
						System.out.println(
								"..............................................................................................................");
						System.out.printf("%20s %20s %20s %20s %20s\n", "Item ID", "Item Name", "Price", "Quantity",
								"QTY.");
						for (int i = 0; i < Main.newShop.productList.size(); i++) {
							System.out.printf("%20s %20s %20s %20s %20s\n", Main.newShop.productList.get(i).itemID,
									Main.newShop.productList.get(i).itemName,
									Main.newShop.productList.get(i).price + " R.O",
									Main.newShop.productList.get(i).quantity, ((Main.newShop.productList.get(i).price)
											* (Main.newShop.productList.get(i).quantity) + " R.O"));
							System.out.println(
									"--------------------------------------------------------------------------------------------------------------");
						}
						System.out.println(
								"..............................................................................................................");
					}
					break;

				case "5":
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
