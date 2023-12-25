//package votingvoter.Components.EmailNew;
//
//// import votingvoter.Model.Consts.EPrivileges;
//
//import votingvoter.Model.Email.Notification;
//import votingvoter.Model.User;
//
//import votingvoter.Repository.*;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class EventNotifications {
//    // Some letters.
//    // This class needs to send the notifications which called by some event.
//    // Events are called manually.
//
//    // Service variables part
//    MessageSendingService mss = new MessageSendingService();
//    MessagesRep messagesRep;
//    EmployeeRep employeeRep;
////    PrivilegesRep privilegesRep;
//    NotificationRep notificationRep;
//    SubjectsRep subjectsRep;
//
//    // Initialization part
//    public EventNotifications( MessagesRep messagesRep, EmployeeRep employeeRep,  NotificationRep notificationRep, SubjectsRep subjectsRep){
//        this.messagesRep = messagesRep;
//        this.employeeRep = employeeRep;
////        this.privilegesRep = privilegesRep;
//        this.notificationRep = notificationRep;
//        this.subjectsRep = subjectsRep;
//    }
//
//    // Service functions part
//    private String GetMessages(String stage){
//        return messagesRep.findByStage(stage).get(0).getMessage();
//    }
//    private String GetSubject(String stage){ return subjectsRep.findByStage(stage).get(0).getSubject();}
//
//    // Sub-functions part
//    private void SendBossNotificationPPW(PPW ppw, JavaMailSender jms){
//        try {
//            ArrayList<String> boss_email = new ArrayList<>();
//            boss_email.add(teamService.getBoss(ppw.getTeam()).getEmail());
//            if(Objects.equals(ppw.getStatus().getName(), "Planned"))
//                // For work with status planned
//                mss.SendEmailForPPW(ppw, GetMessages("boss_notify"), jms, GetSubject("subject_ppw"), boss_email);
//
//            else if(Objects.equals(ppw.getStatus().getName(), "Assigned"))
//                // For work with status assigned
//                mss.SendEmailForPPW(ppw, GetMessages("boss_notify"), jms, GetSubject("subject_ppw"), boss_email);
//
//        } catch (Exception e){
//            System.out.println(e);
//            System.out.println("Boss not found");
//        }
//
//    }
//    private void SendTeamLeadNotificationPPW(PPW ppw, JavaMailSender jms){
//        try {
//            ArrayList<String> teamlead_emails = new ArrayList<>();
//            teamlead_emails.add(teamService.getTeamLead(ppw.getTeam()).getEmail());
//            if(Objects.equals(ppw.getStatus().getName(), "Planned"))
//                // For work with status planned
//                mss.SendEmailForPPW(ppw, GetMessages("boss_notify"), jms, GetSubject("subject_ppw"), teamlead_emails);
//
//            else if(Objects.equals(ppw.getStatus().getName(), "Assigned"))
//                // For work with status assigned
//                mss.SendEmailForPPW(ppw, GetMessages("boss_notify"), jms, GetSubject("subject_ppw"), teamlead_emails);
//
//        } catch (Exception e){
//            System.out.println(e);
//            System.out.println("Team lead not found");
//        }
//
//    }
//    private void SendExecutorsNotificationPPW(PPW ppw, JavaMailSender jms, String stage_planned, String stage_assigned){
//        // Already uses in Reminder (parent scheduler)
//        try {
//            ArrayList<String> executors_emails = new ArrayList<>();
//            for (ExecutorPPW emp: executorPPWRep.findByppw(ppw)) {
//                executors_emails.add(emp.getEmployee().getEmail());
//            }
//            if(Objects.equals(ppw.getStatus().getName(), "Planned"))
//                // For work with status planned
//                mss.SendEmailForPPW(ppw, GetMessages(stage_planned), jms, GetSubject("subject_ppw"), executors_emails);
//
//            else if(Objects.equals(ppw.getStatus().getName(), "Assigned"))
//                // For work with status assigned
//                mss.SendEmailForPPW(ppw, GetMessages(stage_assigned), jms, GetSubject("subject_ppw"), executors_emails);
//            else
//                mss.SendEmailForPPW(ppw, GetMessages(stage_assigned), jms, GetSubject("subject_ppw"), executors_emails);
//
//
//        } catch (Exception e){
//            System.out.println(e);
//            System.out.println("Executors not found");
//        }
//    }
//    private void SendTeamNotificationPPW(PPW ppw, JavaMailSender jms, String stage_planned, String stage_assigned){
//
//        try {
//            ArrayList<String> employee_emails = new ArrayList<>();
//            for (User empl: employeeRep.findByTeam(ppw.getTeam())) {
//                employee_emails.add(empl.getEmail());
//            }
//            System.out.println(employee_emails);
//            if(Objects.equals(ppw.getStatus().getName(), "Planned"))
//                // For work with status planned
//                mss.SendEmailForPPW(ppw, GetMessages(stage_planned), jms, GetSubject("subject_ppw"), employee_emails);
//
//            else if(Objects.equals(ppw.getStatus().getName(), "Assigned"))
//                // For work with status assigned
//                mss.SendEmailForPPW(ppw, GetMessages(stage_assigned), jms, GetSubject("subject_ppw"), employee_emails);
//            else
//                // For work with status assigned
//                mss.SendEmailForPPW(ppw, GetMessages(stage_assigned), jms, GetSubject("subject_ppw"), employee_emails);
//
//        } catch (Exception e){
//            System.out.println(e);
//            System.out.println("User not found");
//        }
//    }
//    private void SendBossNotificationTask(Task task, JavaMailSender jms){
//        try {
//            ArrayList<String> boss_email = new ArrayList<>();
//            boss_email.add(teamService.getBoss(task.getPpw().getTeam()).getEmail());
//            if(Objects.equals(task.getStatus().getName(), "Assigned"))
//                // For work with status assigned
//                mss.SendEmailForTask(task, GetMessages("boss_notify"), jms, GetSubject("subject_task"), boss_email);
//
//        } catch (Exception e){
//            System.out.println(e);
//            System.out.println("Boss not found");
//        }
//
//    }
//    private void SendTeamLeadNotificationTask(Task task, JavaMailSender jms){
//        try {
//            ArrayList<String> teamlead_emails = new ArrayList<>();
//            teamlead_emails.add(teamService.getTeamLead(task.getPpw().getTeam()).getEmail());
//            if(Objects.equals(task.getStatus().getName(), "Assigned"))
//                // For work with status assigned
//                mss.SendEmailForTask(task, GetMessages("boss_notify"), jms, GetSubject("subject_task"), teamlead_emails);
//
//        } catch (Exception e){
//            System.out.println(e);
//            System.out.println("Team lead not found");
//        }
//
//    }
//
//    // Callable part
//    public void SendNotificationPPWOutOfDate(PPW ppw, JavaMailSender jms){
//        this.SendBossNotificationPPW(ppw, jms);
//        this.SendTeamLeadNotificationPPW(ppw, jms);
//    }
//    public void SendNotificationTaskOutOfDate(Task task, JavaMailSender jms){
//        this.SendBossNotificationTask(task, jms);
//        this.SendTeamLeadNotificationTask(task, jms);
//    }
//    public void SendNotificationFinishPPW(PPW ppw, JavaMailSender jms){
//        this.SendTeamNotificationPPW(ppw, jms, "completed", "completed");
//    }
//    public Boolean SendNotificationAddNewEmployee(User new_employee, JavaMailSender jms){
//        try{
//            Notification notification = notificationRep.findByEvent("new_employee");
//            String subject = notification.getSubject().getSubject();
//            String message = notification.getMessage().getMessage();
//            List<String> emails = new ArrayList<>();
//            emails.add(new_employee.getEmail());
//
//            mss.SendEmailNotify(message, jms, subject, emails);
//            return true;
//        }
//        catch (Exception e){
//            return false;
//        }
//    }
//    public Boolean SendNotificationDeleteEmployee(User new_employee, JavaMailSender jms){
//        Notification notification = notificationRep.findByEvent("delete_employee");
//        String subject = notification.getSubject().getSubject();
//        String message = notification.getMessage().getMessage();
//        List<String> emails = new ArrayList<>();
//        emails.add(new_employee.getEmail());
//        System.out.println(emails);
//
//        mss.SendEmailNotify(message, jms, subject, emails);
//        return true;
////        try{
////            System.out.println("f");
////        }
////        catch (Exception e){
////            System.out.println(e);
////            return false;
////        }
//    }
//    public Boolean SendNotificationTeamLeadToAddPPWToNextYear(List<String> emails,  JavaMailSender jms){
//        try{
//            Notification notification = notificationRep.findByEvent("team_lead_notify");
//            String subject = notification.getSubject().getSubject();
//            String message = notification.getMessage().getMessage();
//
//            mss.SendEmailNotify(message, jms, subject, emails);
//            return true;
//        }
//        catch (Exception e){
//            return false;
//        }
//    }
//    public void SendNotificationChangePlannedDate(){}
//
//}
