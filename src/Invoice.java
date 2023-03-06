import java.util.HashSet;

public class Invoice {
	int number;
	String date;
	String fullName;
	HashSet<String> emailList = new HashSet<String>();
	HashSet<String> websiteList = new HashSet<String>();
	int phoneNumber;
	int fax;
}
