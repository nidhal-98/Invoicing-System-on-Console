
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

}
