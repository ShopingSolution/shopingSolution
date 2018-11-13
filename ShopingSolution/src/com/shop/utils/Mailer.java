package com.shop.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	// public static Message message = null;
	private Properties props;

	private String id;
	private String pwd;
	private String title;
	private String content;
	private String fromMail;
	private String fromUser;
	private String[] toEmail;

	private String mail_smtp_host = "smtp.naver.com";
	private String mail_smtp_socketFactory_port = "465";
	private String mail_smtp_socketFactory_class = "javax.net.ssl.SSLSocketFactory";
	private String mail_smtp_auth = "true";
	private String mail_smtp_port = "465";

	{
		// TODO SMTP Properties Setting
		props = new Properties();
		props.put("mail.smtp.host", mail_smtp_host);
		props.put("mail.smtp.socketFactory.port", mail_smtp_socketFactory_port);
		props.put("mail.smtp.socketFactory.class", mail_smtp_socketFactory_class);
		props.put("mail.smtp.auth", mail_smtp_auth);
		props.put("mail.smtp.port", mail_smtp_port);
	}

	public Mailer(String id, String pwd, String title, String content, String fromMail, String fromUser,
			String... toEmail) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.fromMail = fromMail;
		this.fromUser = fromUser;
		this.toEmail = toEmail;
	}

	public void execute() throws Exception {
		Session session = Session.getInstance(this.props, null);

		MimeMessage message = new MimeMessage(session);

		message.setSubject(this.title); // title
		message.setText(content); // content

		Address fromAddr = new InternetAddress(this.fromMail, this.fromUser);

		message.setFrom(fromAddr); // from

		for (String email : this.toEmail) {
			Address toAddr = new InternetAddress(email);
			message.addRecipient(Message.RecipientType.TO, toAddr);
		}

		Transport trans = null;

		trans = session.getTransport("smtp");
		trans.connect("smtp.naver.com", id, pwd);

		trans.sendMessage(message, message.getAllRecipients());

		trans.close();

	}

	public static String getAuthKey(int length) {
		String result = "";
		String keyChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * keyChar.length());
			result += keyChar.charAt(index);
		}

		return result;
	}
}
