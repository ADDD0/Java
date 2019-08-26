import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class ChatServer extends JFrame implements Runnable {
	JPanel contentPane;
	JTextField txtInput = new JTextField();
	JButton btnSend = new JButton();
	List lstMsg = new List();

	/** Construct the frame */
	public ChatServer() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServerListen();
	}

	/** Component initialization */
	private void jbInit() throws Exception {
		txtInput.setText("please input here");
		txtInput.setBounds(new Rectangle(42, 234, 196, 34));

		// setIconImage(Toolkit.getDefaultToolkit().createImage(ChatServer.class.getResource("[YourIcon]")));
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		this.setSize(new Dimension(400, 300));
		this.setTitle("Chat Server");
		btnSend.setText("Send");
		btnSend.setBounds(new Rectangle(268, 235, 98, 35));
		btnSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSend_actionPerformed(e);
			}
		});
		lstMsg.setBounds(new Rectangle(42, 32, 319, 192));
		contentPane.add(txtInput, null);
		contentPane.add(btnSend, null);
		contentPane.add(lstMsg, null);
	}

	/** Overridden so we can exit when window is closed */
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.show();
	}

	public void processMsg(String str) {
		this.lstMsg.add(str);
	}

	void btnSend_actionPerformed(ActionEvent e) {
		for (int i = 0; i < clients.size(); ++i) {
			Connection c = (Connection) clients.get(i);
			try {
				c.sendMsg(this.txtInput.getText());
			} catch (Exception ee) {
			}
		}
	}

	public final static int DEFAULT_PORT = 6543;
	protected ServerSocket listen_socket;
	Thread thread;
	java.util.Vector clients;

	// Create a ServerSocket to listen for connections on; start the thread.
	public void ServerListen() {
		try {
			listen_socket = new ServerSocket(DEFAULT_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		processMsg("Server: listening on port " + DEFAULT_PORT);
		clients = new java.util.Vector();
		thread = new Thread(this);
		thread.start();
	}

	// The body of the server thread. Loop forever, listening for and
	// accepting connections from clients. For each connection,
	// create a Connection object to handle communication through the
	// new Socket.
	public void run() {
		try {
			while (true) {
				Socket client_socket = listen_socket.accept();
				Connection c = new Connection(client_socket, this);
				clients.add(c);
				processMsg("One Client Comes in");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//This class is the thread that handles all communication with a client
class Connection extends Thread {
	protected Socket client;
	protected BufferedReader in;
	protected PrintWriter out;
	ChatServer server;

	// Initialize the streams and start the thread
	public Connection(Socket client_socket, ChatServer server_frame) {
		client = client_socket;
		server = server_frame;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new java.io.PrintWriter(client.getOutputStream());
		} catch (IOException e) {
			try {
				client.close();
			} catch (IOException e2) {
			}
			e.printStackTrace();
			return;
		}
		this.start();
	}

	// Provide the service.
	// Read a line
	public void run() {
		String line;
		StringBuffer revline;
		int len;
		try {
			for (;;) {
				// read in a line
				line = receiveMsg();
				server.processMsg(line);
				if (line == null)
					break;
			}
		} catch (IOException e) {
		} finally {
			try {
				client.close();
			} catch (IOException e2) {
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
}