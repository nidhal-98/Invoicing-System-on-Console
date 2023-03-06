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
					System.out.print("There is no Items\n");
					break;
				} else {
					Invoice newInvoice = new Invoice();
					Main.newShop.invoiceList.add(newInvoice);
					LocalDateTime now = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String formatDateTime = now.format(formatter);
					Main.newShop.invoiceList.get((Main.newShop.invoiceList.size() - 1)).date = formatDateTime;
					System.out.print("Enter Full Name:  ");
					String fullNameEntrerd = Main.hold.next();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).fullName = fullNameEntrerd;
					System.out.print("Enter Phone Number:  ");
					int phoneNumberEntrerd = Main.hold.nextInt();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).phoneNumber = phoneNumberEntrerd;
					System.out.print("Enter Fax Number:  ");
					int faxNumberEntrerd = Main.hold.nextInt();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).phoneNumber = faxNumberEntrerd;
					System.out.print("Enter Email:  ");
					String emailEntrerd = Main.hold.next();
					Main.newShop.invoiceList.get((Main.newShop.productList.size() - 1)).emailList.add(emailEntrerd);
					
					boolean itemLoop = true;
					while(itemLoop) {
						Product newProduct = new Product();
						item.add(newProduct);
						for (int i = 0; i < Main.newShop.productList.size(); i++) {
							System.out.println((i + 1) + ". " + Main.newShop.productList.get(i).getItemName());
						}
						System.out.println("Entre the Item:  ");
						int itemOption = Main.hold.nextInt();
						if (itemOption <= 0 || itemOption > Main.newShop.productList.size()) {
							System.out.println("Invalid Input\n");
						}
						else {
							itemOption = itemOption -1;
							item.get(item.size()-1).setItemName(Main.newShop.productList.get(itemOption).getItemName());
							System.out.print("Enter Quantity:  ");
							int quantity = Main.hold.nextInt();
							item.get(item.size()-1).setQuantity(quantity);
							
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
