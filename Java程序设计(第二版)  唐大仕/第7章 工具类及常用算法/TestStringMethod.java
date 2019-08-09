public class TestStringMethod {
	public static void main(String[] args) {
		String s = new String("Hello World");

		System.out.println(s.length());
		System.out.println(s.indexOf('o'));
		System.out.println(s.indexOf("He"));
		System.out.println(s.startsWith("He"));
		System.out.println(s.equals("Hello world"));
		System.out.println(s.equalsIgnoreCase("Hello world"));
		System.out.println(s.compareTo("Hello Java"));
		System.out.println(s.charAt(1));
		System.out.println(s.substring(0, 2));
		System.out.println(s.substring(2));
		System.out.println(s.concat("!!!"));
		System.out.println(s.trim());
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.replace('o', 'x'));

		System.out.println(s);  //注意,s本身没有改变
	}
}