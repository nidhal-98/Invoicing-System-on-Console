/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	public static void invoices() {
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "sa";
		String password = "root";

		try {
			String url = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=test1;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";

	        String user = "sa";
	        String pass = "root";

	        Connection con = null;

	        try {

	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            DriverManager.registerDriver(driver);

	            con = DriverManager.getConnection(url, user, pass);


	            Statement st = con.createStatement();

	            String sql = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Invoice')\r\n" 
						+ "BEGIN"
						+ "CREATE TABLE invoices (\r\n" 
						+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
						+ "  shop_name VARCHAR(255),\r\n" 
						+ "  shop_phone_number BIGINT,\r\n"
						+ "  shop_fax_number BIGINT,\r\n" 
						+ "  shop_website VARCHAR(255),\r\n"
						+ "  invoice_number INT,\r\n" 
						+ "  customer_name VARCHAR(255),\r\n"
						+ "  date VARCHAR(255),\r\n" 
						+ "  phone_number BIGINT,\r\n" 
						+ "  email VARCHAR(255),\r\n"
						+ "  item_name VARCHAR(255),\r\n" 
						+ "  price DOUBLE,\r\n" 
						+ "  quantity INT\r\n" + ");\r\n"
						+ "END"
						+ "INSERT INTO invoices (shop_name, shop_phone_number, shop_fax_number, shop_website, invoice_number, customer_name, date, phone_number, email, item_name, price, quantity) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				// Set parameters for the statement
				statement.setString(1, Main.newShop.shopName);
				statement.setLong(2, Shop.phoneNumberOwner);
				statement.setLong(3, Shop.faxOwner);
				statement.setString(4, Shop.website);
				statement.setInt(5, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).number);
				statement.setString(6, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).fullName);
				statement.setString(7, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).date);
				statement.setLong(8, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).phoneNumber);
				// statement.setString(9,
				// Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).emailList);

				// Loop through each item in the invoice and add them to the statement as
				// parameters
				for (int i = 0; i < Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.size(); i++) {
					statement.setString(10,
							Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getItemName());
					statement.setDouble(11,
							Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getPrice());
					statement.setInt(12,
							Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getQuantity());
					statement.executeUpdate();
				}

	            con.close();
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
*/