package p1;

import java.awt.*;
import java.awt.event.*;

public class TestWindowAdapter {
	public static void main(String[] args) {
		Frame f = new Frame("Test");
		TextField msg = new TextField(20);
		Monitor1 m1 = new Monitor1(f);
		f.addWindowListener(m1);
		f.add(msg, BorderLayout.SOUTH);
		f.setSize(200, 160);
		f.setVisible(true);
	}
}

class Monitor1 extends WindowAdapter {
	Monitor1(Frame f) {
		this.f = f;
	}

	private Frame f;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}