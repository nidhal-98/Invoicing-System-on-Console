import java.io.*;

class Serialize implements Serializable {

	public static void items() {

		try {
			FileOutputStream file = new FileOutputStream("itemsSerialization.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			for (int i = 0; i < Main.newShop.productList.size(); i++) {
				out.writeObject(String.format("%20s %20s %20s %20s %20s\n", Main.newShop.productList.get(i).getItemID(),
						Main.newShop.productList.get(i).getItemName(), Main.newShop.productList.get(i).getPrice() + " R.O",
						Main.newShop.productList.get(i).getQuantity(),
						((Main.newShop.productList.get(i).getPrice()) * (Main.newShop.productList.get(i).getQuantity())
								+ " R.O")));
			}

			out.close();
			file.close();
			System.out.println("serialized and saved");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public static void invoice() {

		try {
			FileOutputStream file = new FileOutputStream("invoiceSerialization.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			double total = 0;
			out.writeObject("|                         INVOICE                        |");
			out.writeObject(String.format(" %-30s  %-21s ", "Shop Name:", Main.newShop.shopName));
			out.writeObject(String.format(" %-30s  %-21s ", "Shop Phone Number:", Shop.phoneNumberOwner));
			out.writeObject(String.format(" %-30s  %-21s ", "Shop Fax Number:", Shop.faxOwner));
			out.writeObject(String.format(" %-30s  %-21s ", "Shop Website:", Shop.website));
			out.writeObject(String.format(" %-30s  %-21s ", "Invoice No.:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).number+1));
			out.writeObject(String.format(" %-30s  %-21s ", "Customer Name:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).fullName));
			out.writeObject(String.format(" %-30s  %-21s ", "Date:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).date));
			out.writeObject(String.format(" %-30s  %-21s ", "Website:", Main.newShop.invoiceList.get(Main.newShop.invoiceList.size()-1).emailList));
			out.writeObject(String.format(" %-25s  %-10s  %-13s ", "Item Name", "Price", "Quantity"));
			for (Product i : CreateNewInvoice.item) {
				out.writeObject(String.format("| %-25s | R.O%6.2f  %6d ", i.getItemName(), i.getPrice(), i.getQuantity()));
			    total += i.getQuantity() * i.getPrice();
			}
			out.writeObject(String.format(" %-30s  %-25s ", "Total:", total));
			

			out.close();
			file.close();
			System.out.println("serialized and saved");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}