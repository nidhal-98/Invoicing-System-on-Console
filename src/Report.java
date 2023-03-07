
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
		double total = 0;
		System.out.println("|                         INVOICE                        |");
		System.out.println(String.format(" %-30s  %-21s ", "Shop Name:", Main.newShop.shopName));
		System.out.println(String.format(" %-30s  %-21s ", "Shop Phone Number:", Shop.phoneNumberOwner));
		System.out.println(String.format(" %-30s  %-21s ", "Shop Fax Number:", Shop.faxOwner));
		System.out.println(String.format(" %-30s  %-21s ", "Shop Website:", Shop.website));
		System.out.println(String.format(" %-30s  %-21s ", "Invoice No.:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).number+1));
		System.out.println(String.format(" %-30s  %-21s ", "Customer Name:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).fullName));
		System.out.println(String.format(" %-30s  %-21s ", "Date:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).date));
		System.out.println(String.format(" %-30s  %-21s ", "Website:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).emailList));
		System.out.println(String.format(" %-25s  %-10s  %-13s ", "Item Name", "Price", "Quantity"));
		for (Product i : CreateNewInvoice.itemss) {
			System.out.println(String.format("| %-25s | R.O%6.2f  %6d ", i.getItemName(), i.getPrice(), i.getQuantity()));
		    total += i.getQuantity() * i.getPrice();
		}
		System.out.println(String.format(" %-30s  %-25s ", "Total:", total));
	}

}
