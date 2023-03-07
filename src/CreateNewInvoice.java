import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNewInvoice {
	static ArrayList<Product> itemss = new ArrayList<>();

	public static void CreateNewInvoice1() {

		try {
			boolean header = true;
			while (header) {
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
					Main.newShop.invoiceList.get((Main.newShop.invoiceList.size() - 1)).fullName = fullNameEntrerd;
					System.out.println("Enter Phone Number:  ");
					int phoneNumberEntrerd = Main.hold.nextInt();
					Main.newShop.invoiceList
							.get((Main.newShop.invoiceList.size() - 1)).phoneNumber = phoneNumberEntrerd;
					System.out.println("Enter Email:  ");
					String emailEntrerd = Main.hold.next();
					Main.newShop.invoiceList.get((Main.newShop.invoiceList.size() - 1)).emailList.add(emailEntrerd);
					ArrayList<Product> item = new ArrayList<>();
					boolean itemLoop = true;
					while (itemLoop) {
						Product newProduct = new Product();
						item.add(newProduct);
						for (int i = 0; i < Main.newShop.productList.size(); i++) {
							System.out.println((i + 1) + ". " + Main.newShop.productList.get(i).getItemName());
						}
						boolean selectItem = true;
						while (selectItem) {

							System.out.println("Entre the Item:  ");
							int itemOption = Main.hold.nextInt();
							if (itemOption <= 0 || itemOption > Main.newShop.productList.size()) {
								System.out.println("Invalid Input\n");
							} else {
								int productIndex = itemOption - 1;
								item.get(item.size() - 1)
										.setItemName(Main.newShop.productList.get(productIndex).getItemName());
								System.out.println("The Quantity of " + item.get(item.size() - 1).getItemName() + ": "
										+ Main.newShop.productList.get(productIndex).getQuantity());
								System.out.println("Enter Quantity:  ");
								int quantity = Main.hold.nextInt();
								if (quantity > Main.newShop.productList.get(productIndex).getQuantity()) {
									System.out.println("Over Than Stock!");
									Main.newShop.invoiceList.remove(Main.newShop.invoiceList.size() - 1);
									selectItem = false;
								} else if (quantity == Main.newShop.productList.get(productIndex).getQuantity()) {
									System.out.println("Must Be in Stock At Least One!");
									Main.newShop.invoiceList.remove(Main.newShop.invoiceList.size() - 1);
									selectItem = false;
								} else {
									item.get(item.size() - 1).setQuantity(quantity);
									item.get(item.size() - 1)
											.setPrice(Main.newShop.productList.get(productIndex).getPrice());

									System.out.println("Do You Want to Add other Items?");
									String option = Main.hold.next();
									if (option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("YES")) {
										selectItem = false;
									} else if (option.equalsIgnoreCase("N") || option.equalsIgnoreCase("No")) {
										double total1 = 0;
										for (int i = 0; i < item.size(); i++) {
											total1 += item.get(i).getQuantity() * item.get(i).getPrice();
										}
										System.out.println("Total:  " + total1);
										System.out.println("Entre the Paid Amount: ");
										double paid = Main.hold.nextDouble();
										if (paid < total1) {
											System.out.println("Not Enough Balance :)");
											itemLoop = false;
											header = false;
											break;
										}
										int newQuantity = Main.newShop.productList.get(productIndex).getQuantity()
												- quantity;
										Main.newShop.productList.get(productIndex).setQuantity(newQuantity);
										double total = 0;
										System.out.println("--------------------------------------------------------");
										System.out
												.println("|                         INVOICE                        |");
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-30s | %-21s |", "Shop Name:",
												Main.newShop.shopName));
										System.out.println(String.format("| %-30s | %-21s |", "Shop Phone Number:",
												Shop.phoneNumberOwner));
										System.out.println(
												String.format("| %-30s | %-21s |", "Shop Fax Number:", Shop.faxOwner));
										System.out.println(
												String.format("| %-30s | %-21s |", "Shop Website:", Shop.website));
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-30s | %-21s |", "Invoice No.:",
												Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).number
														+ 1));
										System.out.println(String.format("| %-30s | %-21s |", "Customer Name:",
												Main.newShop.invoiceList
														.get(Main.newShop.invoiceList.size() - 1).fullName));
										System.out.println(
												String.format("| %-30s | %-21s |", "Date:", Main.newShop.invoiceList
														.get(Main.newShop.invoiceList.size() - 1).date));
										System.out.println(
												String.format("| %-30s | %-21s |", "Phone:", Main.newShop.invoiceList
														.get(Main.newShop.invoiceList.size() - 1).phoneNumber));
										System.out.println(
												String.format("| %-30s | %-21s |", "Email:", Main.newShop.invoiceList
														.get(Main.newShop.invoiceList.size() - 1).emailList));
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-25s | %-10s | %-13s |", "Item Name",
												"Price", "Quantity"));
										System.out.println("--------------------------------------------------------");
										for (int i = 0; i < item.size(); i++) {
											System.out.println(
													String.format("| %-25s | R.O%6.2f  %6d ", item.get(i).getItemName(),
															item.get(i).getPrice(), item.get(i).getQuantity()));
											total += item.get(i).getQuantity() * item.get(i).getPrice();
										}
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-30s | %-25s ", "Total:", total));
										System.out
												.println(String.format("| %-30s | %-25s ", "Balance:", paid - total1));
										System.out.println("--------------------------------------------------------");
										Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).total = total;
										itemss.addAll(item);
										try {
											FileWriter writer = new FileWriter("invoices.txt", true);
											writer.write("New Invoice\n");
											writer.write(formatDateTime + "\n");
											
											writer.write(
													"--------------------------------------------------------\n");
											writer.write(
													"|                         INVOICE                        |\n");
											writer.write(
													"--------------------------------------------------------\n");
											writer.write(String.format("| %-30s | %-21s |\n", "Shop Name:",
													Main.newShop.shopName));
											writer.write(String.format("| %-30s | %-21s |\n", "Shop Phone Number:",
													Shop.phoneNumberOwner));
											writer.write(String.format("| %-30s | %-21s |\n", "Shop Fax Number:",
													Shop.faxOwner));
											writer.write(
													String.format("| %-30s | %-21s |\n", "Shop Website:", Shop.website));
											writer.write(
													"--------------------------------------------------------\n");
											writer.write(String.format("| %-30s | %-21s |\n", "Invoice No.:",
															Main.newShop.invoiceList
																	.get(Main.newShop.invoiceList.size() - 1).number
																	+ 1));
											writer.write(String.format("| %-30s | %-21s |\n", "Customer Name:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).fullName));
											writer.write(
													String.format("| %-30s | %-21s |\n", "Date:", Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).date));
											writer.write(String.format("| %-30s | %-21s |\n", "Phone:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).phoneNumber));
											writer.write(String.format("| %-30s | %-21s |\n", "Email:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).emailList));
											writer.write(
													"--------------------------------------------------------\n");
											writer.write(String.format("| %-25s | %-10s | %-13s |\n", "Item Name",
													"Price", "Quantity"));
											writer.write(
													"--------------------------------------------------------\n");
											for (int i = 0; i < item.size(); i++) {
												writer.write(String.format("| %-25s | R.O%6.2f  %6d \n",
														item.get(i).getItemName(), item.get(i).getPrice(),
														item.get(i).getQuantity()));
											}
											writer.write(
													"--------------------------------------------------------\n");
											writer.write(String.format("| %-30s | %-25s \n", "Total:", total));
											writer.write(
													String.format("| %-30s | %-25s \n", "Balance:", paid - total1));
											writer.write(
													"--------------------------------------------------------\n");
											writer.close();
											System.out.println("Successfully wrote to the file.");
										} catch (IOException e) {
											System.out.println("An error occurred.");
											e.printStackTrace();
										}
										Serialize.invoice();
										itemLoop = false;
										header = false;
										break;
									} else {
										System.out.println("Invalid Input");
									}
								}
							}
							if (!itemLoop) {
								break;
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			Main.newShop.invoiceList.remove((Main.newShop.invoiceList.size() - 1));
			System.out.println("Invalid Input");
		}

	}
}