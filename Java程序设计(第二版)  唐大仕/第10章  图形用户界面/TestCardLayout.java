import java.awt.*;
import java.awt.event.*;

public class TestCardLayout {
	public static void main(String args[]) {
		final Frame f = new Frame("Card Layout");
		final CardLayout cl = new CardLayout();

		Button[] buttons = new Button[8];
		for (int i = 0; i < buttons.length; ++i) {
			buttons[i] = new Button("button" + (i + 1));
			buttons[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getModifiers() == InputEvent.BUTTON1_MASK)
						cl.next(f);
					else
						cl.previous(f);
				}
			});
		}

		f.setLayout(cl);
		for (int i = 0; i < buttons.length; ++i)
			f.add("" + (i + 1), buttons[i]);

		f.setSize(200, 200);
		f.setVisible(true);
	}
}