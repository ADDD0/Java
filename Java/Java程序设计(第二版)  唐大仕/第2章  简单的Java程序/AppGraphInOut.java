import java.awt.*;
import java.awt.event.*;

public class AppGraphInOut {
	public static void main(String[] args) {
		new AppFrame();
	}
}

@SuppressWarnings("serial")
class AppFrame extends Frame {
	TextField in = new TextField(10);
	Button btn = new Button("��ƽ��");
	Label out = new Label("������ʾ����ı�ǩ");

	@SuppressWarnings("deprecation")
	public AppFrame() {
		setLayout(new FlowLayout());
		add(in);
		add(btn);
		add(out);
		btn.addActionListener(new BtnActionAdapter());
		setSize(400, 100);
		show();
	}

	class BtnActionAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = in.getText();
			double d = Double.parseDouble(s);
			double sq = d * d;

			out.setText(d + "��ƽ����: " + sq);
		}
	}
}