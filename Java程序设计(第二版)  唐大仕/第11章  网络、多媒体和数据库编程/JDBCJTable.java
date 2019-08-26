import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

class JDBCJTable extends Frame {
	AbstractTableModel tm; // 声明一个类AbstractTableModel对象
	JTable table; // 声明一个类JTable对象
	JScrollPane scrollpane; // 声明一个滚动面板对象
	String titles[]; // 二维表列名
	Vector records; // 声明一个向量对象

	public void init() {
		records = new Vector(); // 实例化向量
		tm = new AbstractTableModel() {

			// 取得表格列数
			public int getColumnCount() {
				return titles.length;
			}

			// 取得表格行数
			public int getRowCount() {
				return records.size();
			}

			// 取得单元格中的属性值
			public Object getValueAt(int row, int column) {
				if (!records.isEmpty())
					return ((Vector) records.elementAt(row)).elementAt(column);
				else
					return null;
			}

			// 设置表格列名
			public String getColumnName(int column) {
				return titles[column];
			}

			// 数据模型不可编辑,该方法设置为空
			public void setValueAt(Object value, int row, int column) {
			}

			// 取得列所属对象类
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}

			// 设置单元格不可编辑,为默认实现
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	public void start() throws SQLException, ClassNotFoundException {
		// String driver="com.sybase.jdbc.SybDriver";
		// SybDriver sybdriver=(SybDriver)
		// Class.forName(driver).newInstance();
		// DriverManager.registerDriver(sybdriver);
		// String user="sa";
		// String password="";
		// String url="jdbc:sybase:Tds:202.117.203.114:5000/WORKER";
		// SybConnection connection=(SybConnection)
		// DriverManager.getConnection(url,user,password);

		// 加载 jdbc-odbc桥驱动程序
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// 定义JDBC URL
		String url = "jdbc:odbc:pubs";

		// 得到与数据库的连接
		java.sql.Connection connection = DriverManager.getConnection(url);

		// 显示查询结果
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from authors");
		ResultSetMetaData meta = rs.getMetaData(); // 得到元数据

		int cols = meta.getColumnCount();
		System.out.println(cols);
		titles = new String[cols];
		for (int i = 0; i < cols; ++i)
			titles[i] = meta.getColumnName(i + 1); // 得到列名

		records.removeAllElements(); // 初始化向量对象
		while (rs.next()) {
			Vector rec_vector = new Vector();
			// 从结果集中取数据放入向量rec_vector中
			for (int i = 0; i < titles.length; ++i)
				rec_vector.addElement(rs.getObject(i + 1).toString());
			records.addElement(rec_vector);
		}

		// 定制表格:
		table = new JTable(tm); // 生成自己的数据模型
		table.setToolTipText("显示全部查询结果"); // 设置帮助提示
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 设置表格调整尺寸模式
		table.setCellSelectionEnabled(false); // 设置单元格选择方式
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		scrollpane = new JScrollPane(table); // 给表格加上滚动条
		add(scrollpane);

		tm.fireTableStructureChanged();// 更新表格
	}

	public static void main(String[] args) {
		JDBCJTable f = new JDBCJTable();
		f.init();
		try {
			f.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		f.setSize(400, 300);
		f.setTitle("Show Database in JTable");
		f.show();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}