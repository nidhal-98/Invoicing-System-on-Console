import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShopSetting {
	public static void shopSetting() {
		boolean menu = true;
		while(menu) {
			try {
				
				String[] mainMenuOption = {"Load Data", "Set Shop Name", "Set Invoice Header", "Go Back"};
				Menu mainMenu = new Menu(mainMenuOption);
				mainMenu.show();
				String select = Main.hold.next();
				switch (select) {
				case "1":
					break;
				case "2":
					Shop.newShop();
					break;
				case "3":
					if(Main.newShop.invoiceList.size() == 0) {
						System.out.println("There is no invoice, Create Invoice First :)\n");
						menu = false;
					}
					else {
						Invoice.setData();
					}
					break;
				case "4":
					break;
				default:
					System.out.println("Invalid Input");
				}
			}
				catch (Exception ex) {
					System.out.println("Invalid Input");
				}
			
		}
	}
}
