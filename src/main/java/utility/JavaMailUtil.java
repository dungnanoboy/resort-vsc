package utility;

import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class JavaMailUtil {

	// Phương thức gửi mail đơn giản
	public static void sendMail(String recipientMailId) throws MessagingException {

		System.out.println("Preparing to send Mail");
		
		// Thiết lập các thuộc tính cho việc gửi mail
		Properties properties = new Properties();
		String host = "smtp.gmail.com";
		properties.put("mail.smtp.host", host);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");

		// Load cấu hình từ file application.properties
		ResourceBundle rb = ResourceBundle.getBundle("application");
		
		// Lấy thông tin đăng nhập từ cấu hình
		String emailId = rb.getString("mailer.email");
		String passWord = rb.getString("mailer.password");

		// Thiết lập thông tin đăng nhập trong thuộc tính
		properties.put("mail.user", emailId);
		properties.put("mail.password", passWord);

		// Tạo một phiên gửi mail sử dụng thông tin và Authenticator đã thiết lập
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailId, passWord);
			}

		});

		// Chuẩn bị thông điệp và gửi mail
		Message message = prepareMessage(session, emailId, recipientMailId);

		// Gửi mail
		Transport.send(message);

		System.out.println("Message Sent Successfully!");

	}

	// Phương thức chuẩn bị thông điệp cho mail đơn giản
	private static Message prepareMessage(Session session, String myAccountEmail, String recipientEmail) {

		try {

			Message message = new MimeMessage(session);

			// Thiết lập thông điệp
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
			message.setSubject("Welcome to Dunhuth Resort");
			message.setText("Hey! " + recipientEmail + ", Thanks  for Signing Up with us!");
			return message;

		} catch (Exception exception) {
			// Log lỗi nếu có
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, exception);
		}
		return null;

	}

	// Phương thức gửi mail HTML
	protected static void sendMail(String recipient, String subject, String htmlTextMessage) throws MessagingException {

		System.out.println("Preparing to send Mail");
		Properties properties = new Properties();
		String host = "smtp.gmail.com";
		properties.put("mail.smtp.host", host);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");

		ResourceBundle rb = ResourceBundle.getBundle("application");

		String emailId = rb.getString("mailer.email");
		String passWord = rb.getString("mailer.password");

		properties.put("mail.user", emailId);
		properties.put("mail.password", passWord);

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailId, passWord);
			}

		});

		Message message = prepareMessage(session, emailId, recipient, subject, htmlTextMessage);

		Transport.send(message);

		System.out.println("Message Sent Successfully!");

	}

	// Phương thức chuẩn bị thông điệp cho mail HTML
	private static Message prepareMessage(Session session, String myAccountEmail, String recipientEmail, String subject,
			String htmlTextMessage) {

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
			message.setSubject(subject);
			message.setContent(htmlTextMessage, "text/html");
			return message;

		} catch (Exception exception) {
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, exception);
		}
		return null;

	}
}



