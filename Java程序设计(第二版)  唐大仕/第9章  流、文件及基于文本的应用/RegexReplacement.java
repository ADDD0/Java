import java.util.regex.*;

public class RegexReplacement {
	public static void main(String[] args) throws Exception {
		Pattern p = Pattern.compile("cat");
		Matcher m = p.matcher("one cat, two cats in the yard");
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		while (result) {
			m.appendReplacement(sb, "dog");
			result = m.find();
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}