import java.util.HashSet;

public class Invoice {
	int number;
	String date;
	String fullName;
	HashSet<String> emailList = new HashSet<String>();
	int phoneNumber;
	String Fax;
	public static void setData() {
		System.out.print("Enter Phone Number:  ");
		String phoneNumberEnterd = Main.hold.next();
	}
}
