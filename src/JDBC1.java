import java.sql.*;

public class JDBC1 {
    public static void invoices() {

        String url = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=shopSystem;" +
                "encrypt=true;" +
                "trustServerCertificate=true";

        String user = "sa";
        String pass = "root";

        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);            
            
            String sql = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Invoices')\r\n"
            		+ "BEGIN\r\n"
            		+ "	CREATE TABLE Invoices(\r\n"
            		+ "		id INT IDENTITY PRIMARY KEY,\r\n"
            		+ "		shop_name VARCHAR(50),\r\n"
            		+ "		shop_phone_number INT,\r\n"
            		+ "		shop_fax_number INT,\r\n"
            		+ "		shop_website VARCHAR(50),\r\n"
            		+ "		invoice_number INT,\r\n"
            		+ "		customer_name VARCHAR(50),\r\n"
            		+ "		date VARCHAR(50),\r\n"
            		+ "		phone_number BIGINT,\r\n"
            		+ "		item_name VARCHAR(50),\r\n"
            		+ "		price DECIMAL(10, 2),\r\n"
            		+ "		quantity INT,\r\n"
            		+ "		Total DECIMAL(10, 2),"
            		+ "		paid DECIMAL(10, 2),\r\n"
            		+ "		balance DECIMAL(10, 2)\r\n"
            		+ "	);\r\n"
            		+ "END \r\n"
					+ "INSERT INTO invoices (shop_name, shop_phone_number, shop_fax_number, shop_website, invoice_number, customer_name, date, phone_number, item_name, price, quantity, Total, paid, balance) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            //String emailsStr = String.join(",", Main.newShop.invoiceList.);
           // statement.setString(9, emailsStr);
            // Loop through each item in the invoice and add them to the statement as parameters
            for (int i = 0; i < Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.size(); i++) {
                //statement.setString(9, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).emailList);
                statement.setString(9, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getItemName());
                statement.setDouble(10, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getPrice());
                statement.setInt(11, Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).item.get(i).getQuantity());
                statement.executeUpdate();
            }
            statement.setLong(12, (long) Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).paid);
            statement.setLong(13, (long) Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).balance);
            statement.setLong(14, (long) Main.newShop.invoiceList.get(Main.newShop.invoiceList.size() - 1).total);

            // Close the PreparedStatement object
            statement.close();
            
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}