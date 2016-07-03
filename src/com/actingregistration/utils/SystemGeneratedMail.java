package com.actingregistration.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SystemGeneratedMail {
	public static boolean sendMail(String mailId, String msg, String subject){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		

		try {
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("testdata821@gmail.com","testdata123");
						}
					});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("testdata821@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ajitrocks.k@gmail.com"));
			message.setSubject("System Generated Mail");
			message.setText("This is system generated Mail" +
					"\n\n Please Do not reply");

			Transport.send(message);

			System.out.println("Done");
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
