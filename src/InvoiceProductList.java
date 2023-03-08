/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InvoiceProductList {

    public static void loadInvoice() {
    	 String fileName = "invoices.txt";

         try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
             String line;
             Invoice invoice = null;

             while ((line = br.readLine()) != null) {
                 if (line.startsWith("New Invoice")) {
                     invoice = new Invoice();
                     Main.newShop.invoiceList.add(invoice);
                     String dateTime = br.readLine();
                 } else if (line.startsWith("| Shop Name:")) {
                	 Main.newShop.shopName = (line.split("\\|")[2].trim());
                 } else if (line.startsWith("| Shop Phone Number:")) {
                	 String phoneNumberOwnerString = line.split("\\|")[2].trim();
                	 int phoneNumberOwner = Integer.parseInt(phoneNumberOwnerString);
                	 Shop.phoneNumberOwner = phoneNumberOwner;
                 } else if (line.startsWith("| Shop Fax Number:")) {
                	 String faxOwnerString = line.split("\\|")[2].trim();
                	 int faxOwner = Integer.parseInt(faxOwnerString);
                	 Shop.faxOwner = faxOwner;
                 } else if (line.startsWith("| Shop Website:")) {
                     Shop.website = (line.split("\\|")[2].trim());
                 } else if (line.startsWith("| Invoice No.:")) {
                     invoice.number = (Integer.parseInt(line.split("\\|")[2].trim()));
                 } else if (line.startsWith("| Customer Name:")) {
                     invoice.fullName = (line.split("\\|")[2].trim());
                 } else if (line.startsWith("| Phone:")) {
                	 String phoneNumberString = (line.split("\\|")[2].trim());;
                	 int phoneNumber = Integer.parseInt(phoneNumberString);
                     invoice.phoneNumber = phoneNumber;
                 } else if (line.startsWith("| Email:")) {
                     invoice.emailList.add(line.split("\\|")[2].trim());
                 } else if (line.startsWith("| Item Name")) {
                     // skip this line, as it is a header
                 } else if (line.startsWith("| Total:")) {
                     invoice.total = (Double.parseDouble(line.split("\\|")[2].trim()));
                 } else if (line.startsWith("| Paid:")) {
                     invoice.paid = (Double.parseDouble(line.split("\\|")[2].trim()));
                 } else if (line.startsWith("| Balance:")) {
                     invoice.balance = (Double.parseDouble(line.split("\\|")[2].trim()));
                 } else if (line.isEmpty()) {
                     // skip empty line
                 } else {
                     String[] parts = line.split("\\|");
                     String itemName = parts[1].trim();
                     invoice.item.get(0).setItemName(itemName);
                     double price = Double.parseDouble(parts[2].trim().split("\\s+")[1]);
                     invoice.item.get(0).setPrice(price);
                     int quantity = Integer.parseInt(parts[3].trim());
                     
                     
                     
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }

         // Print the list of invoices
         for (Invoice invoice : invoiceList) {
             System.out.println(invoice.toString());
         }
    }
}*/
