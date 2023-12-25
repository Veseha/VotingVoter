package votingvoter.Components.EmailNew;

import votingvoter.Const;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import votingvoter.Security.SecurityConst;

import java.util.Properties;

@Configuration
public class EmailAPI {
    @Bean
    public JavaMailSender getJavaMailSender() {
    // Settings for Intranet
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(Const.host_email);
//        mailSender.setPort(Const.host_email_port);
//        mailSender.setUsername(Const.email_from_address);
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "false");
//        props.put("mail.debug", "true");
//        return mailSender;

    // Settings for Internet
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(SecurityConst.host_email_sev);
        mailSender.setPort(SecurityConst.host_email_port_sev);
        mailSender.setUsername(SecurityConst.email_from_address_sev);
        mailSender.setPassword(SecurityConst.password_email_sev);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.debug", "true");
        return mailSender;
    }
}
