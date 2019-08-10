package p2;

class MyDate {
	int day, month, year;

	public MyDate(int i, int j, int k) {
		day = i;
		month = j;
		year = k;
	}
}

class MyOkDate extends MyDate {
	public MyOkDate(int i, int j, int k) {
		super(i, j, k);
	}

	public String toString() {
		return year + "-" + month + "-" + day;
	}
}

public class TestToString {
	public static void main(String[] args) {
		MyDate m1 = new MyDate(24, 3, 2001);
		MyDate m2 = new MyOkDate(24, 3, 2001);
		System.out.println(m1); // 显示类名@内存地址
		System.out.println(m2); // 显示2001-3-24
	}
}