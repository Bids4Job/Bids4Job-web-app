package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.PropertiesFileUtils;

public class EmailUtils {
	// Database credentials
	private static final String CONFIG_FILE = "config.properties";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "email.password";

	private static Properties emailProperties;
	private static Session mailSession;
	private static MimeMessage emailMessage;

	private static final String emailHost = "smtp.gmail.com";
	// gmail's smtp port
	private static final String emailPort = "587";
	// your gmail id
	private static final String fromUser = PropertiesFileUtils.getPropertyValue(CONFIG_FILE, EMAIL);
	private static final String fromUserEmailPassword = PropertiesFileUtils.getPropertyValue(CONFIG_FILE, PASSWORD);
	private static final String[] toEmails = { "bid4job@outlook.com" };

	public static void setMailServerProperties() {
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
	}

	public static void createEmailMessage(String emailSubject, String emailBody)
			throws AddressException, MessagingException {
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}
		emailMessage.setSubject(emailSubject);
		// for a html email
		emailMessage.setContent(emailBody, "text/html");
		// emailMessage.setText(emailBody);// for a text email

	}

	public static void sendEmail() throws AddressException, MessagingException {
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
	}
}
