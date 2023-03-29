
public class Search {
	static void search1() {
		try {
			boolean header = true;
			while (header) {
				if (Main.newShop.invoiceList.isEmpty()) {
					System.out.println("There is no Invoices");
					header = false;
					break;
				}
				else {
					int x =0;
					System.out.println("Enter Number of Invoice: ");
					int invoiceNoEntered = Main.hold.nextInt();
					for(int i=0; i<Main.newShop.invoiceList.size(); i++) {
						if(Main.newShop.invoiceList.get(i).number == invoiceNoEntered) {
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
									Main.newShop.invoiceList.get(i).number
									));
							System.out.println(String.format("| %-30s | %-21s |", "Customer Name:",
									Main.newShop.invoiceList
									.get(i).fullName));
							System.out.println(
									String.format("| %-30s | %-21s |", "Date:", Main.newShop.invoiceList
											.get(i).date));
							System.out.println(
									String.format("| %-30s | %-21s |", "Phone:", Main.newShop.invoiceList
											.get(i).phoneNumber));
							System.out.println(
									String.format("| %-30s | %-21s |", "Email:", Main.newShop.invoiceList
											.get(i).emailList));
							System.out.println("--------------------------------------------------------");
							System.out.println(String.format("| %-25s | %-10s | %-13s |", "Item Name",
									"Price", "Quantity"));
							System.out.println("--------------------------------------------------------");
							for (Product j : Main.newShop.invoiceList.get(i).item) {
								System.out.println(String.format("| %-25s | R.O%6.2f  %6d ", j.getItemName(), j.getPrice(), j.getQuantity()));
							}
							System.out.println("--------------------------------------------------------");
							System.out.println(String.format("| %-30s | %-25s ", "Total:", Main.newShop.invoiceList.get(i).total));
							System.out.println(String.format("| %-30s | %-25s ", "Paid:", Main.newShop.invoiceList.get(i).paid));
							System.out
							.println(String.format("| %-30s | %-25s ", "Balance:", Main.newShop.invoiceList.get(i).balance));
							System.out.println("--------------------------------------------------------");
							x = x+1;
							header = false;
							break;
						}
					}
					if (x==0) {
						System.out.println("Not Found!");
						header = false;
						break;
					}
				}
			}


		} catch (Exception e) {
			System.out.println("Enter Number of Invice: ");
		}

	}

}