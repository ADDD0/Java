import java.awt.*;
import java.awt.event.*;

public class TestActionEvent {
	public static void main(String[] args) {
		Frame f = new Frame("Test");
		Button b = new Button("Press Me!");
		f.add(b);

		Monitor bh = new Monitor();
		b.addActionListener(bh);

		f.pack();
		f.setVisible(true);
	}
}

class Monitor implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("a button has been pressed");
	}
}