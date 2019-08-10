enum Direction2 {
	EAST("东", 1), SOUTH("南", 2), WEST("西", 3), NORTH("北", 4);
	private Direction2(String desc, int num) {
		this.desc = desc;
		this.num = num;
	}

	private String desc;
	private int num;

	public String getDesc() {
		return desc;
	}

	public int getNum() {
		return num;
	}
}

public class EnumDemo2 {
	public static void main(String[] args) {
		Direction2 dir = Direction2.NORTH;
		for (Direction2 d : Direction2.values())
			System.out.println(d.getDesc() + "," + d.getNum() + "," + d.ordinal());
	}
}