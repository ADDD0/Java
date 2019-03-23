public class Single {
	private static Single onlyone = new Single();
	private String name;
	public static Single getSingle() {
		return onlyone;
	}
	private Single() {}
}