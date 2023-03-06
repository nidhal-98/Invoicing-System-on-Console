import java.util.ArrayList;

public class Shop {
	public String shopName;
	static int phoneNumberOwner;
	static int faxOwner;
	static String website;
	ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	ArrayList<Product> productList = new ArrayList<Product>();

	public static void newShop() {
		System.out.print("Enter Shop Name:  ");
		String shopNameEnterd = Main.hold.next();
		Main.newShop.shopName = shopNameEnterd;
	}

	public static void setData() {
		try {
			System.out.print("Enter Phone Number:  ");
			int phoneNumberEnterd = Main.hold.nextInt();
			phoneNumberOwner = phoneNumberEnterd;
			System.out.print("Enter Fax Number:  ");
			int faxNumberEnterd = Main.hold.nextInt();
			faxOwner = faxNumberEnterd;
			System.out.print("Enter Email:  ");
			String websiteEnterd = Main.hold.next();
			website = websiteEnterd;
			System.out.println("Done!\n");

		} catch (Exception ex) {
			System.out.println("Invalid Input\n");
		}
	}
}
