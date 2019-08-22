import java.awt.*;

public class TestFlowLayout {
	public static void main(String[] args) {
		Frame f = new Frame("Flow Layout");
		Button[] buttons = new Button[8];
		for (int i = 0; i < buttons.length; ++i)
			buttons[i] = new Button("button" + (i + 1));

		f.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

		for (int i = 0; i < buttons.length; ++i)
			f.add(buttons[i]);

		f.setSize(200, 200);
		// f.pack();
		f.setVisible(true);
	}
}