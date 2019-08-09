public class Assertion {
	public static void main(String[] args) {
		assert xiebian(3, 4) == 5 : "算法不正确 ";
	}
	static double xiebian(double x, double y) {
		return Math.sqrt(x*x + y*y);
	}
}