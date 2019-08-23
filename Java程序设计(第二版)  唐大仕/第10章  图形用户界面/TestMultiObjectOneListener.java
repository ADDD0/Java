import java.awt.*;
import java.awt.event.*;

public class TestMultiObjectOneListener {
	public static void main(String[] args) {
		Frame f = new Frame("Test");
		Button b1 = new Button("Start");
		TextField b2 = new TextField("text");

		Monitor3 bh = new Monitor3();
		b1.addActionListener(bh);
		b2.addActionListener(bh);
		f.add(b1, "North");
		f.add(b2, "Center");
		f.pack();
		f.setVisible(true);
	}
}

class Monitor3 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("a button " + e.getSource() + " has been pressed." + "command is: " + e.getActionCommand());
	}
}