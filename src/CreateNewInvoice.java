import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateNewInvoice {
	// static ArrayList<Product> itemss = new ArrayList<>();
	
	

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
					Main.newShop.invoiceList
							.get((Main.newShop.invoiceList.size() - 1)).number = Main.newShop.invoiceList.size();
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
					boolean itemLoop = true;
					while (itemLoop) {
						Product newProduct = new Product();
						newInvoice.item.add(newProduct);
						for(int i = 0; i < Main.newShop.productList.size(); i++) {
							if(Main.newShop.productList.get(i).getQuantity() == 0) {
								Main.newShop.productList.remove(i);
							}
						}
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
								int itemSerialNum = Main.newShop.productList.get(productIndex).getItemID();
								newInvoice.item.get(newInvoice.item.size() - 1)
										.setItemName(Main.newShop.productList.get(productIndex).getItemName());
								System.out.println("The Quantity of "
										+ newInvoice.item.get(newInvoice.item.size() - 1).getItemName() + ": "
										+ Main.newShop.productList.get(productIndex).getQuantity());
								System.out.println("Enter Quantity:  ");
								int quantity = Main.hold.nextInt();
								if (quantity > Main.newShop.productList.get(productIndex).getQuantity()) {
									System.out.println("Over Than Stock!");
									Main.newShop.invoiceList.remove(Main.newShop.invoiceList.size() - 1);
									selectItem = false;
								} /*else if (quantity == Main.newShop.productList.get(productIndex).getQuantity()) {
									System.out.println("Must Be in Stock At Least One!");
									Main.newShop.invoiceList.remove(Main.newShop.invoiceList.size() - 1);
									header = false;
									itemLoop = false;
									selectItem = false;
									break;
								}*/ else {
									newInvoice.item.get(newInvoice.item.size() - 1).setQuantity(quantity);
									newInvoice.item.get(newInvoice.item.size() - 1)
											.setPrice(Main.newShop.productList.get(productIndex).getPrice());
									int newQuantity = Main.newShop.productList.get(productIndex).getQuantity()
											- quantity;
									Main.newShop.productList.get(productIndex).setQuantity(newQuantity);
									
									if (quantity == Main.newShop.productList.get(productIndex).getQuantity()) {
										Main.newShop.productList.remove(productIndex);
									}
									
									
									/* --------------- New Quantity ------------- */
									
									String url = /* "jdbc:sqlserver://localhost:1433;" */ Main.urlEnterd + "databaseName=shopSystem;"
											+ "encrypt=true;" + "trustServerCertificate=true";

									String user = "sa";
									String pass = "root";

									Connection con = null;

									try {

										Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
										DriverManager.registerDriver(driver);

										con = DriverManager.getConnection(url, user, pass);

										String sql = "UPDATE Items\r\n"
												+ "SET item_Quantity =" + newQuantity + "\r\n"
												+ "WHERE item_ID =" + itemSerialNum + ";";
										PreparedStatement statement = con.prepareStatement(sql);
										statement.executeUpdate();

										// Close the PreparedStatement object
										statement.close();
										con.close();
									} catch (Exception ex) {
										System.err.println(ex);
									}
									
									/* --------------------------------------------------------------------- */
									
									System.out.println("Do You Want to Add other Items?");
									String option = Main.hold.next();
									if (option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("YES")) {
										selectItem = false;
									} else if (option.equalsIgnoreCase("N") || option.equalsIgnoreCase("No")) {
										double total1 = 0;
										for (int i = 0; i < newInvoice.item.size(); i++) {
											total1 += newInvoice.item.get(i).getQuantity()
													* newInvoice.item.get(i).getPrice();
										}
										System.out.println("Total:  " + total1);
										System.out.println("Entre the Paid Amount: ");
										double paid = Main.hold.nextDouble();
										Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).paid = paid;
										if (paid < total1) {
											System.out.println("Not Enough Balance :)");
											Main.newShop.invoiceList.remove((Main.newShop.invoiceList.size() - 1));
											itemLoop = false;
											header = false;
											break;
										};
										
										
										
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
												Main.newShop.invoiceList
														.get(Main.newShop.invoiceList.size() - 1).number));
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
										for (int i = 0; i < newInvoice.item.size(); i++) {
											System.out.println(String.format("| %-25s | R.O%6.2f  %6d ",
													newInvoice.item.get(i).getItemName(),
													newInvoice.item.get(i).getPrice(),
													newInvoice.item.get(i).getQuantity()));
											total += newInvoice.item.get(i).getQuantity()
													* newInvoice.item.get(i).getPrice();
										}
										System.out.println("--------------------------------------------------------");
										System.out.println(String.format("| %-30s | %-25s ", "Total:", total));
										Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).balance = paid
												- total1;
										System.out.println(String.format("| %-30s | %-25s ", "Paid:", paid));
										System.out
												.println(String.format("| %-30s | %-25s ", "Balance:", paid - total1));
										System.out.println("--------------------------------------------------------");
										Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).total = total;
										// itemss.addAll(newInvoice.item);
										try {
											FileWriter writer = new FileWriter("invoices.txt", true);
											writer.write("New Invoice\n");
											writer.write(formatDateTime + "\n");

											writer.write("--------------------------------------------------------\n");
											writer.write(
													"|                         INVOICE                        |\n");
											writer.write("--------------------------------------------------------\n");
											writer.write(String.format("| %-30s | %-21s |\n", "Shop Name:",
													Main.newShop.shopName));
											writer.write(String.format("| %-30s | %-21s |\n", "Shop Phone Number:",
													Shop.phoneNumberOwner));
											writer.write(String.format("| %-30s | %-21s |\n", "Shop Fax Number:",
													Shop.faxOwner));
											writer.write(String.format("| %-30s | %-21s |\n", "Shop Website:",
													Shop.website));
											writer.write("--------------------------------------------------------\n");
											writer.write(String.format("| %-30s | %-21s |\n", "Invoice No.:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).number));
											writer.write(String.format("| %-30s | %-21s |\n", "Customer Name:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).fullName));
											writer.write(String.format("| %-30s | %-21s |\n", "Date:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).date));
											writer.write(String.format("| %-30s | %-21s |\n", "Phone:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).phoneNumber));
											writer.write(String.format("| %-30s | %-21s |\n", "Email:",
													Main.newShop.invoiceList
															.get(Main.newShop.invoiceList.size() - 1).emailList));
											writer.write("--------------------------------------------------------\n");
											writer.write(String.format("| %-25s | %-10s | %-13s |\n", "Item Name",
													"Price", "Quantity"));
											writer.write("--------------------------------------------------------\n");
											for (int i = 0; i < newInvoice.item.size(); i++) {
												writer.write(String.format("| %-25s | R.O%6.2f  %6d \n",
														newInvoice.item.get(i).getItemName(),
														newInvoice.item.get(i).getPrice(),
														newInvoice.item.get(i).getQuantity()));
											}
											writer.write("--------------------------------------------------------\n");
											writer.write(String.format("| %-30s | %-25s \n", "Total:", total));
											writer.write(String.format("| %-30s | %-25s \n", "Paid:", paid));
											writer.write(
													String.format("| %-30s | %-25s \n", "Balance:", paid - total1));
											writer.write("--------------------------------------------------------\n");
											writer.write(
													"................................................................................................................\n");
											writer.close();
											System.out.println("Successfully wrote to the file.");
										} catch (IOException e) {
											System.out.println("An error occurred.");
											e.printStackTrace();
										}
										try {
											FileWriter writer = new FileWriter("invoicesLoad.txt", true);
											writer.write("ShopName: " + Main.newShop.shopName + " ");
											writer.write("ShopPhoneNumber: " + Shop.phoneNumberOwner + " ");
											writer.write("ShopFaxNumber: " + Shop.faxOwner + " ");
											writer.write("ShopWebsite: " + Shop.website + " ");
											writer.write("InvoiceNo: " + Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).number + " ");
											writer.write("CustomerName: " + Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).fullName + " ");
											writer.write("Date: " + Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).date + " ");
											writer.write("Phone: " +Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).phoneNumber + " ");
											writer.write("Email: "+Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).emailList + " ");
											for (int i = 0; i < newInvoice.item.size(); i++) {
												writer.write("ItemName: " + newInvoice.item.get(i).getItemName() + " ");
												writer.write("Price: " + newInvoice.item.get(i).getPrice() + " ");
												writer.write("Quantity: " + newInvoice.item.get(i).getQuantity() + " ");	
											}
											writer.write("Total: " + total + " ");
											writer.write("Paid: " + paid + " ");
											writer.write("Balance: " + (paid-total) + "\n");
											writer.close();
											System.out.println("Successfully wrote to the file.");
										} catch (IOException e) {
											System.out.println("An error occurred.");
											e.printStackTrace();
										}
										Serialize.invoice();
										JDBC1.invoices();
										itemLoop = false;
										header = false;
										break;

									} else {
										System.out.println("Invalid Input");
										break;
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