package utils;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeUtils {
	public static final String DB_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String WEB_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	// 日期时间格式化
	public static String formatDate(String datetime, String sFmtFrom, String sFmtTo) throws ParseException {
		SimpleDateFormat sdfFrom = new SimpleDateFormat(sFmtFrom);
		Date date = sdfFrom.parse(datetime);
		SimpleDateFormat sdfTo = new SimpleDateFormat(sFmtTo);
		return sdfTo.format(date);
	}

	// 字符串转为时间戳格式
	public static Timestamp toSqlTimestamp(String datetime) throws ParseException {
		if (datetime == "" || datetime == null) {
			return null;
		}
		return Timestamp.valueOf(formatDate(datetime, WEB_TIME_PATTERN, DB_TIME_PATTERN));
	}

	// 字符串转为网页时间格式
	public static String toWebTimestamp(String datetime) throws ParseException {
		if (datetime == "" || datetime == null) {
			return null;
		}
		return formatDate(datetime, DB_TIME_PATTERN, WEB_TIME_PATTERN);
	}

	// 测试输出
	public static void main(String[] args) throws ParseException {
		String dt1 = "2021-01-01T01:01:02";
		String dt2 = "2021-01-01 02:02:01";

		System.out.println(toSqlTimestamp(dt1));
		System.out.println(toWebTimestamp(dt2));
	}
}
