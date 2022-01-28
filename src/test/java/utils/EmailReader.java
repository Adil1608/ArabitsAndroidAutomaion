package utils;
import org.json.simple.JSONObject;


import java.util.Hashtable;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;


public class EmailReader {
    public static String subject;
    public static String body;
    public static String verificationCode;
    public static Hashtable<String, String> email_dict = new Hashtable<String, String>();
    static JSONObject userCredentials = ConfigReader.getUserConfig();
    static String user = userCredentials.get("email").toString();
    static String password = userCredentials.get("password").toString();

    /**returns body of the last unread email with "Verification Code" subject*/
    public static Hashtable<String, String> fetch() {

        String host = "imap.gmail.com";
        String mailStoreType = "imap";

        try {
            // create properties
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
            System.out.println("Total unread messages:" + messages.length);

            // letting loop go over all unread messages and return body of the last one
            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                message.setFlag(Flag.SEEN, true);
                if (message.getSubject().contains("Verification Code")) {


                    body = message.getContent().toString();
                    subject =  message.getSubject();

                    email_dict.put("subject", subject);
                    email_dict.put("body", body);

//                     System.out.println("---------------------------------");
//                     System.out.println("Email Number " + (i + 1));
//                     System.out.println("Subject: " + subject);
//                     System.out.println("From: " + message.getFrom()[0]);

//                    my_dict.get("10");
//                    .remove("10");
//                    .size()
//                    .isEmpty()
//                    System.out.println("\nValue at key = 10 : " + my_dict.get("10"));
//                    System.out.println("Value at key = 11 : " + my_dict.get("11"));

                    // String s=String.valueOf(i);
                    // System.out.println("fetch::Body message " + s + " :" + bodyMessage);
                }
            }
            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email_dict;
    }

    public static String getVerificationCode() {

        Hashtable<String, String> email = fetch();
        String bodyMessage = email.get("body");

        if (!email_dict.isEmpty()) {
            Pattern MY_PATTERN = Pattern.compile("Your verification Code: \\<b\\>(\\d+)\\<\\/b\\>");
            Matcher m = MY_PATTERN.matcher(bodyMessage);
            while (m.find()) {
                verificationCode = m.group(1);
            }
            System.out.println("Verification code: " + verificationCode);

        } else {
            String msg = "Couldn't find appropriate email";
            System.out.println(msg);
        }
    return verificationCode;
    }
}


