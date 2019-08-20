import java.io.*;

class Persona implements Serializable {
	String name;
	int age;

	Persona(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + "(" + age + ")";
	}
}

public class SerializeDemo {
	public static void main(String[] args) throws IOException {
		Persona[] ps = { new Persona("Li", 18), new Persona("Wang", 19) };
		String fileName = "s.temp";
		// 序列化
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
		for (Persona p : ps)
			output.writeObject(p);
		output.close();
		// 反序列化
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
		Persona p = null;
		try {
			while ((p = (Persona) input.readObject()) != null)
				System.out.println(p);
		} catch (ClassNotFoundException ex) {
		} catch (EOFException eofex) {
		}
		input.close();
	}
}