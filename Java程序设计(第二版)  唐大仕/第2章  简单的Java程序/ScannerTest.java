import java.util.Scanner;

class ScannerTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("������һ����");
		int a = scanner.nextInt();
		System.out.printf("%d��ƽ����%d\n", a, a * a);
	}
}