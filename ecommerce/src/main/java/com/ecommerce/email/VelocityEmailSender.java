//package com.ecommerce.email;
//
//
//import com.sun.mail.smtp.SMTPTransport;
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.StringWriter;
//import java.io.Writer;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//public class VelocityEmailSender {
//
//
//    // for example, smtp.mailgun.org
//    private static final String SMTP_SERVER = "smtp server ";
//    private static final String USERNAME = "malleswar.ecommerce@gmail.com";
//    private static final String PASSWORD = "malleswar";
//
//    private static final String EMAIL_FROM = "malleswar.ecommerce@gmail.com";
//    private static final String EMAIL_TO = "malleswar.mca@gmail.com, malleswar.ecommerce@gmail.com";
//    private static final String EMAIL_TO_CC = "";
//
//    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP (HTML)";
//    private static final String EMAIL_TEXT = getEmailContent();
//
//    public static void main(String[] args) throws MessagingException {
//
//        Properties prop = System.getProperties();
//        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.port", "25"); // default port 25
//
//        Session session = Session.getInstance(prop, null);
//        Message msg = new MimeMessage(session);
//
//            try {
//
//                msg.setFrom(new InternetAddress(EMAIL_FROM));
//
//                msg.setRecipients(Message.RecipientType.TO,
//                        InternetAddress.parse(EMAIL_TO, false));
//
//                msg.setSubject(EMAIL_SUBJECT);
//
//                // TEXT email
//                //msg.setText(EMAIL_TEXT);
//
//                // HTML email
//                msg.setDataHandler(new DataHandler(new HTMLDataSource(EMAIL_TEXT)));
//
//
//                SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
//
//                // connect
//                t.connect(SMTP_SERVER, USERNAME, PASSWORD);
//
//                // send
//                t.sendMessage(msg, msg.getAllRecipients());
//
//                System.out.println("Response: " + t.getLastServerResponse());
//
//                t.close();
//
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        static class HTMLDataSource implements DataSource {
//
//            private String html;
//
//            public HTMLDataSource(String htmlString) {
//                html = htmlString;
//            }
//
//            @Override
//            public InputStream getInputStream() throws IOException {
//                if (html == null) throw new IOException("html message is null!");
//                return new ByteArrayInputStream(html.getBytes());
//            }
//
//            @Override
//            public OutputStream getOutputStream() throws IOException {
//                throw new IOException("This DataHandler cannot write HTML");
//            }
//
//            @Override
//            public String getContentType() {
//                return "text/html";
//            }
//
//            @Override
//            public String getName() {
//                return "HTMLDataSource";
//            }
//        }
//
//    private static String getEmailContent() {
//        VelocityEngine velocity = new VelocityEngine();
//
//        Properties properties = new Properties();
//        properties.setProperty("resource.loader", "class");
//        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
//        velocity.init(properties);
//        Writer writer = new StringWriter();
//        Template t = velocity.getTemplate("com/ecommerce/email/emailBody.vm");
//
//        VelocityContext context = new VelocityContext();
//        context.put("firstName", "Malleswar ");
//        context.put("lastName", "Reddy");
//
//
//        velocity.mergeTemplate("com/ecommerce/email/emailBody.vm", "UTF-8", context, writer);
//        try {
//            writer.flush();
//        } catch (IOException e) {
//            throw new IllegalStateException(e);
//        }
//        return writer.toString();
//    }
//
//
//}