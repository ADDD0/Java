import java.util.*;

public class TestArrayList {
	public static void main(String[] args) {
		List h = new ArrayList();
		h.add("1st");
		h.add("2nd");
		h.add(new Integer(3));
		h.add(new Double(4.0));
		h.add("2nd");// 重复元素,加入
		h.add(new Integer(3));// 重复元素,加入
		m1(h);
	}

	public static void m1(List s) {
		System.out.println(s);
	}
}