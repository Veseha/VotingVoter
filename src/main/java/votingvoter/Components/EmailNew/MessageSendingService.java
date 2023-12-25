//package votingvoter.Components.EmailNew;
//
//import votingvoter.Const;
//import votingvoter.Model.PPW;
//import votingvoter.Model.Task;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MessageSendingService {
//    public void SendEmailMet(String reciever, String subject, String message_text, JavaMailSender getJavaMailSender){
//
//        try{
//            MimeMessage message = getJavaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//            message.setContent(message_text, "text/html;charset=utf8");
//
//            helper.setFrom(Const.email_from_address_sev);
//            helper.setTo(reciever);
//            helper.setSubject(subject);
//            getJavaMailSender.send(message);
//        } catch (MessagingException ex){
//            System.out.println(ex);
//            System.out.println("ERROR");
//        }
//    }
//    public void SendEmailMet(List<String> reciever, String subject, String message_text, JavaMailSender getJavaMailSender){
//        try{
//            MimeMessage message = getJavaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//            message.setContent(message_text, "text/html;charset=utf8");
//
//            helper.setFrom(Const.email_from_address_sev);
//            System.out.println(subject);
//            System.out.println(reciever);
//            System.out.println(reciever.get(0));
//            System.out.println("-----------------------------------------------------------------------------------");
//            helper.setTo(reciever.toArray(new String[0]));
//            helper.setSubject(subject);
//            getJavaMailSender.send(message);
//        } catch (MessagingException ex){
////            LOGGER.info("ERROR");
//        }
//    }
//    protected void SendEmailForTask(Task task, String message_temp, JavaMailSender getJavaMailSender, String subject_temp, List<String> email_temp){
//        List<String> email;
//        System.out.println("Here we are");
//        if(email_temp != null){
//            email = email_temp;
//        }
//        else{
//            email = new ArrayList<>();
//            email.add(task.getExecutor().getEmail());
//        }
//        System.out.println(email);
//        String middle_message = String.format(Const.message_about_task,
//                Const.server_address + Const.page_edittask + task.getId_task(),
//                Const.server_address + Const.page_ppw + task.getPpw().getId(),
//                task.getName_task(),
//                task.getNe_().getNename(),
//                task.getExecutor().getName(),
//                task.getWorkdate(),
//                task.getStatus().getName(),
//
//                task.getPpw().getName(),
//                task.getPpw().getCrq(),
//                task.getPpw().getTeam().getName(),
//                task.getPpw().getExecutors_list(),
//                task.getPpw().getPlaneddate(),
//                task.getPpw().getWorkdate(),
//                task.getPpw().getNe_list(),
////                task.getPpw().getTeam().getNEtypeList(teamNEtypeRep),
//                task.getPpw().getTeam().getNetype_list(),
//                task.getPpw().getTeam().getCity().getName());
//
//        String message = Const.message_template_1 + String.format(message_temp, task.getWorkdate(), task.getName_task()) + Const.message_template_2 + middle_message + Const.message_template_3;
//        String subject = String.format(subject_temp, task.getName_task());
//
//        SendEmailMet( email, subject, message, getJavaMailSender);
//    }
//    protected void SendEmailForPPW(PPW ppw, String message_temp, JavaMailSender getJavaMailSender, String subject_temp, List<String> emails){
//        String middle_message = String.format(Const.message_about_work,
//                Const.server_address + Const.page_qppw + ppw.getId(),
//                Const.server_address + Const.page_ppw + ppw.getId(),
//                ppw.getName(),
//                ppw.getCrq(),
//                ppw.getTeam().getName(),
//                ppw.getExecutors_list(),
//                ppw.getPlaneddate(),
//                ppw.getWorkdate(),
//                ppw.getNe_list(),
////                ppw.getTeam().getNEtypeList(teamNEtypeRep),
//                ppw.getTeam().getNetype_list(),
//                ppw.getTeam().getCity().getName());
//
//        String message = Const.message_template_1 + String.format(message_temp, ppw.getWorkdate(), ppw.getName()) + Const.message_template_2 + middle_message + Const.message_template_3;
//        String subject = String.format(subject_temp, ppw.getName());
//
//        SendEmailMet(emails, subject, message, getJavaMailSender);
//    }
//    protected void SendEmailForPPWPlanned(PPW ppw, String message_temp, JavaMailSender getJavaMailSender, String subject_temp, List<String> emails){
//        String middle_message = String.format(Const.message_about_work,
//                Const.server_address + Const.page_qppw + ppw.getId(),
//                Const.server_address + Const.page_ppw + ppw.getId(),
//                ppw.getName(),
//                ppw.getCrq(),
//                ppw.getTeam().getName(),
//                ppw.getExecutors_list(),
//                ppw.getPlaneddate(),
//                ppw.getWorkdate(),
//                ppw.getNe_list(),
////                ppw.getTeam().getNEtypeList(teamNEtypeRep),
//                ppw.getTeam().getNetype_list(),
//                ppw.getTeam().getCity().getName());
//
//        String message = Const.message_template_1 + String.format(message_temp, ppw.getPlaneddate(), ppw.getName()) + Const.message_template_2 + middle_message + Const.message_template_3;
//        String subject = String.format(subject_temp, ppw.getName());
//
//        SendEmailMet(emails, subject, message, getJavaMailSender);
//    }
//    protected void SendEmailNotify(String message_temp, JavaMailSender getJavaMailSender, String subject_temp, List<String> emails){
//        String message = Const.message_template_1 + message_temp + Const.message_template_2 + Const.message_template_3;
//        String subject = String.format(subject_temp);
//
//        SendEmailMet(emails, subject, message, getJavaMailSender);
//    }
//}
