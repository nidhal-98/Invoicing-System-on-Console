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
								System.out.println("The Quantity of " + item.get(itemOption).getItemName() + ": " + Main.newShop.productList.get(itemOption).getQuantity());
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
									item.get(item.size()-1).setPrice(Main.newShop.productList.get(itemOption).getPrice());
									System.out.println("Do You Want to Add other Items?");
									String option = Main.hold.next();
									if (option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("YES")) {
										selectItem = false;
									}
									else if (option.equalsIgnoreCase("N") || option.equalsIgnoreCase("No")) {
										double total = 0;
										System.out.println("--------------------------------------------------------");
										System.out.println("|                         INVOICE                        |");
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-30s | %-30s |", "Shop Name:", Main.newShop.shopName));
										System.out.println(String.format("| %-30s | %-30s |", "Shop Phone Number:", Shop.phoneNumberOwner));
										System.out.println(String.format("| %-30s | %-30s |", "Shop Fax Number:", Shop.faxOwner));
										System.out.println(String.format("| %-30s | %-30s |", "Shop Website:", Shop.website));
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-30s | %-30s |", "Invoice No.:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).number+1));
										System.out.println(String.format("| %-30s | %-30s |", "Customer Name:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).fullName));
										System.out.println(String.format("| %-30s | %-30s |", "Date:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).date));
										System.out.println(String.format("| %-30s | %-30s |", "Website:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).emailList));
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-25s | %-10s | %-12s |", "Item Name", "Price", "Quantity"));
										System.out.println("--------------------------------------------------------");
										for (Product i : item) {
										    System.out.println(String.format("| %-25s | $%9.2f | %12d |", i.getItemName(), i.getPrice(), i.getQuantity()));
										    total += i.getQuantity() * i.getPrice();
										}
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-30s | %-30s |", "Total:", total));
										System.out.println("--------------------------------------------------------");
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
			System.out.println("Invalid Input");
			System.out.println(ex.getMessage());
		}

	}

}
