import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class ImageSoundApplet extends Applet {
	Image img;
	AudioClip snd;

	public void init() {
		URL url = getDocumentBase();
		img = getImage(url, "cupHJbutton.gif");
		snd = getAudioClip(url, "spacemusic.au");
	}

	public void paint(Graphics g) {
		g.drawImage(img, 25, 25, this);
	}

	public void start() {
		snd.loop();
	}

	public void stop() {
		snd.stop();
	}
}