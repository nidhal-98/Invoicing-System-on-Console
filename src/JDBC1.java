import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC1 {
	public static void invoices() {

		String url = /* "jdbc:sqlserver://localhost:1433;" */ Main.urlEnterd + "databaseName=shopSystem;"
				+ "encrypt=true;" + "trustServerCertificate=true";

		String user = Main.userName /* "sa" */;
		String pass = Main.passWord /* "root" */;

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			String sql = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Invoices')\r\n" + "BEGIN\r\n"
					+ "	CREATE TABLE Invoices(\r\n" + "		id INT IDENTITY PRIMARY KEY,\r\n"
					+ "		shop_name VARCHAR(50),\r\n" + "		shop_phone_number INT,\r\n"
					+ "		shop_fax_number INT,\r\n" + "		shop_website VARCHAR(50),\r\n"
					+ "		invoice_number INT,\r\n" + "		customer_name VARCHAR(50),\r\n"
					+ "		date VARCHAR(50),\r\n" + "		phone_number BIGINT,\r\n" + "		email VARCHAR(50),\r\n"
					+ "		item_name VARCHAR(50),\r\n" + "		price DECIMAL(10, 2),\r\n" + "		quantity INT,\r\n"
					+ "		Total DECIMAL(10, 2)," + "		paid DECIMAL(10, 2),\r\n"
					+ "		balance DECIMAL(10, 2)\r\n" + "	);\r\n" + "END \r\n"
					+ "INSERT INTO Invoices (shop_name, shop_phone_number, shop_fax_number, shop_website, invoice_number, customer_name, date, phone_number, email, item_name, price, quantity, Total, paid, balance) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);

			// Set parameters for the statement
			statement.setString(1, Main.newShop.shopName);
			statement.setLong(2, Main.newShop.phoneNumberOwner);
			statement.setLong(3, Main.newShop.faxOwner);
			statement.setString(4, Main.newShop.website);
			statement.setInt(5, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).number);
			statement.setString(6, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).fullName);
			statement.setString(7, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).date);
			statement.setLong(8, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).phoneNumber);
			statement.setString(9, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).emailList.toString());
			statement.setDouble(13, (double) Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).total);
			statement.setDouble(14, (double) Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).paid);
			statement.setDouble(15, (double) Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).balance);
			// Loop through each item in the invoice and add them to the statement as
			// parameters
			for (int i = 0; i < Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.size(); i++) {
				// statement.setString(9,
				// Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).emailList);
				statement.setString(10,
						Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getItemName());
				statement.setDouble(11,
						Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getPrice());
				statement.setInt(12,
						Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getQuantity());
				statement.executeUpdate();
			}

			// Close the PreparedStatement object
			statement.close();

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void items() {
		String url = /* "jdbc:sqlserver://localhost:1433;" */ Main.urlEnterd + "databaseName=shopSystem;"
				+ "encrypt=true;" + "trustServerCertificate=true";

		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			String sql = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Items')\r\n" + "BEGIN\r\n"
					+ "	CREATE TABLE Items(\r\n" + "		id INT IDENTITY PRIMARY KEY,\r\n"
					+ "		item_ID INT,\r\n" + "		item_Name VARCHAR(50),\r\n" + "		item_Quantity INT,\r\n"
					+ "		price DECIMAL(10, 2),\r\n" + "		item_QTY DECIMAL(10, 2) \r\n" + "	);\r\n" + "END \r\n"
					+ "INSERT INTO Items (item_ID, item_Name, item_Quantity, price, item_QTY) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);

			// Set parameters for the statement
			
				statement.setInt(1, Main.newShop.productList.get(Main.newShop.productList.size()-1).getItemID());
				statement.setString(2, Main.newShop.productList.get(Main.newShop.productList.size()-1).getItemName());
				statement.setInt(3, Main.newShop.productList.get(Main.newShop.productList.size()-1).getQuantity());
				statement.setDouble(4, (double) Main.newShop.productList.get(Main.newShop.productList.size()-1).getPrice());
				statement.setDouble(5, (double) (Main.newShop.productList.get(Main.newShop.productList.size()-1).getPrice()
						* Main.newShop.productList.get(Main.newShop.productList.size()-1).getQuantity()));
				statement.executeUpdate();
			

			// Close the PreparedStatement object
			statement.close();
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void readItems() {
		String url = /* "jdbc:sqlserver://localhost:1433;" */ Main.urlEnterd + "databaseName=shopSystem;"
				+ "encrypt=true;" + "trustServerCertificate=true";
		
		String user = "sa";
		String pass = "root";

		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT * FROM Items";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Product newProduct = new Product();
				Main.newShop.productList.add(newProduct);

				int id = resultSet.getInt("id");
				Main.newShop.productList.get((Main.newShop.productList.size() - 1)).setItemID(id);

				int itemID = resultSet.getInt("item_ID");
				Main.newShop.productList.get((Main.newShop.productList.size() - 1)).setItemID(itemID);

				String itemName = resultSet.getString("item_Name");
				Main.newShop.productList.get((Main.newShop.productList.size() - 1)).setItemName(itemName);
				;

				int quantity = resultSet.getInt("item_Quantity");
				Main.newShop.productList.get((Main.newShop.productList.size() - 1)).setQuantity(quantity);
				;

				double price = resultSet.getDouble("price");
				Main.newShop.productList.get((Main.newShop.productList.size() - 1)).setPrice(price);
				;

			}

			statement.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println(ex);
		}
	}
	
	public static void readInvoices() {
		String url = /* "jdbc:sqlserver://localhost:1433;" */ Main.urlEnterd + "databaseName=shopSystem;"
				+ "encrypt=true;" + "trustServerCertificate=true";
		
	    String user = "sa";
	    String pass = "root";

	    try {
	        Connection con = DriverManager.getConnection(url, user, pass);
	        String sql = "SELECT * FROM Invoices";
	        PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        ResultSet resultSet = statement.executeQuery();
	        
	        if (!resultSet.isBeforeFirst()) {
	            //System.out.println("No invoices found.");
	            return;
	        }
	        
	        while (resultSet.next()) {
	            Invoice newInvoice = new Invoice();
	            Main.newShop.invoiceList.add(newInvoice);

	            String shopName = resultSet.getString("shop_name");
	            Main.newShop.shopName = shopName;

	            int shopPhone = resultSet.getInt("shop_phone_number");
	            Main.newShop.phoneNumberOwner = shopPhone;

	            int shopFax = resultSet.getInt("shop_fax_number");
	            Main.newShop.faxOwner = shopFax;

	            String shopWebsite = resultSet.getString("shop_website");
	            Main.newShop.website = shopWebsite;

	            int invoiceNum = resultSet.getInt("invoice_number");
	            newInvoice.number = invoiceNum;

	            String customeName = resultSet.getString("customer_name");
	            newInvoice.fullName = customeName;

	            String date = resultSet.getString("date");
	            newInvoice.date = date;

	            int phone = resultSet.getInt("phone_number");
	            newInvoice.phoneNumber = phone;

	            String email = resultSet.getString("email");
	            newInvoice.emailList.add(email);

	            Double total = resultSet.getDouble("Total");
	            newInvoice.total = total;

	            Double paid = resultSet.getDouble("paid");
	            newInvoice.paid = paid;

	            Double balance = resultSet.getDouble("balance");
	            newInvoice.balance = balance;
	            
	            do {
	                // Create a new product object
	                Product newProduct = new Product();

	                // Set the product details
	                newProduct.setItemName(resultSet.getString("item_name"));
	                newProduct.setPrice(resultSet.getDouble("price"));
	                newProduct.setQuantity(resultSet.getInt("quantity"));

	                // Add the product to the invoice's item list
	                newInvoice.item.add(newProduct);
	                
	            } while (resultSet.next() && resultSet.getInt("invoice_number") == invoiceNum);
	            
	            resultSet.previous();
	        }

	        resultSet.close();
	        statement.close();
	        con.close();
	    } catch (SQLException ex) {
	    }
	}



}