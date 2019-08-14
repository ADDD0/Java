import java.awt.*;

public class VonKoch {
	public static void main(String[] args) {
		Frame frm = new Frame("VonKoch");
		frm.setSize(400, 200);
		frm.setBackground(Color.lightGray);
		frm.show();
		VonKoch p = new VonKoch(frm);
		p.drawVonKoch(8, p.width);
	}

	private Frame frm;
	private Graphics graphics;
	private int width;
	private int height;
	private double th, curx, cury;
	private final double PI = Math.PI;
	private final double m = 2 * (1 + Math.cos(85 * PI / 180));

	public VonKoch(Frame frm) {
		graphics = frm.getGraphics();
		width = frm.getSize().width;
		height = frm.getSize().height;
	}

	void drawVonKoch(int n, double d) {
		if (n == 0) {
			double x = curx + d * Math.cos(th * PI / 180);
			double y = cury + d * Math.sin(th * PI / 180);
			drawLineTo(x, y);
			return;
		}
		drawVonKoch(n - 1, d / m);
		th = th + 85;
		drawVonKoch(n - 1, d / m);
		th = th - 170;
		drawVonKoch(n - 1, d / m);
		th = th + 85;
		drawVonKoch(n - 1, d / m);
	}

	void drawLineTo(double x, double y) {
		graphics.drawLine((int) curx, (int) cury, (int) x, (int) y);
		curx = x;
		cury = y;
	}
}