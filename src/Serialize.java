import java.io.*;

class Serialize implements Serializable {

	public static void main() {

		try {
			FileOutputStream file = new FileOutputStream("itemsSerialization.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			for (int i = 0; i < Main.newShop.productList.size(); i++) {
				out.writeObject(String.format("%20s %20s %20s %20s %20s\n", Main.newShop.productList.get(i).itemID,
						Main.newShop.productList.get(i).itemName, Main.newShop.productList.get(i).price + " R.O",
						Main.newShop.productList.get(i).quantity,
						((Main.newShop.productList.get(i).price) * (Main.newShop.productList.get(i).quantity)
								+ " R.O")));
			}

			out.close();
			file.close();
			System.out.println("serialized and saved");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}