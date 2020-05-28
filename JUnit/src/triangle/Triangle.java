package triangle;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入 a 的值：");
		int a = sc.nextInt();
		System.out.println("请输入 b 的值：");
		int b = sc.nextInt();
		System.out.println("请输入 c 的值：");
		int c = sc.nextInt();
		System.out.println(type(a, b, c));
		sc.close();
	}

	static String type(int a, int b, int c) {
		String s = "非三角形";
		if (a + b > c && a + c > b && b + c > a) {
			if (a == b && b == c) {
				s = "等边三角形";
			} else if (a == b || b == c || a == c) {
				s = "等腰三角形";
			} else {
				s = "一般三角形";
			}
		}
		return s;
	}
}
