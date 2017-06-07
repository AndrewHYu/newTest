package webTest;


import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * Created by Andrew on 2016/4/5.
 */
public class MailTest {
    public static void main(String[] args)throws MessagingException,IOException
    {
        Properties props=new Properties();
        try(InputStream in= Files.newInputStream(Paths.get("C:\\project\\newTest/source","mail.properties")))
        {
            props.load(in);
        }
        List<String> lines=Files.readAllLines(Paths.get("E:\\hh\\message.txt"), Charset.forName("UTF-8"));
        String from=lines.get(0);
        String to=lines.get(1);
        String subject=lines.get(2);
        System.out.println(from+to+subject);
        StringBuilder builder=new StringBuilder();
        for (int i=3;i<lines.size();i++)
        {
            builder.append(lines.get(i));
            builder.append("\n");
        }
      //  Console console=System.console();
        //String password=new String(console.readPassword("password:"));
        //Scanner in=new Scanner(System.in);
        Session mailSession=Session.getInstance(props);
//        mailSession.setDebug(true);
//        Store store=mailSession.getStore("imap");
//        store.connect("imap.163.com","18883992082@163.com","huangyu666");
//        Folder folder=store.getFolder("inbox");
//        System.out.println(folder.getMessageCount());
//        folder.open(Folder.READ_ONLY);
//        Message messages[]=folder.getMessages();
//        for (Message message:
//             messages) {
////            message.isMimeType("");
////            System.out.println(message.getContent());
//        }
        MimeMessage message=new MimeMessage(mailSession);
//        message.getSentDate();message.getContent();
        message.setFrom(new InternetAddress(from,"重庆邮电大学教务处"));//"重庆邮电大学教务处"
        message.addRecipient(MimeMessage.RecipientType.CC,new InternetAddress("1226392659@qq.com"));
        message.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
        message.setSubject(subject);

        message.setText(builder.toString());
        System.out.println(builder.toString());
        Transport tr=mailSession.getTransport();
        try{
            //tr.connect();
            System.out.println(from);
            tr.connect("AndrewHuangYu@yahoo.com","huangyu123456789");//pujtvaoxhrwwbiac  qsxbxbbyeytzbjad huangyu666 ayoebnqdxokbbjdg
//            Folder folder1=mailSession.getFolder();
//            Folder folder=mailSession.getStore().getFolder()
            tr.sendMessage(message,message.getAllRecipients());
        }finally {
            tr.close();
        }
    }
}
