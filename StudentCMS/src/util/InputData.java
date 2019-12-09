package util;

// Menu类中会使用这个类进行Java正则验证
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputData {
	private BufferedReader buf = null;

	public InputData() {
		this.buf = new BufferedReader(new InputStreamReader(System.in));
	}

	// 接收输入的汉字
	public String getString(String info) {
		String str = null;
		System.out.print("请输入" + info + "：");
		try {
			str = this.buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	// 键盘输入
	public int getInt(String info, String err) {
		int id = 0;
		String str = null;
		boolean flag = true;
		while (flag) {
			str = this.getString(info);
			if (str.matches("^\\d+$")) {
				id = Integer.parseInt(str);
				flag = false;
			} else {
				System.out.println(err);
			}
		}
		return id;
	}

	// 对输入生日的格式进行验证
	public Date getDate(String info, String err) {
		Date date = null;
		String str = null;
		boolean flag = true;
		while (flag) {
			str = this.getString(info);
			if (str.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				try {
					date = sdf.parse(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				flag = false;
			} else {
				System.out.println(err);
			}
		}
		return date;
	}
}
