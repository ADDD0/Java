package util;

// IUserDAOImpl类只会用这个类来进行日期的转换
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataConvert {
	public java.sql.Date strToSD(String str) {
		java.util.Date ud = null;
		try {
			ud = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sd = new java.sql.Date(ud.getTime());
		return sd;
	}

	public java.util.Date strToUD(String str) {
		java.util.Date ud = null;
		try {
			ud = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ud;
	}

	public java.sql.Date uDToSD(java.util.Date ud) {
		java.sql.Date sd = new java.sql.Date(ud.getTime());
		return sd;
	}
}
