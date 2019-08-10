public class TransByValue {
	private static int a;

	public static void main(String[] args) {
		int a = 0;
		modify(a);
		System.out.println(a); // 输出0
		int[] b = new int[1];
		modify(b);
		System.out.println(b[0]); // 输出1
	}

	public static void modify(int a) {
		++a;
	}

	public static void modify(int[] b) {
		++b[0];
		b = new int[5];
	}
}