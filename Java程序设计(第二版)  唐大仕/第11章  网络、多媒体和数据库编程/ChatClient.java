import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ChatClient extends JFrame implements Runnable {
	boolean isStandalone = false;

	public ChatClient() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Main method */
	public static void main(String[] args) {
		ChatClient c = new ChatClient();
		c.show();
	}

	JPanel contentPane;
	JTextField txtInput = new JTextField();
	JButton btnSend = new JButton();
	JButton btnStart = new JButton();
	List lstMsg = new List();

	Socket sock;
	Thread thread;
	BufferedReader in;
	PrintWriter out;
	public final static int DEFAULT_PORT = 6543;
	boolean bConnected;

	public void startConnect() {
		bConnected = false;
		try {
			// sock = new Socket(this.getCodeBase().getHost(), DEFAULT_PORT);
			sock = new Socket("127.0.0.1", DEFAULT_PORT);
			bConnected = true;
			processMsg("Connection ok");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new java.io.PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			processMsg("Connection failed");
		}
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void run() {
		while (true) {
			try {
				String msg = receiveMsg();
				Thread.sleep(100L); // ????
				if (msg != null) {
					processMsg(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException ei) {
			}
		}
	}

	public void sendMsg(String msg) throws IOException {
		out.println(msg);
		out.flush();
	}

	public String receiveMsg() throws IOException {
		String msg = new String();
		try {
			msg = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public void processMsg(String str) {
		this.lstMsg.add(str);
	}

	private void jbInit() throws Exception {
		txtInput.setText("please input here");
		txtInput.setBounds(new Rectangle(42, 234, 196, 34));
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		this.setSize(new Dimension(500, 300));
		this.setTitle("Chat Client");
		btnSend.setText("Send");
		btnSend.setBounds(new Rectangle(258, 235, 70, 35));
		btnSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSend_actionPerformed(e);
			}
		});
		btnStart.setText("Connect To Server");
		btnStart.setBounds(new Rectangle(338, 235, 150, 35));
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart_actionPerformed(e);
			}
		});
		lstMsg.setBounds(new Rectangle(42, 32, 319, 192));
		contentPane.add(txtInput, null);
		contentPane.add(btnSend, null);
		contentPane.add(btnStart, null);
		contentPane.add(lstMsg, null);
	}

	void btnSend_actionPerformed(ActionEvent e) {
		if (txtInput.getText().length() != 0) {
			try {
				sendMsg(txtInput.getText());
			} catch (IOException e2) {
				processMsg(e2.toString());
			}
		}
	}

	void btnStart_actionPerformed(ActionEvent e) {
		this.startConnect();
	}

	// static initializer for setting look & feel
	static {
		try {
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
	}
}