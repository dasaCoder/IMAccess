package imaccess;
//
//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
//
//public class SendEmail {
//
//    private static String USER_NAME = "dilushadasanayaka@gmail.com";  // GMail user name (just the part before "@gmail.com")
//    private static String PASSWORD = "0112717059"; // GMail password
//    // private static String RECIPIENT = "lizard.bill@myschool.edu";
//
//    public SendEmail(String recipient,String user_name, String password){
//        String from = USER_NAME;
//        String pass = PASSWORD;
//        String[] to = { recipient }; // list of recipient email addresses
//        String subject = "Welcome! " +user_name;
//        String body = "We warmly welcome your to IM Family!... \nUse this password :"+password + " to make you comfortable in entrances";
//
//        sendFromGMail(from, pass, to, subject, body);
//    }
//    // public static void main(String[] args) {
//    //     String from = USER_NAME;
//    //     String pass = PASSWORD;
//    //     String[] to = { RECIPIENT }; // list of recipient email addresses
//    //     String subject = "Java send mail example";
//    //     String body = "Welcome to JavaMail!";
//
//    //     sendFromGMail(from, pass, to, subject, body);
//    // }
//
//    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
//        Properties props = System.getProperties();
//        String host = "smtp.gmail.com";
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.password", pass);
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(props);
//        MimeMessage message = new MimeMessage(session);
//
//        try {
//            message.setFrom(new InternetAddress(from));
//            InternetAddress[] toAddress = new InternetAddress[to.length];
//
//            // To get the array of addresses
//            for( int i = 0; i < to.length; i++ ) {
//                toAddress[i] = new InternetAddress(to[i]);
//            }
//
//            for( int i = 0; i < toAddress.length; i++) {
//                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
//            }
//
//            message.setSubject(subject);
//            message.setText(body);
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host, from, pass);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//        }
//        catch (AddressException ae) {
//            ae.printStackTrace();
//        }
//        catch (MessagingException me) {
//            me.printStackTrace();
//        }
//    }
//}



import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public SendEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("dilushadasanayaka@gmail.com","thjccacmpmmbarmu");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("pabaup@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}