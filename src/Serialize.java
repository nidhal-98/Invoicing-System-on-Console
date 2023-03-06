import java.io.*;

class Serialize implements Serializable {

	public static void main() {

		try {
			FileOutputStream file = new FileOutputStream("itemsSerialization.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			for (int i = 0; i < Main.newShop.productList.size(); i++) {
				out.writeObject(String.format("%20s %20s %20s %20s %20s\n", Main.newShop.productList.get(i).getItemID(),
						Main.newShop.productList.get(i).getItemName(), Main.newShop.productList.get(i).getPrice() + " R.O",
						Main.newShop.productList.get(i).getQuantity(),
						((Main.newShop.productList.get(i).getPrice()) * (Main.newShop.productList.get(i).getQuantity())
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