package demo.selenium;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AAAAAAAAA {
	
	 private static String USER_NAME = "choudharyritesh1908@gmail.com";
	    private static String PASSWORD = "aaditi@1908";
	    private static String RECIPIENT = "abc@seecs.edu.pk";

	    public static void main(String[] args) {
	        String from = USER_NAME;
	        String pass = PASSWORD;
	        String[] to = { RECIPIENT };
	        String subject = "Java send mail example";
	        String body = "Welcome to JavaMail!";

	        sendFromGMail("choudharyritesh1908@gmail.com", pass, to, subject, body);
	        System.out.println("sent");
	    }

	    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[1];

	            for( int i = 0; i < 1; i++ ) {
	                toAddress[i] = new InternetAddress("hariyadav0891@gmail.com");
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            
	            
	            
	            
	            
	        	// Create object to add multimedia type content
     			BodyPart messageBodyPart1 = new MimeBodyPart();
//
//     			// Set the body of email
    			messageBodyPart1.setText("This is message body1");
//
//     			// Create another object to add another content
  			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//
//     			// Mention the file which you want to send
    			String filename = "E:/testing/selenium_workspace/selenium/Extend_Report/ExtentReport.html";
//
//     			// Create data source and pass the filename
    			DataSource source = new FileDataSource(filename);
    			System.out.println(source.getContentType());
//
//     			// set the handler
     			messageBodyPart2.setDataHandler(new DataHandler(source));
//
//     			// set the file
    			messageBodyPart2.setFileName(filename);
//
//     			// Create object of MimeMultipart class
    			Multipart multipart = new MimeMultipart();

     			// add body part 1
     			//multipart.addBodyPart(messageBodyPart2);

     			// add body part 2
     			multipart.addBodyPart(messageBodyPart1);

     			// set the content
     			message.setContent(multipart);

	            
	            
	            
	            
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	        System.out.println("mail send");
	    }

}
