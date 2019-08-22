import java.awt.*;

public class TestBorderLayout {
	public static void main(String[] args) {
		Frame f = new Frame("Border Layout");

		f.setLayout(new BorderLayout());
		f.add(new Button("North"), BorderLayout.NORTH);
		f.add(new Button("South"), BorderLayout.SOUTH);
		f.add(new Button("East"), BorderLayout.EAST);
		f.add(new Button("West"), BorderLayout.WEST);
		f.add(new Button("Center"), BorderLayout.CENTER);
		// f.add(new Button("Center"), "Center"); // 注意大小写
		// f.add("Center", new Button("Center"));

		f.setSize(200, 200);
		f.setVisible(true);
	}
}
