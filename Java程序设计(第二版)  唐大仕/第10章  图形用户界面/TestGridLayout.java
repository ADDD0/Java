import java.awt.*;

public class TestGridLayout {
	public static void main(String[] args) {
		Frame f = new Frame("Grid Layout");
		Button[] buttons = new Button[20];
		for (int i = 0; i < buttons.length; ++i)
			buttons[i] = new Button("" + (i + 1));

		f.setLayout(new GridLayout(4, 5));

		for (int i = 0; i < buttons.length; ++i)
			f.add(buttons[i]);

		f.setSize(200, 200);
		f.setVisible(true);
	}
}