import java.awt.*;
import java.applet.*;

@SuppressWarnings("deprecation")
public class HelloWorldApplet extends Applet {  //an applet
	public void paint(Graphics g) {
		g.drawString("Hello World!", 20, 20);
	}
}