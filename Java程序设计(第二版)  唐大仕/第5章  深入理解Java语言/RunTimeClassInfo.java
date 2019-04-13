import java.lang.reflect.*;

public class RunTimeClassInfo {
	public static void main(String[] args) {
		Object obj = new java.awt.Color(1, 1, 1);
		Class cls = obj.getClass();
		System.out.println("类名:" + cls.getName());
		Field[] fields = cls.getFields();
		for (int i=0; i < fields.length; ++i) {
			Field f = fields[i];
			System.out.println("域:" + f.getName() + ":" + f);
		}
		Method[] methods = cls.getMethods();
		for (int i=0; i < methods.length; ++i) {
			Method m = methods[i];
			System.out.println("方法:" + m.getName() + ":" + m);
		}
	}
}