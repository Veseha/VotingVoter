//package votingvoter.Components.EmailNew;
//
//import votingvoter.Model.User;
//import votingvoter.Model.PPW;
//import votingvoter.Repository.*;
//import org.springframework.mail.javamail.JavaMailSender;
//
//public class EventNotificationsAsync extends Thread {
//    EventNotifications en;
//    PPW ppw;
//    JavaMailSender jms;
//    NotificationType nt;
//    User employee;
//    public EventNotificationsAsync(PPW ppw, JavaMailSender getJavaMailSender, MessagesRep messagesRep, UserRep employeeRep, ExecutorPPWRep executorPPWRep, NotificationRep notificationRep, SubjectsRep subjectsRep, NotificationType NT){
//        this.jms = getJavaMailSender;
//        this.ppw = ppw;
//        this.nt = NT;
//        en = new EventNotifications(messagesRep, employeeRep, executorPPWRep, notificationRep, subjectsRep);
//
//    }
//    public EventNotificationsAsync(User employee, JavaMailSender getJavaMailSender, MessagesRep messagesRep, UserRep employeeRep, ExecutorPPWRep executorPPWRep, NotificationRep notificationRep, SubjectsRep subjectsRep, NotificationType NT){
//        this.jms = getJavaMailSender;
//        this.employee = employee;
//        this.nt = NT;
//
//        en = new EventNotifications(messagesRep, employeeRep, executorPPWRep, notificationRep, subjectsRep);
//
//    }
//
//    public void run(){
//        System.out.println("ASYNC Method");
//        if(nt == NotificationType.COMPLETED) {
//            en.SendNotificationFinishPPW(ppw, jms);
//        }
//        else if(nt == NotificationType.CANCELED){
//
//        }
//        else if(nt == NotificationType.NEW_EMPLOYEE) {
//            en.SendNotificationAddNewEmployee(employee, jms);
//        }
//        System.out.println("SEND");
//    }
//
//    public static enum NotificationType{
//        COMPLETED,
//        CANCELED,
//        NEW_EMPLOYEE
//    }
//}