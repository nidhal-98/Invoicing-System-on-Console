import java.util.ArrayList;
import java.util.HashSet;

public class Invoice {
	int number;
	String date;
	String fullName;
	ArrayList<Product> item = new ArrayList<>();
	HashSet<String> emailList = new HashSet<String>();
	HashSet<String> websiteList = new HashSet<String>();
	int phoneNumber;
	int fax;
	double total;
	double paid;
	double balance;
}