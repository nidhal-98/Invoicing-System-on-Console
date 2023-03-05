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
					System.out.println("Enter the shop Name:  ");
					Shop.newShop();
					break;
				case "3":
					Invoice.setData();
					break;
				case "4":
					break;
				default:
					System.out.println("Invalid Input");
				}
			}
				catch (NumberFormatException ex) {
					System.out.println("Invalid Input");
				}
			
		}
	}
}
