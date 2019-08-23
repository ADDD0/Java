import java.awt.*;
import java.awt.event.*;

public class TestAnonymous {
	Frame f = new Frame("匿名内部类测试");
	TextField tf = new TextField(30);

	public TestAnonymous() {
		f.add(new Label("请按下鼠标左键并拖动"), "North");
		f.add(tf, "South");

		f.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				String s = "鼠标拖动到位置(" + e.getX() + "," + e.getY() + ")";
				tf.setText(s);
			}

			public void mouseMoved(MouseEvent e) {
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(300, 200);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		TestAnonymous t = new TestAnonymous();
	}
}