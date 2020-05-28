package date;

import java.util.Scanner;

public class NextDate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年：");
		int year = sc.nextInt();
		System.out.println("请输入月：");
		int month = sc.nextInt();
		System.out.println("请输入日：");
		int day = sc.nextInt();
		System.out.println(nextDay(year, month, day));
		sc.close();
	}

	static String nextDay(int year, int month, int day) {
		String s = null;
		if (year < 1812 || year > 2012) {
			return "年错误";
		} else if (month < 1 || month > 12) {
			return "月错误";
		}
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if (day == 31) {
				month += 1;
				day = 1;
			} else if (day < 31 && day > 0) {
				day += 1;
			} else {
				return "日错误";
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day == 30) {
				month += 1;
				day = 1;
			} else if (day < 30 && day > 0) {
				day += 1;
			} else {
				return "日错误";
			}
			break;
		case 12:
			if (day == 31) {
				month = 1;
				day = 1;
				year += 1;
			} else if (day < 31 && day > 0) {
				day += 1;
			} else {
				return "日错误";
			}
			break;
		case 2:
			if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
				if (day == 29) {
					day = 1;
					month = 3;
				} else if (day < 29 && day > 0) {
					day += 1;
				} else {
					return "日错误";
				}
			} else if (day == 28) {
				day = 1;
				month = 3;
			} else if (day < 28 && day > 0) {
				day += 1;
			} else {
				return "日错误";
			}
			break;

		}
		s = year + "." + month + "." + day;
		return s;
	}
}
