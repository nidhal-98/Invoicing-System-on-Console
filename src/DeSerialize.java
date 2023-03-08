import java.io.*;

class DeSerialize implements Serializable {

	public static void main() {
		try {
			FileInputStream file = new FileInputStream("invoiceSerialization.txt");
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			while (true) {
				try {
					String deserializedObject = (String) in.readObject();
					System.out.println(deserializedObject);
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
					System.out.println("Class not found");
				}
			}

			in.close();
			file.close();

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}
}