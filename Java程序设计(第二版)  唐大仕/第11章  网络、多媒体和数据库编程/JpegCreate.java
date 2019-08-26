import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class JpegCreate {
	public static void main(String[] args) {
		int width = 400, height = 200;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		drawInImage(image);
		saveToJpg(image, "myfile.jpg");
	}

	// 在一个BufferedImage中画图
	public static void drawInImage(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int xLength = 300, yLength = 150;
		Vector data = new Vector();
		data.addElement(new Integer(100));
		data.addElement(new Integer(120));
		data.addElement(new Integer(150));
		data.addElement(new Integer(40));
		data.addElement(new Integer(5));
		int count = data.size();
		// 得到一个Graphics对象
		Graphics g = image.getGraphics();
		// 画坐标
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.blue);
		g.drawLine(10, height - 10, 10, height - 10 - yLength);
		g.drawLine(10, height - 10, 10 + xLength, height - 10);
		// 连线
		int yTo;
		int yFrom = ((Integer) (data.elementAt(0))).intValue();
		for (int i = 1; i < count; ++i) {
			yTo = ((Integer) (data.elementAt(i))).intValue();
			g.drawLine(10 + i * xLength / count, height - 10, 10 + i * xLength / count, height - 15);
			g.drawLine(10 + (i - 1) * xLength / count, yFrom, 10 + i * xLength / count, yTo);
			yFrom = yTo;
		}
	}

	// 保存为JPG图像
	public static void saveToJpg(BufferedImage image, String path) {
		try {
			OutputStream ops = new FileOutputStream(new File(path));
			ImageIO.write(image, "jpg", ops);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}