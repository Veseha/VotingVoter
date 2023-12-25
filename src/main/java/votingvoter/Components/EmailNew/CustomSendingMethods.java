//package votingvoter.Components.EmailNew;
//
//
//import votingvoter.Repository.*;
//import org.springframework.mail.javamail.JavaMailSender;
//
//public class CustomSendingMethods {
//    // WARNING and some letters.
//    // This class is made for custom functions for call from another method, but
//    // these custom functions cannot use for send email directly, if you need
//    // send email, make a "pipe" to EventNotification class, like below
//    // SendNotificationPPWOutOfDate. This needs it only to support the logic
//    // and to keep clean the code. Thanks!
//
//    MessagesRep messagesRep;
//    EmployeeRep employeeRep;
//    EventNotifications en;
//    public CustomSendingMethods( MessagesRep messagesRep, EmployeeRep employeeRep, NotificationRep notificationRep, SubjectsRep subjectsRep){
//        this.messagesRep = messagesRep;
//        this.employeeRep = employeeRep;
//        en = new EventNotifications(messagesRep, employeeRep, executorPPWRep, notificationRep, subjectsRep);
//    }
//
//    //Callable part
//    public void SendNotificationPPWOutOfDate(PPW ppw, JavaMailSender jms){ en.SendNotificationPPWOutOfDate(ppw, jms);}
//    public void SendNotificationTaskOutOfDate(Task task, JavaMailSender jms){ en.SendNotificationTaskOutOfDate(task, jms);}
//
//    // Test part
//    public void DummyMethod(){
//        System.out.println("It's alive!!!");
//    }
//}
