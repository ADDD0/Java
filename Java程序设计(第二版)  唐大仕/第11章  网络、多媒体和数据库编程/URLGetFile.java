import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class URLGetFile extends Applet {
	URL url;
	TextArea showarea = new TextArea("下载的数据:");

	public void init() {
		String strurl = "https://www.pku.edu.cn/";
		try {
			url = new URL(strurl);
		} catch (MalformedURLException e) {
			System.out.println("URL格式有错");
		}
		add(showarea);
	}

	public void start() {
		InputStream filecon = null;
		BufferedReader filedata = null;
		String line;
		try {
			filecon = url.openStream();
			filedata = new BufferedReader(new InputStreamReader(filecon));
			while ((line = filedata.readLine()) != null) {
				showarea.append(line + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error in I/O:" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Frame f = new Frame("URL Test");
		Applet ap = new URLGetFile();
		ap.init();
		f.add(ap);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(400, 300);
		f.show();
		ap.start();
	}
}