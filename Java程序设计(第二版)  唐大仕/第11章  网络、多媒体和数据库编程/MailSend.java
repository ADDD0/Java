
/*
 * @(#)MailSend.java
 */

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailSend extends Object {
	public static void main(String[] args) {

		String smtpServer = null;
		String toEmail = null;
		String fromEmail = null;
		String body = null;

		// 分析命令行参数
		for (int x = 0; x < args.length - 1; ++x) {
			if (args[x].equalsIgnoreCase("-S"))
				smtpServer = args[x + 1];
			else if (args[x].equalsIgnoreCase("-T"))
				toEmail = args[x + 1];
			else if (args[x].equalsIgnoreCase("-F"))
				fromEmail = args[x + 1];
			else if (args[x].equalsIgnoreCase("-B"))
				body = args[x + 1];
		}

		if (smtpServer == null || toEmail == null || fromEmail == null || body == null) {
			System.out.println("Usage: javamail_send -S <server> -T <toemail> -F <from> -B <body>");
			System.exit(1);
		}

		// 得到一个session
		try {
			// 设置默认的参数
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", smtpServer);
			props.put("mail.smtp.port", "25");

			// 创建session和一个新的邮件信息
			Session mailSession = Session.getInstance(props);
			Message msg = new MimeMessage(mailSession);

			// 创建FROM, TO, DATE和SUBJECT部分
			msg.setFrom(new InternetAddress(fromEmail));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			msg.setSentDate(new Date());
			msg.setSubject("Test Mail");

			// 创建邮件本体
			msg.setText(body);
			Transport.send(msg);
			System.out.println("The email below was sent successfully");
			msg.writeTo(System.out);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}