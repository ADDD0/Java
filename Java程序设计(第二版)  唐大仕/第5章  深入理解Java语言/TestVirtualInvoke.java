public class TestVirtualInvoke {
	static void doStuff(Shape s) {
		s.draw();
	}
	public static void main(String[] args) {
		Circle c = new Circle();
		Triangle t = new Triangle();
		Line l = new Line();
		doStuff(c);
		doStuff(t);
		doStuff(l);
	}
}