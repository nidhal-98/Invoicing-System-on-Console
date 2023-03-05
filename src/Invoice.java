import java.util.HashSet;

public class Invoice {
	int number;
	String date;
	String fullName;
	HashSet<String> emailList = new HashSet<String>();
	HashSet<String> websiteList = new HashSet<String>();
	int phoneNumber;
	int fax;

	public static void setData() {
		try {
				System.out.print("Enter Phone Number:  ");
				int phoneNumberEnterd = Main.hold.nextInt();
				System.out.print("Enter Fax Number:  ");
				int faxNumberEnterd = Main.hold.nextInt();
				System.out.print("Enter Email:  ");
				String websiteEnterd = Main.hold.next();
				for (int i = 0; i < Main.newShop.invoiceList.size(); i++) {
					Main.newShop.invoiceList.get(i).number = (i + 1);
					Main.newShop.invoiceList.get(i).phoneNumber = phoneNumberEnterd;
					Main.newShop.invoiceList.get(i).fax = faxNumberEnterd;
					Main.newShop.invoiceList.get(i).websiteList.add(websiteEnterd);
				}
				System.out.println("Done!\n");

		} catch (Exception ex) {
			System.out.println("Invalid Input\n");
		}
	}
}
