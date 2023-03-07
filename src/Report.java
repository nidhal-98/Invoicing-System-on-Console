
public class Report {
	static void statistics() {
		while(true) {
			if(Main.newShop.invoiceList.isEmpty()) {
				System.out.printf("%-20s%-20s%-20s\n", "No of Items", "No of Invoices", "Total Sales");
		        System.out.printf("%-20d%-20d%-20s\n", Main.newShop.productList.size(), Main.newShop.invoiceList.size(), "0");
				break;
			}
			else {
				System.out.printf("%-20s%-20s%-20s\n", "No of Items", "No of Invoices", "Total Sales");
				double total =0;
				for(Invoice i : Main.newShop.invoiceList) {
					total = total + i.total;
				}
		        System.out.printf("%-20d%-20d$%-20.2f\n", Main.newShop.productList.size(), Main.newShop.invoiceList.size(), total);
				break;
			}
		}
	}
	
	static void allInvoices() {
		while(true) {
			if(Main.newShop.invoiceList.size()==0) {
				System.out.println("No Inovices There :)");
				break;
			}
			else {
				for(int j =0; j<Main.newShop.invoiceList.size(); j++) {
					
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
									.get(j).fullName));
					System.out.println(
							String.format("| %-30s | %-21s |", "Date:", Main.newShop.invoiceList
									.get(j).date));
					System.out.println(
							String.format("| %-30s | %-21s |", "Phone:", Main.newShop.invoiceList
									.get(j).phoneNumber));
					System.out.println(
							String.format("| %-30s | %-21s |", "Email:", Main.newShop.invoiceList
									.get(j).emailList));
					System.out.println("--------------------------------------------------------");
					System.out.println(String.format("| %-25s | %-10s | %-13s |", "Item Name",
							"Price", "Quantity"));
					System.out.println("--------------------------------------------------------");
					for (Product i : Main.newShop.invoiceList.get(j).item) {
						System.out.println(String.format("| %-25s | R.O%6.2f  %6d ", i.getItemName(), i.getPrice(), i.getQuantity()));
					}
					System.out.println("--------------------------------------------------------");
					System.out.println(String.format("| %-30s | %-25s ", "Total:", Main.newShop.invoiceList.get(j).total));
					System.out.println(String.format("| %-30s | %-25s ", "Paid:", Main.newShop.invoiceList.get(j).paid));
					System.out
							.println(String.format("| %-30s | %-25s ", "Balance:", Main.newShop.invoiceList.get(j).balance));
					System.out.println("--------------------------------------------------------");
				}
				break;
			}
		}

	}

}
