import java.applet.*;
import java.awt.*;

public class Imag0 extends Applet {
	Image image;

	public void init() {
		image = getImage(getDocumentBase(), "test.gif");
	}

	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}