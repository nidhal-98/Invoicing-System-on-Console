import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNewInvoice {
	public static void CreateNewInvoice1() {
		ArrayList<Product> item = new ArrayList<>();
		try {
			boolean header = true;
			while(header) {
				if (Main.newShop.productList.isEmpty()) {
					System.out.println("There is no Items");
					break;
				} else {
					Invoice newInvoice = new Invoice();
					Main.newShop.invoiceList.add(newInvoice);
					LocalDateTime now = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String formatDateTime = now.format(formatter);
					Main.newShop.invoiceList.get((Main.newShop.invoiceList.size() - 1)).date = formatDateTime;
					System.out.println("Enter Full Name:  ");
					String fullNameEntrerd = Main.hold.next();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).fullName = fullNameEntrerd;
					System.out.println("Enter Phone Number:  ");
					int phoneNumberEntrerd = Main.hold.nextInt();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).phoneNumber = phoneNumberEntrerd;
					System.out.println("Enter Fax Number:  ");
					int faxNumberEntrerd = Main.hold.nextInt();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).phoneNumber = faxNumberEntrerd;
					System.out.println("Enter Email:  ");
					String emailEntrerd = Main.hold.next();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).emailList.add(emailEntrerd);
					
					boolean itemLoop = true;
					while(itemLoop) {
						Product newProduct = new Product();
						item.add(newProduct);
						for (int i = 0; i < Main.newShop.productList.size(); i++) {
							System.out.println((i + 1) + ". " + Main.newShop.productList.get(i).getItemName());
						}
						boolean selectItem = true;
						while(selectItem) {
							
							System.out.println("Entre the Item:  ");
							int itemOption = Main.hold.nextInt();
							if (itemOption <= 0 || itemOption > Main.newShop.productList.size()) {
								System.out.println("Invalid Input\n");
							}
							else {
								itemOption = itemOption -1;
								item.get(item.size()-1).setItemName(Main.newShop.productList.get(itemOption).getItemName());
								System.out.println("Enter Quantity:  ");
								int quantity = Main.hold.nextInt();
								if(quantity > Main.newShop.productList.get(itemOption).getQuantity()) {
									System.out.println("Over Than Stock!");
									Main.newShop.invoiceList.remove(Main.newShop.invoiceList.size()-1);
									selectItem = false;
								}
								else {
									item.get(item.size()-1).setQuantity(quantity);
									int newQuantity = Main.newShop.productList.get(itemOption).getQuantity()- quantity;
									Main.newShop.productList.get(itemOption).setQuantity(newQuantity);
									System.out.println("Do You Want to Add other Items?");
									String option = Main.hold.next();
									if (option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("YES")) {
										selectItem = false;
									}
									else if (option.equalsIgnoreCase("N") || option.equalsIgnoreCase("No")) {
										selectItem = false;
										itemLoop = false;
										header = false;
									}
									else {
										System.out.println("Invalid Input");
									}
									
								}
								
							}
						}
					}
				}
			}
		}
		catch (Exception ex) {
			System.out.println("Invalid Input\n");
		}

	}

}
