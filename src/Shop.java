import java.util.ArrayList;

public class Shop {
	public String shopName;
	ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	ArrayList<Product> productList = new ArrayList<Product>();
	
	public static void newShop() {
		System.out.print("Enter Shop Name:  ");
		String shopNameEnterd = Main.hold.next();
		Main.newShop.shopName = shopNameEnterd;
	}
}
