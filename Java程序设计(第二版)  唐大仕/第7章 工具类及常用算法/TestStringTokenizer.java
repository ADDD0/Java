import java.util.*;

public class TestStringTokenizer {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("this is a test");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}