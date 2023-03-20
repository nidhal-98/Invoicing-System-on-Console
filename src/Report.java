
public class Report {
	static void statistics() {
		while(true) {
			if(Main.newShop.invoiceList.isEmpty()) {
				System.out.printf("%-20s%-20s%-20s\n", "No of Items", "No of Invoices", "Total Sales");
		        System.out.printf("%-20d%-20d%-20s\n", Main.newShop.productList.size(), Main.newShop.invoiceList.size(), "0" + " R.O");
				break;
			}
			else {
				System.out.printf("%-20s%-20s%-20s\n", "No of Items", "No of Invoices", "Total Sales");
				double totalSales =0;
				for(int i =0; i<Main.newShop.invoiceList.size(); i++) {
					totalSales = totalSales + Main.newShop.invoiceList.get(i).total;
				}
		        System.out.printf("%-20d%-20d%-20.2f\n", Main.newShop.productList.size(), Main.newShop.invoiceList.size(), totalSales);
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
							Main.newShop.invoiceList.get(j).number
									));
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
	
	public static void AppStatistics() {
		System.out.println("       [1] Shop Settings ➤ ︎" + Main.settingsCount);
		System.out.println("            [1] Load Data ➤ " + ShopSetting.loadCount);
		System.out.println("            [2] Set Shop Name ➤ " + ShopSetting.setNameCount);
		System.out.println("            [3] Set Invoice Header ➤ " + ShopSetting.headerCount);
		System.out.println("       [2] Manage Shop Items ➤ " + Main.manageCount);
		System.out.println("            [1] Add Items ➤ " + ManageShopItem.addCount);
		System.out.println("            [2] Delete Items ➤ " + ManageShopItem.deleteCount);
		System.out.println("            [3] Change Item Price ➤ " + ManageShopItem.changeCount);
		System.out.println("            [4] Report All Items ➤ " + ManageShopItem.reportManageCount);
		System.out.println("       [3] Create New Invoice ➤ " + Main.newInvoiceCount);
		System.out.println("       [4] Report - Statistics ➤ " + Main.reportStatisticsCount);
		System.out.println("       [5] Report - All Invoices ➤ " + Main.reportInvoicesCount);
		System.out.println("       [6] Search ➤ " + Main.searchCount);
		System.out.println("       [7] Program Statistics ➤ " + Main.statisticsCount);
		System.out.println("       [8] Deserialization ➤ " + Main.deserializationCount);


	}

}
